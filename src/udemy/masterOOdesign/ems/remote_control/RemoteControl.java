package udemy.masterOOdesign.ems.remote_control;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class RemoteControl {

    public static DeviceInterface getDevice(String deviceName) {
        DeviceInterface device = null;
        switch (deviceName) {
            case "TV":
                device =  new TV();
                break;
            case "PROJECTOR":
                device =  new Projector();
                break;
            case "SURROUNDSOUND":
                device = new SurroundSoundSystem();
                break;
            default:
                System.out.println("Requested device not found");

        }
        return device;
    }

    public void turnOn(DeviceInterface device) {
        device.turnOn();
    }

    public void turnOff(DeviceInterface device) {
        device.turnOff();
    }
}
