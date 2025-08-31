public abstract class Payment {
    double amount;
    Payment(double a){ amount=a; }

    public abstract void payAmount();
}