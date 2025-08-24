public class Cache implements ICache {
    private Frame last;
    public void cache(Frame f){
        last = f;
        System.out.println("Cached last frame? " + (last!=null));
    }
}
