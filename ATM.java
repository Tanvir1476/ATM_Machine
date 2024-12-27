import java.util.Scanner;

public class ATM {
    private float balance = 1000; 
    private final int PIN = 1234;    
    private final Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }

    public void checkPin() {
        System.out.println("                         Welcome To Bank of DIU                    ");
        System.out.println("Enter Your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Invalid PIN. Please try again.");
            checkPin();
        }
    }

    public void menu() {
        System.out.println("\nEnter Your Choice: ");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Get a Loan");
        System.out.println("5. Exit");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                getLoan();
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                menu();
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Balance: " + balance + " Taka");
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Withdrawal Amount: ");
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient Funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful. Please collect your cash.");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter Deposit Amount: ");
        float amount = sc.nextFloat();

        balance += amount;
        System.out.println("Deposit Successful.");
        menu();
    }

    public void getLoan() {
        System.out.println("Enter Loan Amount: ");
        float loanAmount = sc.nextFloat();

        System.out.println("Loan Approved! The amount of " + loanAmount + " Taka has been added to your account.");
        balance += loanAmount;

        menu();
    }
}
