package udemy.masterOOdesign.ems;

/**
 * Created by mayank.gupta on 26/01/17.
 */
public class EmployeeReportFormatter extends ReportFormatter {

    public Employee emp;


    public EmployeeReportFormatter(Employee emp) {
        this.emp = emp;
    }

    public void getEmployeeReport(SupportedReportFormat format) {
        switch (format) {
            case XML:
                printReportInXML(this.emp);
                break;
            
            case CSV:
                pringReportInCSV(this.emp);
                break;

            default:
                System.out.println("No matching format !");
                break;
        }
    }
}
