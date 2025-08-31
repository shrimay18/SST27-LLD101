public class Decode implements IDecode {
    public Frame decode(byte[] fileBytes){
        Frame f = new Frame(fileBytes); 
        return f;
    }
}
