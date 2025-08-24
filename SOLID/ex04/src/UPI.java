public class UPI extends Payment {
    UPI(double a){ super(a); }
    public void payAmount() {
        System.out.println("Paid " + amount + " using UPI");
    }
}
