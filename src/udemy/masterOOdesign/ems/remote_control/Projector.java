package udemy.masterOOdesign.ems.remote_control;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class Projector implements DeviceInterface {
    @Override
    public void turnOn() {
        System.out.println("Projector is on!");
    }

    @Override
    public void turnOff() {
        System.out.println("Projector is off!");
    }
}
