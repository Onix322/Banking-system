package employee;

import bank.Bank;

import java.time.LocalDate;

public class Employee {

    private final long employeeId;
    private String name;
    private String password;
    private LocalDate dateOfBird;
    private String role;

    private static int pushes = 0;

    public Employee(LocalDate dateOfBird, String password,
                    String name, long employeeId) {

        this.dateOfBird = dateOfBird;
        this.role = Bank.getRoles()[1]; //role = employee
        this.password = password;
        this.name = name;
        this.employeeId = employeeId;
    }

    public LocalDate getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(LocalDate dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public static int getPushes() {
        return pushes;
    }

    public static void pushIn(){
        pushes++;
    }

    public static void pushOut(){
        pushes--;
    }

    @Override
    public String toString() {
        return  "\n" + "Employee{" +
                "dateOfBird=" + dateOfBird +
                ", employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}' + "\n";
    }
}
