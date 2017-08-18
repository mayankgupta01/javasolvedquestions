package udemy.masterOOdesign.ems.observer.employee_management_system;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class PayrollDepartment implements ObserverInterface {
    @Override
    public void callMe() {
        System.out.println("Payroll Dept notified");
    }
}
