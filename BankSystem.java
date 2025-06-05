import java.io.*;
import java.util.*;

public class BankSystem {
    private Map<String, BankAccount> accounts;
    private static final String DATA_FILE = "accounts.dat";

    public BankSystem() {
        accounts = loadAccounts();
    }

    public void createAccount(String accNumber, String holderName) {
        if (accounts.containsKey(accNumber)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accNumber, new BankAccount(accNumber, holderName));
            System.out.println("Account created successfully.");
        }
        saveAccounts();
    }

    public void deposit(String accNumber, double amount) {
        BankAccount acc = accounts.get(accNumber);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
        saveAccounts();
    }

    public void withdraw(String accNumber, double amount) {
        BankAccount acc = accounts.get(accNumber);
        if (acc != null) {
            if (acc.withdraw(amount))
                System.out.println("Withdrawal successful.");
            else
                System.out.println("Insufficient balance.");
        } else {
            System.out.println("Account not found.");
        }
        saveAccounts();
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        BankAccount sender = accounts.get(fromAcc);
        BankAccount receiver = accounts.get(toAcc);
        if (sender != null && receiver != null) {
            if (sender.transferTo(receiver, amount))
                System.out.println("Transfer successful.");
            else
                System.out.println("Transfer failed. Check balance.");
        } else {
            System.out.println("One or both accounts not found.");
        }
        saveAccounts();
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (BankAccount acc : accounts.values()) {
                System.out.println(acc);
            }
        }
    }

    private void saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, BankAccount> loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (Map<String, BankAccount>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}
