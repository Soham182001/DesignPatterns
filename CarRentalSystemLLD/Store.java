package CarRentalSystemLLD;

import java.util.ArrayList;
import java.util.List;
import CarRentalSystemLLD.Product.Vehicle;
import CarRentalSystemLLD.Product.VehicleType;

public class Store {
    VehicleInventoryManagement vehicleInventoryManagement;
    int storeId;
    Location location;
    List<Reservation> reservations = new ArrayList<>();
    
    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        reservation.createReserve(user, vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        // take out reservation from list and call complete the reservation method
        return true;
    }

}
