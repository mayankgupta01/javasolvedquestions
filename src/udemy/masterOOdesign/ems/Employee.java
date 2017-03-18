package udemy.masterOOdesign.ems;

import java.util.Random;

/**
 * Created by mayank.gupta on 26/01/17.
 */
public class Employee {
    private String name;
    private Long id;
    private String department;
    private boolean is_employee;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        generateId();
        this.is_employee = true;
    }

    private void generateId() {
        this.id = (long)Math.random();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isIs_employee() {
        return is_employee;
    }

    public void setIs_employee(boolean is_employee) {
        this.is_employee = is_employee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", is_employee=" + is_employee +
                '}';
    }
}
