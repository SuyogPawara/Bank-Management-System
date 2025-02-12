import java.util.ArrayList;

class Bank {
    private ArrayList<BankAccount> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    // Method to add a new account
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created for: " + account.getAccountHolder());
    }

    // Method to search for an account by account number
    public BankAccount searchAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Method to display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
        } else {
            for (BankAccount account : accounts) {
                account.displayAccountDetails();
                System.out.println("--------------------");
            }
        }
    }
}
