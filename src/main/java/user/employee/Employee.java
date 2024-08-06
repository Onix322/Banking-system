package user.employee;

import bank.Roles;
import user.User;

import java.time.LocalDate;

public class Employee implements User {

    private final long EMPLOYEE_ID;
    private String name;
    private String password;
    private LocalDate dateOfBird;
    private Roles role;

    private static int pushes = 0;

    public Employee(LocalDate dateOfBird, String password,
                    String name, long employeeId) {

        this.dateOfBird = dateOfBird;
        this.role = Roles.EMPLOYEE;
        this.password = password;
        this.name = name;
        this.EMPLOYEE_ID = employeeId;
    }

    public LocalDate getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(LocalDate dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmployeeId() {
        return EMPLOYEE_ID;
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
                ", employeeId=" + EMPLOYEE_ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}' + "\n";
    }
}
