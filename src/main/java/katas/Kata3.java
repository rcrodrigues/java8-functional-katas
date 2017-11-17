package katas;

import java.util.List;
import java.util.stream.Collectors;

import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
	List<MovieList> movieLists = DataUtil.getMovieLists();

	return movieLists.stream().flatMap(list -> list.getVideos().stream()).map(Movie::getId)
		.collect(Collectors.toList());
    }
}
