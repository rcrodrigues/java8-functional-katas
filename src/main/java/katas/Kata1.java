package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
	
	public static void main(String[] args) {
		System.out.println("Initiating First Kata");
		System.out.println(execute());
	}
	
    public static List<Map> execute() {
        
    	List<Movie> movies = DataUtil.getMovies();	
            
        return movies.stream().map(movie -> {
        	
        	Map<String,String> movieMap = new HashMap<String, String>();
        	movieMap.put("id", movie.getId().toString());
        	movieMap.put("title", movie.getTitle());
        	return movieMap;
        	
        }).collect(Collectors.toList());
        
    }
}
