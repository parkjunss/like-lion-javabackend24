package day9.hw2.problem2;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private double balance;
    private static int totalAccounts = 0;

    // 생성자 balance 기본 0, totalAccounts 하나 증가
    public BankAccount(String accountNumber, String name) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0;
        totalAccounts += 1;
    }

    // 입금 amount 0 이상
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(this.getName() + " deposited " + amount + " to account " + this.getAccountNumber());
            return true;
        } else {
            System.out.println("Insufficient balance");
        }
        return false;
    }

    // 출금 amount 0 이상, 잔고 amount 이상 시 출금 가능
    public boolean withdraw(double amount) {
        if (amount > 0 && this.getBalance() >= amount) {
            this.balance -= amount;
            System.out.println(this.getName() + " withdrew " + amount);
            return true;
        } else {
            System.out.println("Withdrawal failed: Insufficient balance or invalid amount.");
            return false;
        }
    }

    // 이체 계좌 있는지 확인, 먼저 출금 후 입금
    public boolean transfer(BankAccount target, double amount) {
        if (target == null) {
            System.out.println("Transfer failed: Target account is null.");
            return false;
        }

        if (this.withdraw(amount)) {
            target.deposit(amount);
            System.out.println("Transfer successful: " + amount + " to " + target.getName());
            return true;
        } else {
            System.out.println("Transfer failed: Check your balance.");
            return false;
        }
    }

    // 잔고 확인
    public void showBalance(){
        System.out.println(this.getName() + " balance: " + this.getBalance());
    }
    // 계좌 정보 보여주기
    public void showAccountInfo(){
        System.out.println(this.getName() + " account number: " + this.getAccountNumber());
    }
    // 총계좌 확인
    public static void showTotalAccounts(){
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getName(){
        return name;
    }

}
