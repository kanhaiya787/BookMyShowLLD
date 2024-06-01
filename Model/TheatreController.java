package Model;

import java.util.ArrayList;
import java.util.Objects;

public class TheatreController {
    ArrayList<Theatre> theatres;

    public TheatreController() {
        this.theatres = new ArrayList<>();
    }

    public boolean addTheatre(Theatre theatre){
        theatres.add(theatre);
        System.out.println(theatres);
        return true;
    }

    public ArrayList<Show> getAllShows(String name){
        ArrayList<Show> al = new ArrayList<>();
        System.out.println(theatres);
        for(Theatre theatre: theatres){
            ArrayList<Show> shows = theatre.getShowList();
            for(Show show:shows){

                if(Objects.equals(show.getMovie().getName(), name))
                    al.add(show);
            }
        }
        return al;
    }


}
