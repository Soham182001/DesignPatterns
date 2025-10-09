package WithoutStrategyPattern;

public class Vehicle {
    public void drive() {
        System.out.println("Normal Drive Capability");
    }

    public static void main(String[] args) {
        Vehicle normalVehicle = new GoodsVehicle();
        normalVehicle.drive();
    }
}