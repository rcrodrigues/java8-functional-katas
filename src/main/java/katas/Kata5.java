package katas;

import java.util.List;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

	private Kata5() {
	}

	public static Double execute() {
		List<Movie> movies = DataUtil.getMovies();

		if (movies.isEmpty())
			return null;

		return movies.stream().map(Movie::getRating).max(Double::compare).orElse(0.0);

	}
}
