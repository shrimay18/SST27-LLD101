public class FlyingBird extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flap!");
    } 

    @Override
    public void release() {
        this.fly(); // A flying bird's release action is to fly.
    }   
}
