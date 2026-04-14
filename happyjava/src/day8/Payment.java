package day8;

abstract class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }

    abstract void pay();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.printf("신용카드로 %.1f원 결제하였습니다.\n", this.amount);
    }
}

class PaypalPayment extends Payment {
    PaypalPayment(double amount) {
        super(amount);
    }
    @Override
    void pay() {
        System.out.printf("PayPal로 %.1f원 결제하였습니다.\n", this.amount);
    }
}