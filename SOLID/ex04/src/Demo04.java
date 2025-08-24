
public class Demo04 {
    public static void main(String[] args) {
        Payment c = new Card(100.00);
        UPI u = new UPI();
        Wallet w = new Wallet();
        
        c.payAmount(100);
        u.payAmount(200);   
        w.payAmount(300);
    }
}
