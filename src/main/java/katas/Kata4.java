package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    private Kata4() {
    }

    private static final Integer BOXART_HEIGHT = 200;
    private static final Integer BOXART_WIDTH = 150;

    public static List<Map> execute() {

	List<MovieList> movieLists = DataUtil.getMovieLists();

	return movieLists.stream().flatMap(list -> list.getVideos().stream())
		.map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart",
			movie.getBoxarts().stream().filter(getBoxUrl()).map(BoxArt::getUrl).findFirst().orElse("")))
		.collect(Collectors.toList());

    }

    private static Predicate<BoxArt> getBoxUrl() {
	return boxArt -> BOXART_WIDTH.equals(boxArt.getWidth()) && BOXART_HEIGHT.equals(boxArt.getHeight());
    }

}
