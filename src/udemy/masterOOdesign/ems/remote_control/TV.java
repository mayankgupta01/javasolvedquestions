package udemy.masterOOdesign.ems.remote_control;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class TV implements DeviceInterface {
    @Override
    public void turnOn() {
        System.out.println("TV is on!");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is off!");
    }
}
