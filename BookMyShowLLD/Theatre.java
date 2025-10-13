package BookMyShowLLD;

import BookMyShowLLD.Enums.City;
import java.util.List;

public class Theatre {
    int theatreId;
    String address;
    String theatreName;
    City city;
    List<Screen> screens;
    List<Show> shows;

    // getters and setters
    public int getTheatreId() {
        return theatreId;
    }
    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTheatreName() {
        return theatreName;
    }
    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public List<Screen> getScreen() {
        return screens;
    }
    public void setScreen(List<Screen> screens) {
        this.screens = screens;
    }
    public List<Show> getShows() {
        return shows;
    }
    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
    
}
