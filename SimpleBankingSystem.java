import java.util.Scanner;
import java.util.Arrays;

public class SimpleBankingSystem {
    String name;
    String surname;
    int balance;
    String name_bank;
    

    public void showStats(){
        System.out.println("\n$" + balance);
        System.out.println(name + " " + surname);
        System.out.println(name_bank + " bank");

    }

    public void deposit(int moneyToDeposit){
        balance += moneyToDeposit;
        System.out.println("\n You have deposited $" + moneyToDeposit);
        System.out.println("Current balance: $" + balance);

    }

    public void withdraw(int moneyToWithdraw) {
        if (moneyToWithdraw > balance) {
            System.out.println("\nThe amount of money is exceeding your balance. Proceed?");
            Scanner input = new Scanner(System.in);
            String decision = input.next();

            if (decision.equals("yes") || decision.equals("Yes")) {
                balance -= moneyToWithdraw;
                System.out.println("\nMoney withdrawn: $" + moneyToWithdraw);
                System.out.println("Current balance: $" + balance);

            } else {
                System.out.println("\nOk");
            }


        } else {
            balance -= moneyToWithdraw;
            System.out.println("\nMoney withdrawn: $" + moneyToWithdraw);
            System.out.println("Current balance: $" + balance);
        }
    }


    public void loop(){
        System.out.println(name + ", welcome to " + name_bank + " bank!");


        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\nFrom the menu, choose a service you need...");
            System.out.println("(1) See bank account information; \n(2) Deposit money to the bank account;");
            System.out.println("(3) Withdraw money from the bank account; \n(4) Log out and exit");
            int query = input.nextInt();

            if (query == 1){
                showStats();
            } else if (query == 2){
                System.out.println("\nHow much money would you like to deposit to your account: ");
                int depositQuery = input.nextInt();
                deposit(depositQuery);

            } else if (query == 3){
                System.out.println("\nHow much money would you like to withdraw from your account: ");
                int withdrawQuery = input.nextInt();
                withdraw(withdrawQuery);
            } else {
                System.out.println("\nGoodbye!");
                break;
            }

        } while (true);

    }

    public void accountCreator(){

        Scanner input = new Scanner(System.in);
        System.out.println("First name: ");
        name = input.next();
        System.out.println("Last name: ");
        surname = input.next();
        System.out.println("Balance: ");
        balance = input.nextInt();
        System.out.println("Bank name: ");
        name_bank = input.next();
        Object[] account = new Object[]{name, surname, balance,name_bank};
        System.out.println(Arrays.toString(account));

    }

    public static void main(String[] args){
        SimpleBankingSystem bank = new SimpleBankingSystem();
        bank.accountCreator();
        bank.loop();
    }
}
