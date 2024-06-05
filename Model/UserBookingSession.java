package Model;

import java.util.ArrayList;
import java.util.List;

public class UserBookingSession {
    Show show;
    ArrayList<Seat> bookedSeats;
    Payment payment;

    public UserBookingSession(Show show) {
        this.show = show;
        bookedSeats = new ArrayList<>();
    }

    public ArrayList<Seat> fetchAvaialbleSeats(){
        ArrayList<Seat> seats =  this.show.getSeats();
        ArrayList<Seat> availableSeats = new ArrayList<>();
        for(Seat seat: seats){
            if(seat.seatAvailability == SeatAvailability.AVAILABLE){
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public void createBooking(ArrayList<Seat> seats){
        seats.forEach(Seat::lock);
        try {
            for (Seat s : seats) {
                if (s.getSeatAvailability() != SeatAvailability.AVAILABLE) {
                    throw new RuntimeException("One or more seats selected are not available at this moment");
                }
                s.setSeatAvailability(SeatAvailability.TEMPORARILY_UNAVAILABLE);
            }
        } finally {
            seats.forEach(Seat::unlock);
        }
        payment = new Payment();
        PaymentStatus paymentStatus = payment.makePayment(seats);
        if(paymentStatus == PaymentStatus.FAILED){
            System.out.println("Payment Failed for "+this.show.getMovie().getName()+show.startTime+" on screen "+show.screen.getSid());
            for(Seat seat: seats){
                seat.setSeatAvailability(SeatAvailability.AVAILABLE);
            }
            return;
        }
        else if(paymentStatus == PaymentStatus.SUCCESS){
            System.out.println("Payment Passed for "+this.show.getMovie().getName()+show.startTime+" on screen "+show.screen.getSid());
            seats.forEach(Seat::lock);
            try {
                for (Seat seat : seats) {
                    seat.setSeatAvailability(SeatAvailability.PERMANENTLY_UNAVAILABLE);
                }
            } finally {
                seats.forEach(Seat::unlock);
            }
        }
        ArrayList<Integer> seat_ids = new ArrayList<>();
        for(Seat seat: seats){
            seat_ids.add(seat.seatId);
        }
        System.out.println("Show is booked for movie name: "+this.show.getMovie().getName()+" Time: "+show.startTime+" on screen "+show.screen.getSid()+" Seats: "+seat_ids);
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
