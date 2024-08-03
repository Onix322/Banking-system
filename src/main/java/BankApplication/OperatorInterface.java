package BankApplication;

import customer.Customer;
import transaction.Transaction;

import java.util.List;

public interface OperatorInterface extends UserInterface{

    String[] permissionList = new String[]{
            UserInterface.permisionsList[0],
            UserInterface.permisionsList[1],
            UserInterface.permisionsList[2],
            UserInterface.permisionsList[3],
            UserInterface.permisionsList[10],
            UserInterface.permisionsList[11],
            UserInterface.permisionsList[12],
            UserInterface.permisionsList[13],
            UserInterface.permisionsList[9]
    };

    static void implementUI(){

        for (int i = 0; i < permissionList.length; i++) {
            System.out.println(i + ". " + permissionList[i]);
        }
    }

    @Override
    default void pushIn() {
        UserInterface.super.pushIn();
    }

    @Override
    default void pushOut() {
        UserInterface.super.pushOut();
    }

    @Override
    default void authorizeTransaction(List<Transaction> pending, byte indexTransaction) {
        UserInterface.super.authorizeTransaction(pending, indexTransaction);
    }

    @Override
    default void rejectTransaction(List<Transaction> pending, byte index) {
        UserInterface.super.rejectTransaction(pending, index);
    }

    @Override
    default void addNewCustomer(String countryIndicator, String address, String name, String password) {
        UserInterface.super.addNewCustomer(countryIndicator, address, name, password);
    }

    @Override
    default void removeCustomer(String name) {
        UserInterface.super.removeCustomer(name);
    }

    @Override
    default void addAccountToCustomer(Customer customer, double amount, String currency) {
        UserInterface.super.addAccountToCustomer(customer, amount, currency);
    }

    @Override
    default void removeAccountFromCustomer(Customer customer, String IBAN) {
        UserInterface.super.removeAccountFromCustomer(customer, IBAN);
    }

    @Override
    default void exit() {
        UserInterface.super.exit();
    }
}
