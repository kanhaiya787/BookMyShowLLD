package Model;

import java.util.*;

public class Theatre {
    int theatreId;
    String Address;
    ArrayList<Screen> screenList;
    ArrayList<Show> showList;

    public Theatre(int theatreId, String address, ArrayList<Screen> screenList, ArrayList<Show> showList) {
        this.theatreId = theatreId;
        Address = address;
        this.screenList = screenList;
        this.showList = showList;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Show> getShowList() {
        return showList;
    }

    public void setShowList(ArrayList<Show> showList) {
        this.showList = showList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(ArrayList<Screen> screenList) {
        this.screenList = screenList;
    }
}
