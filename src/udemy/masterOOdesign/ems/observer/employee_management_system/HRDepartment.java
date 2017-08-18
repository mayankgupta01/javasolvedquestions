package udemy.masterOOdesign.ems.observer.employee_management_system;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class HRDepartment implements ObserverInterface {
    @Override
    public void callMe() {
        System.out.println("HR Deparmented notified");
    }
}
