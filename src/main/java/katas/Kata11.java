package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    public static List<Map> execute() {
	List<Map> lists = DataUtil.getLists();
	List<Map> videos = DataUtil.getVideos();
	List<Map> boxArts = DataUtil.getBoxArts();
	List<Map> bookmarkList = DataUtil.getBookmarkList();

	return lists.stream().map(list -> ImmutableMap.of("name", list.get("name"), "videos",
		videos.stream().filter(video -> video.get("listId").equals(list.get("id")))
			.map(video -> ImmutableMap.of("id", video.get("id"), "title", video.get("title"), "time",
				getTime(video.get("id"), bookmarkList), "boxart", getSmallestBoxArtUrl(boxArts)))
			.collect(Collectors.toList())))
		.collect(Collectors.toList());

    }

    private static String getSmallestBoxArtUrl(List<Map> boxArts) {

	Optional<String> boxUrl = boxArts.stream()
		.min((box1, box2) -> Integer.compare((Integer) box1.get("width") * (Integer) box1.get("height"),
			(Integer) box2.get("width") * (Integer) box2.get("height")))
		.map(boxArt -> boxArt.get("url").toString());

	return boxUrl.isPresent() ? boxUrl.get() : "";

    }

    private static Object getTime(Object videoId, List<Map> bookmarkList) {

	Optional bookmarkTime = bookmarkList.stream().filter(bookmark -> bookmark.get("videoId").equals(videoId))
		.map(bookmark -> bookmark.get("time")).findFirst();

	return bookmarkTime.isPresent() ? bookmarkTime.get() : "";
    }
}
