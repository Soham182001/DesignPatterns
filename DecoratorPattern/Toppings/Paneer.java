package DecoratorPattern.Toppings;

import DecoratorPattern.Pizza.BasePizza;

public class Paneer extends ToppingDecorator {
    BasePizza pizza;

    public Paneer(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 60;
    }
    
}
