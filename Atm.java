import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Atmm {
    private double balance = 5000;

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        balance += amount;
        System.out.println("Deposit successful!");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful!");
    }
}

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Atmm atm = new Atmm();

        while (true) {
            try {
                System.out.println("\n---- ATM MENU ----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct values.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
