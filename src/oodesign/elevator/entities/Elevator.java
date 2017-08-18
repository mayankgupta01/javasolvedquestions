package oodesign.elevator.entities;

import oodesign.elevator.clients.LiftObserver;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mayank.gupta on 03/06/17.
 *
 * contains the individual elevators
 */
public class Elevator implements Runnable {

    private int elevatorId;
    private volatile int currentFloor;
    private int maxFloor;
    private int minFloor;
    private ElevatorState state;
    private PriorityQueue<Integer> requestedFloorsGoingUp;
    private PriorityQueue<Integer> requestedFloorsGoingDown;
    private Map<Integer, ArrayList<LiftObserver>> onboardedMap;

    private final int maxCapacity = 3;
    private int personsOnBoard;
    private Set<Integer> requestedFloors;

    Elevator(int id, int maxFloor, int minFloor) {
        this.elevatorId = id;
        currentFloor = minFloor;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        initialize();

        System.out.println("Lift id : " + elevatorId + " , current floor : " + currentFloor + ", state :  " + state);
    }

    private void initialize() {
        requestedFloorsGoingUp = new PriorityQueue<>();
        requestedFloorsGoingDown = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        onboardedMap = new ConcurrentHashMap<>();
        requestedFloors = new HashSet<>();
        state = ElevatorState.STAND;
    }

    @Override
    public void run() {
        goToNextStop();

    }

    private synchronized void waitForRequest() {
        while(state == ElevatorState.STAND && requestedFloorsGoingDown.isEmpty() && requestedFloorsGoingUp.isEmpty()) {

            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(Thread.interrupted())
            throw new RuntimeException("Exiting on ElevatorController request!");
    }



    private void goToNextStop() {

        waitForRequest();

        if(state.equals(ElevatorState.OPEN)) {
            ElevatorController.getInstance().arrivedOnFloor(this);
            state = ElevatorState.STAND;
        }

        if(state.equals(ElevatorState.STAND)) {
            if(requestedFloorsGoingDown.isEmpty() || currentFloor == minFloor)
                state = ElevatorState.UP;
            else
                state = ElevatorState.DOWN;
        }

        if(state.equals(ElevatorState.DOWN)) {

            stop(requestedFloorsGoingDown);

        }else {
            stop(requestedFloorsGoingUp);
        }

        //check whether more requests have queued in the meantime
        state = ElevatorState.STAND;

        goToNextStop();
    }


    private void stop(PriorityQueue<Integer> floors) {
        //disembark all passengers, change state to STAND if no more requests are pending, go in current direction if more floors to cover
        // in current direct, else change direction and goToNextStop
        System.out.println("Lift : " + elevatorId + ", current floor : " + currentFloor + ", Direction : " + state);
        while(!floors.isEmpty()) {
            sleep();
            currentFloor = floors.poll();
            System.out.println("Lift id : " + elevatorId + " , current floor : " + currentFloor + ", state :  " + state);

            //disembark all passengers onboard the elevator and wanting to get off on this floor
            disembarkOnStop();

            //notify all passengers waiting to onboard from the currentfloor
            ElevatorController.getInstance().arrivedOnFloor(this);
            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void setState(ElevatorState state) {
        this.state = state;
    }

    public synchronized boolean getOn(LiftObserver person) {
        //update the personsOnBoard

        if(!isFull()) {
            addPersonToElevator(person);
            return true;

        }
        return false;
    }

    private void addPersonToElevator(LiftObserver person) {
        int reqFlr = person.requestedFloor();

        if(onboardedMap.containsKey(reqFlr))
            onboardedMap.get(reqFlr).add(person);
        else {
            ArrayList<LiftObserver> list = new ArrayList<>();
            list.add(person);
            onboardedMap.put(reqFlr,list);
        }

        if(!requestedFloors.contains(reqFlr)) {
            requestedFloors.add(reqFlr);
            if(currentFloor < reqFlr)
                requestedFloorsGoingUp.add(reqFlr);
            else
                requestedFloorsGoingDown.add(reqFlr);
        }
        personsOnBoard += 1;
    }


    private void disembarkOnStop() {
        //Remove all observers from the current stop, increase current capacity
        if(!onboardedMap.containsKey(currentFloor)) {
            System.out.println("Lift : " + elevatorId + " floor : " + currentFloor + ",  No one to disembark!");
        }else {
            System.out.println("All passengers for Lift : "+ elevatorId + " floor : " + currentFloor + ", please leave!");
            onboardedMap.get(currentFloor).forEach( entry -> {
                entry.destinationReached();
                personsOnBoard -=1;
            });
            onboardedMap.get(currentFloor).clear();
        }


    }

    protected void takeRequest(int floor) {
        if(requestedFloors.contains(floor))
            return;

        if(currentFloor > floor) {
            requestedFloorsGoingUp.add(floor);
            System.out.println("Lift : " + elevatorId + " has taken request for floor : " + floor + ". Lift's current floor : " + currentFloor + ", state : " + state + ", \n Request added to going up queue");
        }


        if(currentFloor < floor) {
            requestedFloorsGoingDown.add(floor);
            System.out.println("Lift : " + elevatorId + " has taken request for floor : " + floor + ". Lift's current floor : " + currentFloor + ", state : " + state + ", \n Request added to going down queue");
        }

        if(currentFloor == floor) {
            state = ElevatorState.OPEN;
            System.out.println("Lift : " + elevatorId + " has taken request for floor : " + floor + ". Lift's current floor : " + currentFloor + ", state : " + state);
        }


    }

    protected boolean isFull() {
        return personsOnBoard == maxCapacity;
    }

    protected ElevatorState getState() {
        return state;
    }

    protected int getCurrentFloor() {
        return currentFloor;
    }

    protected boolean canGo(int floor) {
        return floor >= minFloor && floor <= maxFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }
}
