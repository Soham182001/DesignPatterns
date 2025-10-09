package WithStrategyPattern;

import WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle(){
        super(new NormalDriveStrategy());
    }

}
