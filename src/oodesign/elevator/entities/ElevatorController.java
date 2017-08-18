package oodesign.elevator.entities;

import oodesign.elevator.clients.LiftObserver;

import java.util.*;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mayank.gupta on 03/06/17.
 */
public class ElevatorController {

    private static ElevatorController INSTANCE;

    private ElevatorController() {
        requestLiftMap = new ConcurrentHashMap<>();
        elevators = new Elevator[4];
        elevators[0] = new Elevator(1,20,0);
        elevators[1] = new Elevator(2,10,0);
        elevators[2] = new Elevator(3,20,0);
        elevators[3] = new Elevator(4,20,10);

        this.executor = Executors.newFixedThreadPool(4);
        for(Elevator elevator : elevators) {
            executor.execute(elevator);
        }
    }

    public static ElevatorController getInstance() {
        if(INSTANCE == null) {
            synchronized (ElevatorController.class) {
                if(INSTANCE == null) {
                    INSTANCE = new ElevatorController();
                }
            }
        }
        return INSTANCE;
    }

    private Elevator[] elevators;
    public final int totalFloors = 20;
    private ExecutorService executor;
    private Map<Integer, ArrayList<LiftObserver>> requestLiftMap;


    public void requestElevator(LiftObserver person) {
        //check which two lifts are closest to the current floor of person and moving in direction of person or at its stop
        registerObserver(person);

        //add requests to two candidate elevators to serve the requests
        for(Elevator elevator : getCandidates(person)) {
            elevator.takeRequest(person.currentFloor());
        }
    }


    private ArrayList<Elevator> getCandidates(LiftObserver person) {
        ArrayList<Elevator> candidates = new ArrayList<>();
        int[] dist = new int[4];
        int curFloor = person.currentFloor();
        int reqFloor = person.requestedFloor();

        for (int i = 0; i < 4; i++) {
            int eleCurFlr = elevators[i].getCurrentFloor();
            ElevatorState state = elevators[i].getState();

            if (eleCurFlr == curFloor)
                dist[i] = 0;

            if (eleCurFlr > curFloor) {
                if (state == ElevatorState.DOWN || state == ElevatorState.STAND)
                    dist[i] = eleCurFlr - curFloor;
                else
                    dist[i] = 2 * (totalFloors - eleCurFlr) + eleCurFlr - curFloor;
            }

            if (eleCurFlr < curFloor) {
                if (state == ElevatorState.UP || state == ElevatorState.STAND)
                    dist[i] = curFloor - eleCurFlr;
                else
                    dist[i] = curFloor + eleCurFlr;
            }
        }
        int counter = 0;
        while (counter < 2) {
            int minIndex = -1;
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                if (dist[i] < minDist && elevators[i].canGo(curFloor) && elevators[i].canGo(reqFloor)) {
                    minDist = dist[i];
                    minIndex = i;
                }
            }

            candidates.add(elevators[minIndex]);
            dist[minIndex] = Integer.MAX_VALUE;
            counter += 1;

        }

        return candidates;

    }

    private void registerObserver(LiftObserver person) {
        // add floor to either of the queues if not already added and add person to map
        ArrayList<LiftObserver> list = requestLiftMap.get(person.currentFloor());
        System.out.println(person.getName() +  " requesting lift on floor : " + person.currentFloor());
        if(list != null) {
            synchronized (list) {
                list.add(person);
            }
        }else {
            list = new ArrayList<>();
            list.add(person);
            requestLiftMap.put(person.currentFloor(), list);
        }
        System.out.println("**************************************");
        System.out.println();
        System.out.println("Current requests for floor : " + person.currentFloor() + "\n");
        list.forEach(entry -> {
            System.out.print(entry.getName() + " ");
        });
        System.out.println();
        System.out.println("**************************************");
    }



    protected void arrivedOnFloor(Elevator elevator) {
        //Get all registered observers waiting for a lift and notify, remove the ones who onboard the lift from map
        ArrayList<LiftObserver> list = requestLiftMap.get(elevator.getCurrentFloor());

        //Use a iterator which allows concurrent modification since new requests could come even when lift is present on the floor
        if(list != null) {
            synchronized (list) {
                Iterator<LiftObserver> iterator = list.iterator();
                while(iterator.hasNext()) {
                    LiftObserver person = iterator.next();
                    if(person.onboard(elevator))
                        iterator.remove();
                }
            }
        }else {
            System.out.println("No one to onboard ! Elevator " + elevator.getElevatorId() + " is moving on. Current Floor : " + elevator.getCurrentFloor() + ", Direction : " + elevator.getState());
        }

    }

    public boolean isValidFloor(int floor) {
        return floor >=0 && floor <= totalFloors;
    }

    public void shutDown() {
        executor.shutdownNow();
        while (!executor.isTerminated()) {
        }
    }

}
