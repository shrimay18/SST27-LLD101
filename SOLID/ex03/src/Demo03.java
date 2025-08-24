public class Demo03 {
    public static void main(String[] args) {
        Shipment s1 = new Standard(10);
        System.out.println("Standard shipment cost for 10kg: " + s1.getcost());
        Shipment s2 = new Express(10);
        System.out.println("Express shipment cost for 10kg: " + s2.getcost());
        Shipment s3 = new Overnight(10);
        System.out.println("Overnight shipment cost for 10kg: " + s3.getcost());
    }
}
