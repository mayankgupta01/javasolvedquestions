package udemy.masterOOdesign.ems;

/**
 * Created by mayank.gupta on 26/01/17.
 */
public class EmployeeDAO {
    DataBaseManager dbManager;

    public EmployeeDAO(DataBaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void saveEmployee(Employee emp) {
        dbManager.save(emp);
    }

    public void terminateEmployee(Employee emp) {
        dbManager.delete(emp);
        emp.setIs_employee(false);
    }

}
