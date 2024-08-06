package bank;

import user.User;
import user.customer.Customer;
import user.employee.Employee;
import user.employee.Operator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank{

    public static final List<Employee> EMPLOYEES = new ArrayList<>();
    public static final List<Customer> CUSTOMERS = new ArrayList<>();
    public static final List<Bank> BRANCHES = new ArrayList<>();
    public String branch;


    public Bank(String branch){
        this.branch = branch;
        Bank.BRANCHES.add(this);
    }

    public static void addEmployee(
            LocalDate dateOfBird, String password,
            String name, long employeeId
    ){

        Bank.EMPLOYEES.add(new Employee(dateOfBird, password, name, employeeId));
    }

    public static void addEmployee(
            LocalDate dateOfBird, String password,
            String name, long employeeId, String departament
    ){

        Bank.EMPLOYEES.add(new Operator(dateOfBird, password, name, employeeId, departament));
    }

    public static void addCustomer(
            String countryIndicator, String address,
            String name, String password
    ){

        Bank.CUSTOMERS.add(new Customer(countryIndicator, address, name, password));
    }

    public static  <E extends User> E getUser(String name, List<E> list){

        E result = null;

        for (E employee : list){

            if(name.equals(employee.getName())) {
                result = employee;
            }
        }

        return result;
    }


    public static <E extends User> void removeFrom(String name, List<E> list){

        list.removeIf(employee -> name.equals(employee.getName()));
    }

    public static <E extends User> User logIn(List<E> list, String name, String password){

        for(E user : list){

            if(
                    name.equals(user.getName()) &&
                    password.equals(user.getPassword())
            ){

                return user;
            }
        }

        return null;
    }

    static String listOfEmployees(){
        return "Bank{" + "\n" +
                "employees=" + EMPLOYEES +
                '}' + "\n";
    };

    static String listOfCustomers() {
        return "Bank{" + "\n" +
                "customers=" + CUSTOMERS +
                '}' + "\n";
    }

    static String listOfBranches() {
        return "Bank{" + "\n" +
                "branch=" + BRANCHES +
                "}" + "\n";
    }

    static String bankInfos() {
        return "Bank{" + "\n" +
                "branches=" + BRANCHES + "\n" +
                "employees=" + EMPLOYEES + "\n" +
                "customers=" + CUSTOMERS + "\n" +
                '}' + "\n" ;
    }
}
