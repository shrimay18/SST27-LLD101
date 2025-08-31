public class Demo02 {
    public static void main(String[] args) {
        IDecode d = new Decode();
        IDrawUI ui = new DrawUI();
        ICache c = new Cache();
        Player p = new Player(d, ui, c);
        p.play(new byte[]{1,2,3,4});
    }
}
