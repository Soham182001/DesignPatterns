package BuilderPatternLLD;

public class House {
    private int floors;
    private boolean hasSwimmingPool;
    private boolean hasGarage;
    private boolean hasTerrace;
    private boolean hasBalcony;

    public House(HouseBuilder builder){
        this.floors = builder.floors;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarage = builder.hasGarage;
        this.hasTerrace = builder.hasTerrace;
        this.hasBalcony = builder.hasBalcony;
    }

    public void HouseInfo(){
        System.out.println("House has "+this.floors+" number of Floors");
        System.out.println("House has Garage: "+this.hasGarage);
        System.out.println("House has Terrace: "+ this.hasTerrace);
        System.out.println("House has Swimming Pool: "+this.hasSwimmingPool);
        System.out.println("House has Balcony: "+this.hasBalcony);
    }
}
