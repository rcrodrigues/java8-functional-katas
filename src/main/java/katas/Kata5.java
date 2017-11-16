package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        if(movies.isEmpty())
        	return null;
        
        return movies.stream()
        		.map(Movie::getRating)
        		.max((rating1, rating2) -> Double.compare( rating1, rating2))
        		.orElse(0.0);
        		        
    }
}
