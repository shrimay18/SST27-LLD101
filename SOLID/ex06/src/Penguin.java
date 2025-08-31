public class Penguin extends Bird implements Walkable {
    @Override
    public void walk() {
        System.out.println("Waddle waddle!");
    }

    @Override
    public void release() {
        this.walk(); // A penguin's release action is to walk.
    }
}