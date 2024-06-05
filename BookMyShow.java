import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class BookMyShow {
    TheatreController theatreController;
    UserBookingSession userBookingSession;
    BookMyShow(){
        theatreController = new TheatreController();
        initialize();
    }

    public void initialize(){
        Movie bahuballi = new Movie(1, "Bahuballi", "War and action movie");
        Movie starwars = new Movie(2, "Star Wars", "Fiction Movie");
        ArrayList<Seat> seats = createSeats();
        Screen screen1 = new Screen(1);
        Show Show1 = new Show(1, bahuballi, 10, 180, screen1);
        Show Show2 = new Show(2, starwars, 16, 150, screen1);
        Show1.setSeats(seats);
        Show2.setSeats(seats);
        ArrayList<Screen> screens = new ArrayList<>();
        screens.add(screen1);
        ArrayList<Show> shows = new ArrayList<>();
        shows.add(Show1);
        shows.add(Show2);
        Theatre Inox = new Theatre(1, "Radhika Hyderabad", screens, shows);
        theatreController.addTheatre(Inox);
    }

    public void startBooking(){
        List<Show> show = theatreController.getAllShows("Bahuballi");
        Show show1= show.get(0);

        userBookingSession = new UserBookingSession(show1);
        ArrayList<Seat> seats =  userBookingSession.fetchAvaialbleSeats();
        ArrayList<Seat> preferredSeats = new ArrayList<>();
        Random rand = new Random();
        preferredSeats.add(seats.get(rand.nextInt(seats.size())));
        preferredSeats.add(seats.get(rand.nextInt(seats.size())));
        try {

            userBookingSession.createBooking(preferredSeats);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public ArrayList<Seat> createSeats(){
        ArrayList<Seat> al = new ArrayList<>(100);
        for(int i=0;i<100;i++){
            Seat seat = null;
            if(i<33)
                seat = new Seat(i,SeatAvailability.AVAILABLE,SeatType.SILVER);
            else if(i<70)
                seat = new Seat(i,SeatAvailability.AVAILABLE,SeatType.GOLD);
            else
                seat = new Seat(i,SeatAvailability.AVAILABLE,SeatType.PLATINUM);
            al.add(seat);
        }
        return al;
    }
}
