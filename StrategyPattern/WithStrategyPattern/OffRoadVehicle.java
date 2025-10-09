package WithStrategyPattern;

import WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
 