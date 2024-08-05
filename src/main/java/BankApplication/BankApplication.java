package BankApplication;

import bank.Bank;
import bank.Roles;
import User.customer.Customer;
import User.employee.Employee;
import User.employee.Operator;
import transaction.Transaction;
import utils.Console;
import utils.IBANgenerator;
import utils.UserInput;

import java.util.*;

public class BankApplication implements UserInterface{

    private final List<Transaction> PENDING_TRANSACTIONS = new ArrayList<>();
    private Object individualFound;

    public BankApplication(){}

    public void startApp(){
        System.out.println();
        Console.clear();

        System.out.println("Who are you? \n");
        System.out.println("0. Employee");
        System.out.println("1. Customer");
        System.out.println();

        byte input = UserInput.getChoiceInput();

        switch (input){
            case 0 -> employeeLoginUI();
            case 1 -> customerLoginUI();
            default -> {

                System.err.println("Wrong choice! Please type a number from above.");
                startApp();

            }
        }
    }

    private void getUI(Object individual){


        if(individual instanceof Customer){

            customerUI((Customer) individual);
        }
        else{

            if(((Employee) individual).getRole().equals(Roles.EMPLOYEE)){

                employeeUI((Employee) individual);
                return;
            }

            if(((Operator) individual).getRole().equals(Roles.OPERATOR)){

                operatorUI((Operator) individual);
            }
        }
    }

    private void employeeLoginUI(){

        Console.clear();

        System.out.println("Insert your name and password: ");

        String name = UserInput.getStringInput("username: ");
        String password = UserInput.getStringInput("password: ");

        individualFound = Bank.logIn(Bank.EMPLOYEES, name, password);

        if(individualFound == null){
            System.err.println("Wrong user or password! Try again...");
        }

        while(individualFound != null){
            getUI(individualFound);
        }

        startApp();

        Console.clear();

    }

    private void customerLoginUI(){

        Console.clear();

        String name = UserInput.getStringInput("username: ");
        String password = UserInput.getStringInput("password: ");

        Console.clear();

        individualFound = Bank.logIn(Bank.CUSTOMERS, name, password);

        while(individualFound != null){

            getUI(individualFound);
        }

        startApp();
    }

    private void customerUI(Customer customer){
        System.out.println();
        System.out.println("Hello, " + customer.getName() + "!");
        System.out.println();

        CustomerInterface.implementUI();
        System.out.println();

        byte input = UserInput.getChoiceInput();

        switch (input){
            case 0 -> {
                viewBankAccounts(customer);
                customerUI(customer);
            }
            case 1 -> {

                String IBAN = IBANgenerator.create(customer.getCountryIndicator());
                String currency = UserInput.getStringInput("Currency type: ").toUpperCase();

                addBankAccount(customer, 0, IBAN, currency);

                if(
                        customer.getlistOfAccounts()
                                .contains(customer.getAccount(IBAN))
                ){
                    System.out.println(customer.getAccount(IBAN));
                    System.out.println("Account has been successfully created and added");
                    customerUI(customer);
                }
                else {
                    System.err.println("Something went wrong! Account hasn't been created");
                    customerUI(customer);
                }
            }

            case 2 -> {

                String IBAN = UserInput.getStringInput("Type IBAN: ").toUpperCase();

                removeBankAccount(customer, IBAN);

                if(!customer.getlistOfAccounts().contains(customer.getAccount(IBAN))){
                    System.out.println(customer.getlistOfAccounts());
                    System.out.println("Account has been successfully removed!");
                    customerUI(customer);
                }
                else {
                    System.err.println("Something went wrong! Account hasn't removed!");
                    customerUI(customer);
                }
            }

            case 3 -> {

                String IBAN = UserInput.getStringInput("Type IBAN: ").toUpperCase();

                if(
                        customer.accountExists(IBAN) &&
                        customer.getlistOfAccounts().toArray().length > 0
                ){
                    double amount = UserInput.getAmountInput();

                    if(amount < 0) {
                        System.err.println("Needs to be a floating number! Try again...");
                        customerUI(customer);
                        break;
                    }

                    deposit(customer, IBAN, amount, PENDING_TRANSACTIONS);
                    break;
                }

                System.err.println("This account does not exist! Try again...");
                customerUI(customer);

            }

            case 4 -> {

                String IBAN = UserInput.getStringInput("Type IBAN: ").toUpperCase();

                if(
                        customer.accountExists(IBAN) &&
                        customer.getlistOfAccounts().toArray().length > 0
                ){
                    double amount = UserInput.getAmountInput();

                    if(amount < 0) {
                        System.err.println("Needs to be a floating number! Try again...");
                        customerUI(customer);
                        break;
                    }

                    withdraw(customer, IBAN, amount, PENDING_TRANSACTIONS);
                    break;
                }

                System.err.println("This IBAN does not exist! Try again...");
                customerUI(customer);
            }

            case 5 -> {
                System.out.println();
                exit();
                individualFound = null;
            }

            default -> {
                System.err.println("Wrong choice! Please type a number from above.");
                customerUI(customer);
            }
        }
    }

