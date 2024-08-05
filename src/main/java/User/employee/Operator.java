package User.employee;

import bank.Roles;

import java.time.LocalDate;

public class Operator extends Employee{

    String departament;

    public Operator(LocalDate dateOfBird,
                    String password, String name,
                    long employeeId, String departament) {

        super(dateOfBird, password, name, employeeId);
        super.setRole(Roles.OPERATOR);
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return  "\n" + "Operator{" +
                "dateOfBird=" + super.getDateOfBird() +
                ", employeeId=" + super.getEmployeeId() +
                ", name='" + super.getName() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", role='" + super.getRole() + '\'' +
                ", departament='" + getDepartament() + '\'' +
                '}' + "\n";
    }
}
