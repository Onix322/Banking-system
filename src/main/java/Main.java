import bank.Bank;
import BankApplication.BankApplication;
import utils.DateOfBird;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome!");

        Bank bank = new Bank("Darmstadt");

        Bank.addEmployee(
                DateOfBird.add("10-12-2020"),
                "oParola",
                "Alex",
                System.currentTimeMillis()
        );

        Bank.addEmployee(
                DateOfBird.add("10-12-2020"),
                "oParola",
                "Beatrice",
                System.currentTimeMillis(),
                "HR"
        );

        Bank.addCustomer(
                "DE",
                "Germany",
                "Alexandru",
                "oParola"
        );

        Bank.addCustomer(
                "DE",
                "Germany",
                "Teodora",
                "oParola"
        );


        BankApplication bankApplication = new BankApplication();
        bankApplication.startApp();

    }
}
