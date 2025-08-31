public class Player {
    private IDecode decoder;
    private IDrawUI ui;
    private ICache cache;
    public Player(IDecode d, IDrawUI ui, ICache c) {
        this.decoder = d;
        this.ui = ui;
        this.cache = c;
    }
    void play(byte[] fileBytes){
        Frame f = decoder.decode(fileBytes);
        ui.drawUI(f);
        cache.cache(f);
    }
}