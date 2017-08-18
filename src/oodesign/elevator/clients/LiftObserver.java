package oodesign.elevator.clients;

import oodesign.elevator.entities.Elevator;
import oodesign.elevator.entities.ElevatorController;

/**
 * Created by mayank.gupta on 03/06/17.
 */
public interface LiftObserver {
    public ElevatorController controller = ElevatorController.getInstance();
    public boolean onboard(Elevator elevator);
    public void destinationReached();
    public int currentFloor();
    public int requestedFloor();
    public String getName();
}
