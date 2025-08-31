public class BasicFax implements Faxable{
    public void fax(String content, String phoneNumber){
        System.out.println("\u2709 Faxing '" + content + "' to " + phoneNumber);
    }
}
