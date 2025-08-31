public class DrawUI implements IDrawUI {
    public void drawUI(Frame f){
        System.out.println("\u25B6 Playing " + f.getData().length + " bytes");
    }
}
