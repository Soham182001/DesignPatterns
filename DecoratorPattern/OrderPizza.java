package DecoratorPattern;

import DecoratorPattern.Pizza.Farmhouse;
import DecoratorPattern.Toppings.ExtraCheese;
import DecoratorPattern.Toppings.Paneer;
import DecoratorPattern.Pizza.BasePizza;

public class OrderPizza {
    public static void main(String[] args) {
        BasePizza pizza = new Paneer(new ExtraCheese(new Farmhouse()));
        System.out.println("Final Pizza Cost: " + pizza.cost());
    }
}
