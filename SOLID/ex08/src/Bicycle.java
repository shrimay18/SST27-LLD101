public class Bicycle{
    private Pedalable pedalable;

    public Bicycle(Pedalable pedalable) {
        this.pedalable = pedalable;
    }

    public void pedal(int effort) {
        pedalable.pedal(effort);
    }
}