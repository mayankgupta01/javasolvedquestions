package udemy.masterOOdesign.ems.remote_control;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class SurroundSoundSystem implements DeviceInterface {
    @Override
    public void turnOn() {
        System.out.println("Surround system is on!");
    }

    @Override
    public void turnOff() {
        System.out.println("Surround system is off!");
    }
}
