
public class Demo04 {
    public static void main(String[] args) {
        Payment c = new Card(100.00);
        UPI u = new UPI(100);
        Wallet w = new Wallet(100);
        
        c.payAmount();
        u.payAmount();   
        w.payAmount();
    }
}
