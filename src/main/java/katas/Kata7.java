package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
	
	private Kata7() {}
	
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
	        .flatMap(list -> list.getVideos().stream())
			.map(movie -> ImmutableMap.of(
					"id", movie.getId() ,
					"title", movie.getTitle(), 
					"boxart", getSmallestBoxArtUrl(movie.getBoxarts())))
			.collect(Collectors.toList());
        
    }
    
    public static String getSmallestBoxArtUrl(List<BoxArt> boxArts) {
    	
    	Optional<String> boxUrl = boxArts.stream()
    			.min( (box1,box2) -> Integer.compare(box1.getWidth() * box1.getHeight(), box2.getHeight() * box2.getWidth()))
    			.map(BoxArt::getUrl);
    	
    	if(boxUrl.isPresent())
    		return boxUrl.get();
    	else
    		return null;

    }
}
