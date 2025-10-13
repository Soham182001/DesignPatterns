package BookMyShowLLD;

import java.util.List;
import java.util.ArrayList;

public class Booking {
    Show show;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;

    public Show getShow(){
        return this.show;
    }
    public void setShow(Show show){
        this.show = show;
    }
    public List<Seat> getBookSeats(){
        return this.bookedSeats;
    }
    public void setBookedSeats(List<Seat> seats){
        this.bookedSeats = seats;
    }
    public Payment getPayment(){
        return this.payment;
    }
    public void setPayment(Payment payment){
        this.payment = payment;
    }
}
