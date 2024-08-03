package bank;

import customer.Customer;
import employee.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public sealed abstract class Bank permits Branch{

    private static final List<Employee> employees = new ArrayList<>();
    private static final List<Customer> customers = new ArrayList<>();
    private static final List<Branch> branches = new ArrayList<>();
    private static final String[] roles = new String[]{"customer", "employee", "operator"};

    abstract void addEmployee(LocalDate dateOfBird, String password,
                            String name, long employeeId);

    abstract void addEmployee(LocalDate dateOfBird, String password,
                              String name, long employeeId, String departament);

    abstract void addCustomer(String countryIndicator, String address, String name, String password);
    abstract void removeCustomer(String name);
    abstract Customer getCustomer(String name);
    abstract void removeEmployee(String name);
    abstract Employee getEmployee(String name);

    public static Employee logInEmployee(String name, String password){

        for (Employee employee : employees){
            if(name.equals(employee.getName()) &&
               password.equals(employee.getPassword())){

                return employee;
            }
        }

        return null;
    }

    public static Customer logInCustomer(String name, String password){

        for(Customer customer : customers){

            if(name.equals(customer.getName()) && password.equals(customer.getPassword())){

                return customer;
            }
        }

        return null;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static List<Branch> getBranches() {
        return branches;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static String[] getRoles(){
        return roles;
    }

    static String listOfEmployees(){
        return "Bank{" + "\n" +
                "employees=" + employees +
                '}' + "\n";
    };

    static String listOfCustomers() {
        return "Bank{" + "\n" +
                "customers=" + customers +
                '}' + "\n";
    }

    static String listOfBranches() {
        return "Bank{" + "\n" +
                "branch=" + branches +
                "}" + "\n";
    }

    static String bankInfos() {
        return "Bank{" + "\n" +
                "branches=" + branches + "\n" +
                "employees=" + employees + "\n" +
                "customers=" + customers + "\n" +
                '}' + "\n" ;
    }
}
