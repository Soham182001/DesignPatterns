package BookMyShowLLD;

public class Movie {
    int movieId;
    String movieName;
    int duration; // in minutes

    // getters and setters
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
