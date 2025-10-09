package WithStrategyPattern;

import WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
    
}
