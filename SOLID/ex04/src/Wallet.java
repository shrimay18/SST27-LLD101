public class Wallet extends Payment {
    Wallet(double a){ super(a); }
    public void payAmount() {
        System.out.println("Paid " + amount + " using Wallet");
    }
}
