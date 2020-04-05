package JSONParsing;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.Movie;
import main.Play;
import main.Show;
import main.Theaters;
import main.User;

/**
 * 
 * @author Devin Adams
 * This class parses the data from our json files while gettings its
 * object info from the DataConstants file. It adds the values to the 
 * array lists which will be returned and called from DataLists class
 */
public class DataLoader extends DataConstants{
	
	/**
	 * This function loads data from the json file and adds it to an arraylist
	 * @return returns an array list of shows parsed from the shows.json
	 */
    public static ArrayList<Movie> loadMovies() {
    	ArrayList<Movie> movies = new ArrayList<Movie>();
    	
    	try {
    		FileReader reader = new FileReader(MOVIE_FILE_NAME);
    		JSONParser parser = new JSONParser();
    		JSONArray movieJSON = (JSONArray)new JSONParser().parse(reader);
    		
    		for (int i = 0; i < movieJSON.size(); i++) {
    			JSONObject movieListJSON = (JSONObject)movieJSON.get(i);
    			long longId = (long)movieListJSON.get(MOVIE_ID);
    			String title = (String)movieListJSON.get(MOVIE_TITLE);
    			long longLength = (long)movieListJSON.get(MOVIE_LENGTH);
    			long longReleaseYear = (long)movieListJSON.get(MOVIE_RELEASE_YEAR);
    			String genre = (String)movieListJSON.get(MOVIE_GENRE);
    			String director = (String)movieListJSON.get(MOVIE_DIRECTOR);
    			long longRating = (long)movieListJSON.get(MOVIE_RATINGS);
    			String reviews = (String)movieListJSON.get(MOVIE_REVIEWS);
    			String showTimes = (String)movieListJSON.get(MOVIE_SHOW_TIMES);
    			String ageRating = (String)movieListJSON.get(MOVIE_AGE_RATING);
    			int id = (int)longId;
    			int length = (int)longLength;
    			int releaseYear = (int)longReleaseYear;
    			int rating = (int)longRating;
    			
    			movies.add(new Movie(id, title, length, genre, director, rating, reviews, showTimes, ageRating, releaseYear));
    		}
    		return movies;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }	
    
    public static ArrayList<Play> loadPlays() {
    	ArrayList<Play> plays = new ArrayList<Play>();
    	
    	try {
    		FileReader reader = new FileReader(PLAY_FILE_NAME);
    		JSONParser parser = new JSONParser();
    		JSONArray playJSON = (JSONArray)new JSONParser().parse(reader);
    		
    		for (int i = 0; i < playJSON.size(); i++) {
    			JSONObject playListJSON = (JSONObject)playJSON.get(i);
    			long longId = (long)playListJSON.get(PLAY_ID);
    			String title = (String)playListJSON.get(PLAY_TITLE);
    			long longLength = (long)playListJSON.get(PLAY_LENGTH);
    			String genre = (String)playListJSON.get(PLAY_GENRE);
    			String director = (String)playListJSON.get(PLAY_DIRECTOR);
    			long longRating = (long)playListJSON.get(PLAY_RATING);
    			String reviews = (String)playListJSON.get(PLAY_REVIEWS);
    			String showTimes = (String)playListJSON.get(PLAY_SHOW_TIMES);
    			long longActorAmount = (long)playListJSON.get(PLAY_ACTOR_AMOUNT);
    			long longTimesPerformed = (long)playListJSON.get(PLAY_TIMES_PERFORMED);
    			int id = (int)longId;
    			int length = (int)longLength;
    			int rating = (int)longRating;
    			int actorAmount = (int)longActorAmount;
    			int timesPerformed = (int)longTimesPerformed;
    			
    			plays.add(new Play(id, title, length, genre, director, rating, reviews, showTimes, actorAmount, timesPerformed));
    		}
    		return plays;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }	
    
    
    /**
	 * This function loads data from the json file and adds it to an arraylist
	 * @return returns an array list of theaters parsed from the theaters.json
	 */
    public static ArrayList<Theaters> loadTheaters() {
    	ArrayList<Theaters> theaters = new ArrayList<Theaters>();
    	try {
    		FileReader reader = new FileReader(THEATER_FILE_NAME);
    		JSONParser parser = new JSONParser();
    		JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);
    		
    		for (int i = 0; i < theaterJSON.size(); i++) {
    			JSONObject theaterListJSON = (JSONObject)theaterJSON.get(i);
    			String title = (String)theaterListJSON.get(THEATER_NAME);
    			long rating = (long)theaterListJSON.get(THEATER_RATINGS);
    			String reviews = (String)theaterListJSON.get(THEATER_REVIEWS);
    			int intRating = (int)rating;
    			theaters.add(new Theaters(title, intRating, reviews));
    		}
    		return theaters;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    /**
     * This function loads data from the json file and adds it to an arraylist
     * @return returns an array list of users parsed from the users.json
     */
    public static ArrayList<User> loadUsers() {
    	ArrayList<User> users = new ArrayList<User>();
    	try {
    		FileReader reader = new FileReader(USER_FILE_NAME);
    		JSONParser parser = new JSONParser();
    		JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);
    		for (int i = 0; i < userJSON.size(); i++) {
    			JSONObject userJSONList = (JSONObject)userJSON.get(i);
    			String username = (String)userJSONList.get(USER_USERNAME);
    			String password = (String)userJSONList.get(USER_PASSWORD);
    			String email = (String)userJSONList.get(USER_EMAIL);
    			long longAge = (long)userJSONList.get(USER_AGE);
    			long longPoints = (long)userJSONList.get(USER_POINTS);
    			int age = (int)longAge;
    			int points = (int)longPoints;
    			users.add(new User(username, password, email, age, points));
    		}
    		return users;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    	
}