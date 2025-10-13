package BookMyShowLLD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import BookMyShowLLD.Enums.*;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow(){
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

                //user1
        bookMyShow.createBooking(City.BANGALORE, "KRISH");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "KRISH");


    }

    private void createBooking(City userCity, String movieName){
        // fetch all movies according to user city
        List<Movie> movies = movieController.getMovieByCity(userCity);

        // selecting the movie that user want to see
        Movie interestedMovie = null;
        for(Movie movie: movies){
            if((movie.getMovieName() == movieName)){
                interestedMovie = movie;
            }
        }

        // get all shows of this movie in bengalore location
        Map<Theatre, List<Show>> showTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        // select the particular show user is interested in
        Map.Entry<Theatre, List<Show>> entry = showTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interesetShow = runningShows.get(0);

        // select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interesetShow.getBookedSeats();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat: interesetShow.getScreen().getSeats()){
                if(screenSeat.getSeatId() == seatNumber){
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interesetShow);
        }else{
            System.out.println("Seats Already Booked!!");
            return;
        }
        System.out.println("Booking Done SUCCESSFULLY!");
    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        Movie krish = movieController.getMovieByName("KRISH");
        Movie bahubali = movieController.getMovieByName("BAAHUBALI");
        Movie avengers = movieController.getMovieByName("AVENGERS");


        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreen().get(0), krish, "08:00");
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0), bahubali, "16:00");
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.PUNE);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreen().get(0), avengers, "13:00");
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreen().get(0), bahubali, "20:00");
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);


        theatreController.addTheatre(inoxTheatre, City.BANGALORE);
        theatreController.addTheatre(pvrTheatre, City.PUNE);
    }

    private Show createShows(int showId, Screen screen, Movie movie, String showTime) {
        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowId(showId);
        show.setShowTime(showTime);
        return show;
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for(int i = 1; i<=20; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for(int i = 21; i<=50; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for(int i = 51; i<=70; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        for(int i = 71; i<=80; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.RECLINER);
            seats.add(seat);
        }
        return seats;
    }

    private void createMovies() {
        //create Movies1
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setDuration(180);
        
        //create Movies3
        Movie krish = new Movie();
        krish.setMovieId(3);
        krish.setMovieName("KRISH");
        krish.setDuration(150);
        

        //add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.PUNE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(baahubali, City.PUNE);
        movieController.addMovie(baahubali, City.BANGALORE);
        movieController.addMovie(baahubali, City.KOLKATA);
        movieController.addMovie(baahubali, City.DELHI);
        movieController.addMovie(krish, City.BANGALORE);
        movieController.addMovie(krish, City.PUNE);
        movieController.addMovie(krish, City.MUMBAI);
    }
}
