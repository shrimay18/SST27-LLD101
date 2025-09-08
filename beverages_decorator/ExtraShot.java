package beverages_decorator;

public class ExtraShot extends Decorator {
    public ExtraShot(Beverage beverage) {
        super(beverage);
    }
    @Override
    public int cost() { 
        return beverage.cost() + 5; 
    }
}