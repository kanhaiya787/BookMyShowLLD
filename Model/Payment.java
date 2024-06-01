package Model;
import java.util.ArrayList;
import java.util.Random;

public class Payment {
    PaymentStatus paymentStatus;

    public Payment() {
        this.paymentStatus = null;
    }

    public PaymentStatus makePayment(ArrayList<Seat> seats){
        //Randomly pick either success or failure for payment status
        for(Seat s: seats)
            s.setSeatAvailability(SeatAvailability.TEMPORARILY_UNAVAILABLE);
        PaymentStatus[] paymentStatus = {PaymentStatus.SUCCESS, PaymentStatus.FAILED};
        Random random = new Random();
        PaymentStatus randomElement = paymentStatus[random.nextInt(paymentStatus.length)];
        return PaymentStatus.SUCCESS;
    }
}
