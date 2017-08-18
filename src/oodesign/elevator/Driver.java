package oodesign.elevator;

import oodesign.elevator.entities.ElevatorController;
import oodesign.elevator.clients.Person;

/**
 * Created by mayank.gupta on 04/06/17.
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {
        ElevatorController controller = ElevatorController.getInstance();

        Person suvi = new Person("suvi",0);
        suvi.setRequestedFloor(9);
        controller.requestElevator(suvi);

        Person monu = new Person("monu",0);
        monu.setRequestedFloor(9);
        controller.requestElevator(monu);

        Person sonu = new Person("sonu",0);
        sonu.setRequestedFloor(12);
        controller.requestElevator(sonu);

        Person ronu = new Person("ma",0);
        ronu.setRequestedFloor(18);
        controller.requestElevator(ronu);

        Person tonu = new Person("papa",0);
        tonu.setRequestedFloor(5);
        controller.requestElevator(tonu);

        Thread.currentThread().sleep(30000);

        Person a = new Person("guldu",10);
        a.setRequestedFloor(15);
        controller.requestElevator(a);


        Person b = new Person("muldu",10);
        b.setRequestedFloor(5);
        controller.requestElevator(b);


        Thread.currentThread().sleep(30000);

        System.exit(0);


    }
}
