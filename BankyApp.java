import java.util.Scanner;

public class BankyApp {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== BANKY MENU ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. List Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();
                    bank.createAccount(accNum, name);
                    break;
                case "2":
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double dep = Double.parseDouble(scanner.nextLine());
                    bank.deposit(accNum, dep);
                    break;
                case "3":
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wit = Double.parseDouble(scanner.nextLine());
                    bank.withdraw(accNum, wit);
                    break;
                case "4":
                    System.out.print("From Account Number: ");
                    String from = scanner.nextLine();
                    System.out.print("To Account Number: ");
                    String to = scanner.nextLine();
                    System.out.print("Enter Amount to Transfer: ");
                    double amt = Double.parseDouble(scanner.nextLine());
                    bank.transfer(from, to, amt);
                    break;
                case "5":
                    bank.listAccounts();
                    break;
                case "6":
                    running = false;
                    System.out.println("Thank you for using BANKY!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
