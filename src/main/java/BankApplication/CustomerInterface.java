package BankApplication;

import user.customer.Customer;
import transaction.Transaction;

import java.util.List;

public interface CustomerInterface extends UserInterface{

    String[] permissionList = new String[]{
            UserInterface.permisionsList[4],
            UserInterface.permisionsList[5],
            UserInterface.permisionsList[6],
            UserInterface.permisionsList[7],
            UserInterface.permisionsList[8],
            UserInterface.permisionsList[9],
    };

    static void implementUI(){

        for (int i = 0; i < permissionList.length; i++) {
            System.out.println(i + ". " + permissionList[i]);
        }
    }

    @Override
    default void viewBankAccounts(Customer customer) {
        UserInterface.super.viewBankAccounts(customer);
    }

    @Override
    default void deposit(Customer customer, String IBAN, double amount, List<Transaction> pendings) {
        UserInterface.super.deposit(customer, IBAN, amount, pendings);
    }

    @Override
    default void withdraw(Customer customer, String IBAN, double amount, List<Transaction> pendings) {
        UserInterface.super.withdraw(customer, IBAN, amount, pendings);
    }

    @Override
    default void addBankAccount(Customer customer, double amount, String IBAN, String currency) {
        UserInterface.super.addBankAccount(customer, amount, IBAN, currency);
    }

    @Override
    default void removeBankAccount(Customer customer, String IBAN) {
        UserInterface.super.removeBankAccount(customer, IBAN);
    }

    @Override
    default void exit() {
        UserInterface.super.exit();
    }
}
