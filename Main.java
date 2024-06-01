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

        Semaphore semaphore = new Semaphore(1);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BookMyShow bookMyShow = new BookMyShow(semaphore);
        Thread user1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bookMyShow.startBooking();
            }
        });
        Thread user2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bookMyShow.startBooking();
            }
        });
        user1.start();
        user2.start();
    }
}