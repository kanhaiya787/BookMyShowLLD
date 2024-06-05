import Model.Seat;
import Model.Show;
import Model.TheatreController;
import Model.UserBookingSession;

import java.util.List;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        Thread user1 = new Thread(bookMyShow::startBooking);
        Thread user2 = new Thread(bookMyShow::startBooking);
        user1.start();
        user2.start();
    }
}