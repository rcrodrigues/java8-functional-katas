package katas;

import java.util.List;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
	
	private Kata6() {}
	
    public static String execute() {
        List<MovieList> movieList = DataUtil.getMovieLists();
        
        return movieList.stream()
        	.flatMap(list -> list.getVideos().stream())
        	.flatMap(movies -> movies.getBoxarts().stream())
        	.reduce((box1, box2) -> box1.getWidth() > box2.getWidth() ? box1 : box2)
        	.map(BoxArt::getUrl)
        	.orElse(null);
    }
}
