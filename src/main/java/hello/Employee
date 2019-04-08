package hello;

import org.springframework.data.annotation.Id;


public class Employee {

    @Id
    public String id;

    public String EmployeeId;
    public String EmployeeName;

    public Employee() {}

    public Employee(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, employeeId='%s', employeeName='%s']",
                id, employeeId, employeeName);
    }

}

