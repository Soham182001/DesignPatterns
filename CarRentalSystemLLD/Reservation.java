package CarRentalSystemLLD;

import java.time.LocalDate;
import CarRentalSystemLLD.Product.Vehicle;

public class Reservation {
    int reservationId;
    Vehicle vehicle;
    User user;
    LocalDate bookingDate;
    LocalDate dateBookedFrom;
    LocalDate dateBookedTo;
    long fromTimeStamp;
    long toTimeStamp;
    Location pickUpLocation;
    Location dropOffLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    public int createReserve(User user, Vehicle vehicle){
        //generate reservation id
        reservationId = 123;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.WEEKLY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
