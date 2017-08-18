package udemy.masterOOdesign.ems.remote_control.official_implementation.user;


import udemy.masterOOdesign.ems.remote_control.official_implementation.devices.Projector;
import udemy.masterOOdesign.ems.remote_control.official_implementation.devices.TV;
import udemy.masterOOdesign.ems.remote_control.official_implementation.remotes.RemoteControl;

public class Person {
	
	public static void main (String args[]){
	
		//Devices in the home
		Projector niceProjector = new Projector();
		TV niceLargeScreenTV = new TV();
		
		// The user's control
		RemoteControl remoteControl = RemoteControl.getInstance();
		
		remoteControl.connectToDevice(niceProjector);
		remoteControl.clickOnButon();
		
		remoteControl.connectToDevice(niceLargeScreenTV);
		remoteControl.clickOnButon();

	}
	
}
