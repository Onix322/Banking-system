package bankAccount;

public class BankAccount {

    private final String IBAN;
    private double balance;
    private String currency;

    public BankAccount(double balance, String IBAN, String currency) {
        this.balance = balance;
        this.IBAN = IBAN;
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIBAN() {
        return IBAN;
    }


    @Override
    public String toString() {
        return "\n\nBankAccount{" + "\n" +
                "\nbalance=" + balance +
                "\nIBAN='" + IBAN + '\'' +
                "\ncurrency='" + currency + '\'' + "\n" +
                "\n}";
    }
}
