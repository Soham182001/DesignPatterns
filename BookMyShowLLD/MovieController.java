package BookMyShowLLD;

import BookMyShowLLD.Enums.City;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {
    Map<City, List<Movie>> cityMovieMap;
    List<Movie> allMovies;


    MovieController(){
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }



    void addMovie(Movie movie, City city) {
        allMovies.add(movie);

        List<Movie> movies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMap.put(city, movies);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie: allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMovieByCity(City city){
        return cityMovieMap.getOrDefault(city, new ArrayList<>());
    }

    // All CRUD operations like Remove Movie, Update Movie etc.
}
