package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {

	/*
	 * 
	 * Given a map Map<String, List<String>> userSongs with user names as keys and a
	 * list of all the songs that the user has listened to as values.
	 * 
	 * Also given a map Map<String, List<String>> songGenres, with song genre as
	 * keys and a list of all the songs within that genre as values. The song can
	 * only belong to only one genre.
	 * 
	 * The task is to return a map Map<String, List<String>>, where the key is a
	 * user name and the value is a list of the user's favorite genre(s). Favorite
	 * genre is the most listened to genre. A user can have more than one favorite
	 * genre if he/she has listened to the same number of songs per each of the
	 * genres.
	 * 
	 * Example 1:
	 * 
	 * Input: 
	 * 	userSongs = { 
	 * 		"David": ["song1", "song2", "song3", "song4", "song8"],
	 * 		"Emma": ["song5", "song6", "song7"] 
	 * 	}, 
	 * 	
	 * 	songGenres = { 
	 * 		"Rock": ["song1", "song3"], 
	 * 		"Dubstep": ["song7"], 
	 * 		"Techno": ["song2", "song4"], 
	 * 		"Pop": ["song5", "song6"], 
	 * 		"Jazz": ["song8", "song9"] 
	 * 	}
	 * 
	 * 	Output: { 
	 * 		"David": ["Rock", "Techno"], 
	 * 		"Emma": ["Pop"] 
	 * 	}
	 * 
	 * Explanation: David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite
	 * genres. Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
	 * Example 2:
	 * 
	 * Input: 
	 * 	userSongs = { 
	 * 		"David": ["song1", "song2"], 
	 * 		"Emma": ["song3", "song4"]
	 * 	}, 
	 * 	songGenres = {}
	 * 
	 * Output: { "David": [], "Emma": [] }
	 * 
	 */
	public static void main(String[] args) {
		Map<String, List<String>> userSongsMap = new HashMap<>();
		
		ArrayList<String> songs = null;
		
		songs = new ArrayList<>();
		songs.add("song1");
		songs.add("song2");
		songs.add("song3");
		songs.add("song4");
		songs.add("song8");
		userSongsMap.put("David", songs);
		
		songs = new ArrayList<>();
		songs.add("song5");
		songs.add("song6");
		songs.add("song7");
		userSongsMap.put("Emma", songs);

		Map<String, List<String>> genreSongsMap = new HashMap<>();
		
		songs = new ArrayList<>();
		songs.add("song1");
		songs.add("song3");
		genreSongsMap.put("Rock", songs);
		
		songs = new ArrayList<>();
		songs.add("song7");
		genreSongsMap.put("Dubstep", songs);
		
		
		songs = new ArrayList<>();
		songs.add("song2");
		songs.add("song4");
		genreSongsMap.put("Techno", songs);
		
		
		songs = new ArrayList<>();
		songs.add("song5");
		songs.add("song6");
		genreSongsMap.put("Pop", songs);
		
		songs = new ArrayList<>();
		songs.add("song8");
		songs.add("song9");
		genreSongsMap.put("Jazz", songs);
		
		System.out.println("Input :");
		System.out.println("User Songs : " + userSongsMap);
		System.out.println("Genre Songs : " + genreSongsMap);
		
		System.out.println("Output : " + favoriteGenres(userSongsMap, genreSongsMap));
	}
	
	public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongsMap, Map<String, List<String>> genreSongsMap) {
		Map<String, List<String>> rtnVal = new HashMap<>();
		Map<String, String> songGenreMap = new HashMap<>();
		for(Map.Entry<String, List<String>> entry : genreSongsMap.entrySet()) {
			String genre = entry.getKey();
			for(String song : entry.getValue()) {
				songGenreMap.put(song, genre);
			}
		}
		for(Map.Entry<String, List<String>> entry : userSongsMap.entrySet()) {
			String user = entry.getKey();
			List<String> genres = new ArrayList<String>();
			int max = 0;
			Map<String, Integer> genreCountMap = new HashMap<>();
			for(String song : entry.getValue()) {
				String genre = songGenreMap.get(song);
				int count = genreCountMap.getOrDefault(genre, 0) + 1;
				genreCountMap.put(genre, count);
				max = Math.max(max, count);
			}
			/*
			for(String genre : genreCountMap.keySet()) {
				if(genreCountMap.get(genre) == max) genres.add(genre);
			}
			*/
			for(Map.Entry<String, Integer> genreCount : genreCountMap.entrySet()) {
				if(genreCount.getValue() == max) genres.add(genreCount.getKey());
			}
			rtnVal.put(user, genres);
		}
		
		return rtnVal;
	}

}
