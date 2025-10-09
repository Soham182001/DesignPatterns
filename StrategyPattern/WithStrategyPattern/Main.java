package WithStrategyPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new SportsVehicle();
        vehicle1.driveT();

        Vehicle vehicle2 = new OffRoadVehicle();
        vehicle2.driveT();

        Vehicle vehicle3 = new GoodsVehicle();
        vehicle3.driveT();
    }
}
