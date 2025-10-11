package CarRentalSystemLLD;

import java.util.List;

import CarRentalSystemLLD.Product.Vehicle;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
