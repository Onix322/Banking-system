package bank;

import java.time.LocalDate;

import customer.Customer;
import employee.Employee;
import employee.Operator;

public final class Branch extends Bank{

    private final String branch;

    public Branch(String branch){
        this.branch = branch;
        Bank.getBranches().add(this);
    }

    @Override
    public void addEmployee(LocalDate dateOfBird, String password,
                            String name, long employeeId){

        Bank.getEmployees().add(new Employee(dateOfBird, password, name, employeeId));

    }
    

    @Override
    public void addEmployee(LocalDate dateOfBird, String password,
                            String name, long employeeId, String departament){

        Bank.getEmployees().add(new Operator(dateOfBird, password, name, employeeId, departament));

    }

    @Override
    public void addCustomer(String countryIndicator, String address, String name, String password){

        Bank.getCustomers().add(new Customer(countryIndicator, address, name, password));
    }

    @Override
    public Customer getCustomer(String name){

        Customer result = null;

        for (Customer customer : Bank.getCustomers()){

            if(name.equals(customer.getName())) {
                result = customer;
            }
        }

        return result;
    }

    @Override
    public void removeCustomer(String name){

        Bank.getCustomers().removeIf(customer -> name.equals(customer.getName()));
    }


    @Override
    public Employee getEmployee(String name){

        Employee result = null;

        for (Employee employee : Bank.getEmployees()){

            if(name.equals(employee.getName())) {
                result = employee;
            }
        }

        return result;
    }

    @Override
    public void removeEmployee(String name){

        Bank.getEmployees().removeIf(employee -> name.equals(employee.getName()));
    }

    @Override
    public String toString() {
        return branch;
    }
}
