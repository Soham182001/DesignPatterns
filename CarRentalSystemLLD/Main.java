package CarRentalSystemLLD;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystemLLD.Product.Car;
import CarRentalSystemLLD.Product.VehicleType;
import CarRentalSystemLLD.Product.Vehicle;


public class Main {
    public static void main(String[] args) {
        
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user searches store based on location
        Location location = new Location(560087, "Bangalore", "Karnataka", "India");
        Store store = vehicleRentalSystem.getStore(location);

        //2. user searches for vehicle type
        List<Vehicle> availableVehicles = store.getVehicles(VehicleType.CAR);

        //3. user creates reservation for vehicle
        Reservation reservation = store.createReservation(availableVehicles.get(0), user);
        
        //4. generate the bill for reservation
        Bill bill = new Bill(reservation);

        //5. make payment against the bill
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. complete the reservation
        store.completeReservation(reservation.reservationId);
    }

    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleId(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }


    
}
