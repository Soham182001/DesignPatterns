package DecoratorPattern.Pizza;

public class Farmhouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}
