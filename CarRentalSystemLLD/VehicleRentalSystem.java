package CarRentalSystemLLD;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;

    VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public Store getStore(Location location){
        return stores.get(0);
    }

    // Other methods like addUser, addStore can be added here

}
