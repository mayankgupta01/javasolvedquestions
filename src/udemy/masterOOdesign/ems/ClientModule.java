package udemy.masterOOdesign.ems;

/**
 * Created by mayank.gupta on 26/01/17.
 */
public class ClientModule {

    Employee emp;
    EmployeeDAO employeeDAO;
    EmployeeReportFormatter employeeReportFormatter;

    public static void main(String[] args) {
        ClientModule cm = new ClientModule();
        cm.initializeEMS("Mayank", "OrderPath");
        cm.hireEmployee();
        cm.generateEmployeeReport(SupportedReportFormat.CSV);
        cm.terminateEmployee();
        cm.generateEmployeeReport(SupportedReportFormat.XML);
    }

    private void initializeEMS(String name, String department) {
        emp = new Employee(name, department);
        employeeDAO = new EmployeeDAO(new DataBaseManager());
        employeeReportFormatter = new EmployeeReportFormatter(emp);

    }

    private void hireEmployee() {
        employeeDAO.saveEmployee(emp);
    }

    private void terminateEmployee() {
        employeeDAO.terminateEmployee(emp);
    }

    private void generateEmployeeReport(SupportedReportFormat reportFormat) {
        employeeReportFormatter.getEmployeeReport(reportFormat);
    }
}
