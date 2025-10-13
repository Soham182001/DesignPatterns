package BookMyShowLLD;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    String showTime; // For simplicity, using String. In real scenarios, use Date or LocalDateTime
    List<Integer> bookedSeats = new ArrayList<>();

    // getters and setters
    public int getShowId() {
        return showId;
    }
    public void setShowId(int showId) {
        this.showId = showId;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public String getShowTime() {
        return showTime;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    public List<Integer> getBookedSeats(){
        return bookedSeats;
    }
    public void setBookedSeats(List<Integer> bookedSeats){
        this.bookedSeats = bookedSeats;
    }
}