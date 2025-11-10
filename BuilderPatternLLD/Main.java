package BuilderPatternLLD;

public class Main {
    public static void main(String[] args) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Simple House=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        House simpleHouse = new HouseBuilder()
                .setFloors(2)
                .addGarage()
                .build();
        simpleHouse.HouseInfo();
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Luxury House=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        House luxuryHouse = new HouseBuilder()
                .setFloors(5)
                .addGarage()
                .addSwimmingPool()
                .addTerrace()
                .addBalcony()
                .build();
        luxuryHouse.HouseInfo();

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Basic House=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        House basicHouse = new HouseBuilder()
                .setFloors(1)
                .build();
        basicHouse.HouseInfo();
    }
}
