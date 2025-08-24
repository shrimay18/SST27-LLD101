
public class Demo05 {
    static int areaAfterResize(Rectangle r){
        return r.area();
    }
    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle(5,4))); // 20
        System.out.println(areaAfterResize(new Square(4)));    // 16 (!) violates expectation
    }
}
