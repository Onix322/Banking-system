import bank.Bank;
import bank.Branch;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import BankApplication.BankApplication;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome!");

        Branch branch = new Branch("Darmstadt");

        branch.addEmployee(
                LocalDate.parse("10-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                "oParola",
                "Alex",
                System.currentTimeMillis()
        );

        branch.addEmployee(
                LocalDate.parse("10-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                "oParola",
                "Beatrice",
                System.currentTimeMillis(),
                "HR"
        );

        branch.addCustomer(
                "DE",
                "Germany",
                "Alexandru",
                "oParola"
        );

        BankApplication bankApplication = new BankApplication();
        bankApplication.startApp();
    }
}
