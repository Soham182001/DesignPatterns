package BookMyShowLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import BookMyShowLLD.Enums.City;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> theatres;

    TheatreController(){
        cityTheatreMap = new HashMap<>();
        theatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city){
        theatres.add(theatre);
        List<Theatre> cityTheatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        cityTheatres.add(theatre);
        cityTheatreMap.put(city, cityTheatres);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
        Map<Theatre, List<Show>> theatreShowMap = new HashMap<>();
        List<Theatre> cityTheatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        for(Theatre theatre: cityTheatres){
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show: shows){
                if(show.movie.getMovieId() == movie.getMovieId()){
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()){
                theatreShowMap.put(theatre, givenMovieShows);
            }
        }
        return theatreShowMap;
    }
}
