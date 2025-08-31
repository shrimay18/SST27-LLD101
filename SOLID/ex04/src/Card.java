public class Card extends Payment {
    Card(double a){ super(a); }
    public void payAmount() {
        System.out.println("Paid " + amount + " using Card");
    }
}
