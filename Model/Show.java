package Model;

import java.util.ArrayList;

public class Show {
    int id;
    Movie movie;
    int startTime;
    int duration;
    ArrayList<Seat> seats;
    Screen screen;


    public Show(int id, Movie movie, int startTime, int duration, Screen screen) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.duration = duration;
        this.seats = new ArrayList<>(120);
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
