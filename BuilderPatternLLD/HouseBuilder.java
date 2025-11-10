package BuilderPatternLLD;

public class HouseBuilder {
    int floors = 1;
    boolean hasSwimmingPool = false;
    boolean hasGarage = false;
    boolean hasTerrace = false;
    boolean hasBalcony = false;

    public HouseBuilder setFloors(int floors){
        this.floors = floors;
        return this;
    }

    public HouseBuilder addSwimmingPool(){
        this.hasSwimmingPool = true;
        return this;
    }

    public HouseBuilder addGarage(){
        this.hasGarage = true;
        return this;
    }

    public HouseBuilder addTerrace(){
        this.hasTerrace = true;
        return this;
    }

    public HouseBuilder addBalcony(){
        this.hasBalcony = true;
        return this;
    }

    public House build(){
        return new House(this);
    }
}
