import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Create Account
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);
                    bank.addAccount(newAccount);
                    break;

                case 2:
                    // Deposit Money
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount depositAccount = bank.searchAccount(accountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Withdraw Money
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount withdrawAccount = bank.searchAccount(accountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Check Balance
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount balanceAccount = bank.searchAccount(accountNumber);
                    if (balanceAccount != null) {
                        System.out.println("Account balance: $" + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // Display All Accounts
                    System.out.println("All accounts in the bank:");
                    bank.displayAllAccounts();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

