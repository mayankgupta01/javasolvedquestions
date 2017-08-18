package udemy.masterOOdesign.ems.observer.employee_management_system;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class AppDriver {

    public static void main(String[] args) {
        ObserverInterface hrDep = new HRDepartment();
        ObserverInterface payrollDep = new PayrollDepartment();

        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.registerObserver(hrDep);
        ems.registerObserver(payrollDep);

        Employee emp = new Employee();
        ems.addEmployee(emp);
    }
}
