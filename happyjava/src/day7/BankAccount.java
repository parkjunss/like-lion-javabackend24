package day7;

public class BankAccount {
    private final int id;
    private final String name;
    private int balance;

    public BankAccount(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void printBalance(){
        System.out.println("현재 잔액은 " + balance + " 입니다.");
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다. 입력값: " + amount);
        } else {
            this.balance += amount;
            System.out.println("입금 완료: " + amount + "원 / 남은 잔액: " + this.balance + "원");
        }
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("출금액은 마이너스일 수 없습니다.");
        }
        if (amount > this.balance) {
            System.out.println("잔액이 부족합니다. (현재 잔액: " + this.balance + ")");
            return;
        }

        this.balance -= amount;
        System.out.println("출금 완료: " + amount + "원 / 남은 잔액: " + this.balance + "원");
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1, "Bob", 10000);
        bankAccount.printBalance();
        bankAccount.deposit(10000);
        bankAccount.withdraw(5000);
    }

}
