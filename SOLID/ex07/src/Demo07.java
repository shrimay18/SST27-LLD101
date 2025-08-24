public class Demo07 {
    String content = "Hello World";
    String phoneNumber = "+1234567890";
    String dstPath = "/path/to/destination";
    public static void main(String[] args) {
        Printable m = new BasicPrinter();
        m.print("Hello World");

        Scanable s = new BasicScanner();
        s.scan("/path/to/destination");

        Faxable f = new BasicFax();
        f.fax("Hello World", "+1234567890");
    }
}
