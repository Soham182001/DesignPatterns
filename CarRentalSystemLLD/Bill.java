package CarRentalSystemLLD;

public class Bill {
    Reservation reservation;
    double amount;
    boolean isPaid;

    Bill(Reservation reservation){
        this.reservation = reservation;
        this.amount = calculateAmount();
        this.isPaid = false;
    }

    private double calculateAmount(){
        //create your custom logic here
        return 100.0;
    }
}