    private void employeeUI(Employee employee){

        System.out.println();
        System.out.println("Hello, " + employee.getName() + "!");
        System.out.println("You are an Employee");
        System.out.println();

        EmployeeInterface.implementUI();

        byte input = UserInput.getChoiceInput();

        switch (input){

            case 0 -> pushIn();

            case 1 -> pushOut();

            case 2 -> {
                exit();
                individualFound = null;
            }
            default -> {
                System.err.println("Wrong choice! Please type a number from above.");
                employeeUI(employee);
            }
        }
    }

    private void operatorUI(Operator operator){

        System.out.println();
        System.out.println("Hello, " + operator.getName() + "!");
        System.out.println("You are an Operator");
        System.out.println();

        OperatorInterface.implementUI();

        byte input = UserInput.getChoiceInput();

        switch (input){

            case 0 -> pushIn();

            case 1 -> pushOut();

            case 2 -> {

                if(PENDING_TRANSACTIONS.toArray().length == 0){
                    System.err.println("There are not any pending transactions yet!");
                    operatorUI(operator);
                    break;
                }

                for (int i = 0; i < PENDING_TRANSACTIONS.toArray().length; i++) {
                    System.out.println(i + ". " + PENDING_TRANSACTIONS.get(i));
                }

                byte indexTransaction = UserInput.getChoiceInput();

                if(indexTransaction >= PENDING_TRANSACTIONS.toArray().length){
                    operatorUI(operator);
                    return;
                }

                authorizeTransaction(PENDING_TRANSACTIONS, indexTransaction);
                PENDING_TRANSACTIONS.remove(indexTransaction);

                System.out.println("Transaction has been authorized!");
            }

            case 3 -> {
                System.out.println();
                if(PENDING_TRANSACTIONS.toArray().length == 0){
                    System.err.println("There are not any pending transactions yet!");
                    operatorUI(operator);
                    break;
                }

                byte indexTransaction = UserInput.getChoiceInput();

                rejectTransaction(PENDING_TRANSACTIONS, indexTransaction);
                System.out.println("Transaction has been rejected!");

            }

            case 4 -> {
                System.out.println();
                String name = UserInput.getStringInput("Type name: ");
                String address = UserInput.getStringInput("Type address: ");

                if(
                        Bank.CUSTOMERS.contains(name) &&
                        Bank.CUSTOMERS.contains(address)
                ){
                    System.err.println("This customer already exist");
                    break;
                }

                String countryIndicator = UserInput.getStringInput("Type country Indicator: ");
                String password = UserInput.getStringInput("Type password: ");

                addNewCustomer(countryIndicator, address, name, password);

                System.out.println(Bank.CUSTOMERS);
            }

            case 5 -> {

                System.out.println();
                String name = UserInput.getStringInput("Type name: ");

                if(Bank.CUSTOMERS.contains(name)){

                    System.err.println("This customer doesn't exist yet!");
                    break;
                }

                removeCustomer(name);
            }

            case 6 ->{

                System.out.println();

                String name = UserInput.getStringInput("Name of customer: ");
                String address = UserInput.getStringInput("Address of customer: ");

                Customer person = Bank.getUser(name, Bank.CUSTOMERS);

                if(person == null || !address.equals(person.getAddress())){
                    System.err.println("This customer doesn't exists yet!");
                    operatorUI(operator);
                    break;
                }

                double amount = UserInput.getAmountInput();
                String currency = UserInput.getStringInput("Type currency: ");

                addAccountToCustomer(person, amount, currency);
            }

            case 7 ->{

                String name = UserInput.getStringInput("Name of customer: ");
                String IBAN = UserInput.getStringInput("IBAN of account: ");

                Customer person = Bank.getUser(name, Bank.CUSTOMERS);

                if(person == null || !IBAN.equals(person.getAccount(IBAN).getIBAN())){
                    System.err.println("This customer doesn't exists yet!");
                    operatorUI(operator);
                    break;
                }

                removeAccountFromCustomer(person, IBAN);
            }

            case 8 -> {
                exit();
                individualFound = null;
            }

            default -> {
                System.err.println("Wrong choice! Please type a number from above.");
                operatorUI(operator);
            }
        }
    }
}
