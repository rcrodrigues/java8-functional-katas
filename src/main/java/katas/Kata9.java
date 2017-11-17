package katas;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

    private Kata9() {
    }

    public static List<Map> execute() {

	List<Movie> movies = DataUtil.getMovies();

	return movies.stream()
		.map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "time",
			getMiddleInterestingMoment(movie.getInterestingMoments()), "url",
			getSmallestBoxArtUrl(movie.getBoxarts())))
		.collect(Collectors.toList());

    }

    private static Date getMiddleInterestingMoment(List<InterestingMoment> moments) {

	Optional<Date> middleMoment = moments.stream().filter(moment -> moment.getType().equals("Middle"))
		.map(InterestingMoment::getTime).findFirst();

	return middleMoment.isPresent() ? middleMoment.get() : null;

    }

    private static String getSmallestBoxArtUrl(List<BoxArt> boxArts) {

	Optional<String> boxUrl = boxArts.stream().min(
		(box1, box2) -> Integer.compare(box1.getWidth() * box1.getHeight(), box2.getHeight() * box2.getWidth()))
		.map(BoxArt::getUrl);

	return boxUrl.isPresent() ? boxUrl.get() : "";

    }
}
