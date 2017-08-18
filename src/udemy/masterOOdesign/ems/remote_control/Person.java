package udemy.masterOOdesign.ems.remote_control;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class Person {

    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl();

        DeviceInterface device = RemoteControl.getDevice("TV");
        rc.turnOn(device);
        rc.turnOff(device);

        device = RemoteControl.getDevice("PROJECTOR");
        rc.turnOn(device);
        rc.turnOff(device);
    }
}
