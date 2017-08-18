package oodesign.elevator.clients;

import oodesign.elevator.entities.Elevator;

/**
 * Created by mayank.gupta on 03/06/17.
 */
public class Person implements LiftObserver {

    private String name;
    private int requestedFloor;
    private int currentFloor;
    private Elevator elevator;


    public Person(String name, int currentFloor) {

        this.name = name;
        if(!controller.isValidFloor(currentFloor))
            throw new IllegalArgumentException("Invalid input, floor should be in range 0 to " + controller.totalFloors);
        this.currentFloor = currentFloor;
    }

    public void setRequestedFloor(int floor) {
        if(floor == currentFloor || !controller.isValidFloor(floor))
            throw new IllegalArgumentException("requested floor cannot be same as current floor or invalid input");

        this.requestedFloor = floor;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }



    @Override
    public synchronized boolean onboard(Elevator elevator) {
        if(this.elevator == null && elevator.getOn(this)) {
            this.elevator = elevator;
            System.out.println(name + " - onboarded elevator - " + elevator.getElevatorId() + ", current floor : " + currentFloor + ", requested floor : " + requestedFloor);
            return true;
        }
        return false;
    }

    @Override
    public void destinationReached() {
        System.out.println(name + " - Getting down! Lift :" + elevator.getElevatorId() + ", Floor : " + requestedFloor);
        this.elevator = null;
        this.currentFloor = requestedFloor;
        this.requestedFloor = -1;
    }

    @Override
    public int currentFloor() {
        return currentFloor;
    }

    @Override
    public int requestedFloor() {
        return requestedFloor;
    }

    @Override
    public String getName() {
        return name;
    }
}
