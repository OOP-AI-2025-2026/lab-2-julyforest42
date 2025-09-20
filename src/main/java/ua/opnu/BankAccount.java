package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    void deposit(double amount) {
        if (amount <= 0) return;
        balance = balance + amount;
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || balance < (amount + transactionFee)) return false;
        balance = balance - (amount + transactionFee);
        return true;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (!this.withdraw(amount)) return false;
        receiver.deposit(amount);
        return true;
    }
}