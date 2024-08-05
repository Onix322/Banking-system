package BankApplication;

import bank.Bank;
import user.customer.Customer;
import user.employee.Employee;
import transaction.Transaction;
import utils.IBANgenerator;

import java.util.List;

public interface UserInterface {

    // =--- IMPORTANT !!!! ---= THIS ORDER OF THE LIST IS EXTREMELY IMPORTANT FOR UI
    // =--- !!the UI interfaces use this order!!!

    // =--- Recomandation for adding: --add at the end of the list

    //====
    String[] permisionsList = new String[]{
            "Push In",
            "Push Out",
            "Authorize transaction",
            "Reject transaction",
            "View bank accounts",
            "Add bank account",
            "Remove bank account",
            "Deposit",
            "Withdraw",
            "Exit",
            "Add new customer",
            "Remove customer",
            "Add account to customer",
            "Remove account from customer"
    };
    //====

    default void pushIn(){
        Employee.pushIn();

        System.out.println("Pushed in!");
        System.out.println("Pushes: " + Employee.getPushes());
        System.out.println();
    };

    default void pushOut(){

        Employee.pushOut();

        System.out.println("Pushed out!");
        System.out.println("Pushes: " + Employee.getPushes());
        System.out.println();
    };

    default void authorizeTransaction(List<Transaction> pending, byte indexTransaction){

        Transaction transaction = pending.get(indexTransaction);

        if(transaction.getType().equals("deposit")){

            transaction.getAccount()
                    .setBalance(
                        transaction.getAmount() + transaction.getAccount().getBalance()
                    );
        }

        if(transaction.getType().equals("withdraw")){

            transaction.getAccount()
                    .setBalance(
                        transaction.getAmount() - transaction.getAccount().getBalance()
                    );
        }

    }

    default void rejectTransaction(List<Transaction> pending, byte index){
        pending.remove(index);
    }

    default void exit(){

        System.out.println("You've been log out!");
    };

    default void viewBankAccounts(Customer customer){

        if(customer.getlistOfAccounts().toArray().length <= 0){

            System.out.println("You don't have an account yet! Please create one.");
            return;
        }

        System.out.println(customer.getlistOfAccounts());
    }

    default void addBankAccount(Customer customer, double amount, String IBAN, String currency){
        customer.addAccount(amount, IBAN, currency);
    }

    default void removeBankAccount(Customer customer, String IBAN){
        customer.removeAccount(IBAN);
    }

    default void deposit(Customer customer, String IBAN, double amount, List<Transaction> pendings){

        if(amount > 10000) {

            System.out.println("\n");
            System.err.println(
                    "\nThe amount is bigger then 10000." +
                    "\n You has to wait for an operator to authorize the transaction!!"
            );
            System.out.println();

            pendings.add(
                    new Transaction(
                            customer.getAccount(IBAN), amount, "deposit"
                    )
            );
        }
        else{

            customer.deposit(IBAN, amount);
        }
    }

    default void withdraw(Customer customer,String IBAN, double amount, List<Transaction> pendings){

        if(customer.getAccount(IBAN).getBalance()  - amount < 0){
            System.err.println("You don't have sufficient founds!");
            return;
        }

        if(amount > 10000) {

            System.out.println();
            System.err.println("The amount is bigger then 10000, it has to wait for an operator to authorize the transaction!!");
            System.out.println();

            pendings.add(
                    new Transaction(
                            customer.getAccount(IBAN), amount, "withdraw"
                    )
            );
        }
        else{

            customer.withdraw(IBAN, amount);
        }
    }

    default void addNewCustomer(String countryIndicator, String address,
                                String name, String password){

        Bank.CUSTOMERS.add(
                new Customer(countryIndicator,address, name, password)
        );

    }

    default void removeCustomer(String name){

        Bank.removeFrom(name, Bank.CUSTOMERS);
    }

    default void addAccountToCustomer(Customer customer, double amount, String currency){

        customer.addAccount(amount, IBANgenerator.create(customer.getCountryIndicator()), currency);
    }

    default void removeAccountFromCustomer(Customer customer, String IBAN){

        customer.removeAccount(IBAN);
    }
}

