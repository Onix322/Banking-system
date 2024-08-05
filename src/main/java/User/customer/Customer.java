package User.customer;

import User.employee.User;
import bank.Roles;
import bankAccount.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Customer implements User {

    private Roles role;
    private String name;
    private String password;
    private String address;
    private String countryIndicator;
    private List<BankAccount> accounts = new ArrayList<>();

    public Customer(String countryIndicator, String address, String name, String password) {
        this.countryIndicator = countryIndicator;
        this.address = address;
        this.name = name;
        this.password = password;
        this.role = Roles.CUSTOMER;
    }

    public void addAccount(double balance, String IBAN, String currency) {
        accounts.add(new BankAccount(balance, IBAN, currency));
    }

    public void removeAccount(String IBAN){

        accounts.removeIf(account -> IBAN.equals(account.getIBAN()));
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Roles getRole() {
        return role;
    }

    public String getCountryIndicator() {
        return countryIndicator;
    }

    public void setCountryIndicator(String countryIndicator) {
        this.countryIndicator = countryIndicator;
    }

    public BankAccount getAccount(String IBAN){

        BankAccount res = null;

        for (BankAccount account : accounts){

            if(IBAN.equals(account.getIBAN())){

                res = account;
            }
        }

        return res;
    }

    public List<BankAccount> getlistOfAccounts() {

        return accounts;
    }

    public boolean accountExists(String IBAN){

        return getAccount(IBAN) != null;
    }

    public void deposit(String IBAN, double amount){

        BankAccount account = getAccount(IBAN);

        account.setBalance(account.getBalance() + amount);

    }

    public void withdraw(String IBAN, double amount){

        BankAccount account = getAccount(IBAN);

        account.setBalance(account.getBalance() - amount);

    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "countryIndicator='" + countryIndicator + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + Arrays.toString(accounts.toArray()) +
                '}' + "\n";
    }
}
