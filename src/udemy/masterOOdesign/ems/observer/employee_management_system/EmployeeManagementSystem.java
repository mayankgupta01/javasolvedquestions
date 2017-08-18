package udemy.masterOOdesign.ems.observer.employee_management_system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 18/05/17.
 */
public class EmployeeManagementSystem {

    private List<ObserverInterface> observerList;

    private List<Employee> employees;

    public void registerObserver(ObserverInterface observer) {
        if(observerList == null) {
            observerList = new ArrayList<>();
            observerList.add(observer);
        }else {
            observerList.add(observer);
        }
    }

    public void unregisterObserver(ObserverInterface observer) {

        if(observerList == null)
            return;

        observerList.remove(observer);
    }

    public void notifyObserver() {
        for(ObserverInterface obs : observerList) {
            obs.callMe();
        }
    }

    public void addEmployee(Employee emp) {
        if(employees == null) {
            employees = new ArrayList<>();
            employees.add(emp);
        }else {
            employees.add(emp);
        }
        notifyObserver();
    }


}
