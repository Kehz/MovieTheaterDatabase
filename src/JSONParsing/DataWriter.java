package JSONParsing;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.Movie;
import main.Play;
import main.Show;
import main.Theaters;
import main.User;
/**
 * 
 * @author Devin Adams
 * This class extends the DataConstants class and handles the data writing
 * to our jsons. It takes in the current arraylists and writes the data into
 * the file
 */
public class DataWriter extends DataConstants {
	
	
	public static void saveMovies() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		JSONArray jsonTitles = new JSONArray();
		
		for (int i = 0; i < movieList.size(); i++) {
			jsonTitles.add(getMoviesJSON(movieList.get(i)));
		}
		
		//write json
		try (FileWriter file = new FileWriter(MOVIE_FILE_NAME)){
			file.write(jsonTitles.toJSONString());
			file.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void savePlays() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> playList = dataLists.getPlays();
		JSONArray jsonTitles = new JSONArray();
		
		for (int i = 0; i < playList.size(); i++) {
			jsonTitles.add(getPlaysJSON(playList.get(i)));
		}
		
		//write json
		try (FileWriter file = new FileWriter(PLAY_FILE_NAME)){
			file.write(jsonTitles.toJSONString());
			file.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveTheaters() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterList = dataLists.getTheaters();
		JSONArray jsonTitles = new JSONArray();
		
		for (int i = 0; i < theaterList.size(); i++) {
			jsonTitles.add(getTheatersJSON(theaterList.get(i)));
		}
		
		//write json
		try (FileWriter file = new FileWriter(THEATER_FILE_NAME)){
			file.write(jsonTitles.toJSONString());
			file.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveUsers() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		JSONArray jsonTitles = new JSONArray();
		
		for (int i = 0; i < userList.size(); i++) {
			jsonTitles.add(getUsersJSON(userList.get(i)));
		}
		
		try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
			file.write(jsonTitles.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getMoviesJSON(Movie movie) {
		JSONObject movieDetails = new JSONObject();
		movieDetails.put(MOVIE_ID, movie.getId());
		movieDetails.put(MOVIE_TITLE, movie.getTitle());
		movieDetails.put(MOVIE_LENGTH, movie.getLength());
		movieDetails.put(MOVIE_RELEASE_YEAR, movie.getReleaseYear());
		movieDetails.put(MOVIE_GENRE, movie.getGenre());
		movieDetails.put(MOVIE_DIRECTOR, movie.getDirector());
		movieDetails.put(MOVIE_RATINGS, movie.getRating());
		movieDetails.put(MOVIE_REVIEWS, movie.getReviews());
		movieDetails.put(MOVIE_AGE_RATING, movie.getAgeRating());
		movieDetails.put(MOVIE_SHOW_TIMES, movie.getShowTimes());
		return movieDetails;
	}
	
	public static JSONObject getPlaysJSON(Play plays) {
		JSONObject playDetails = new JSONObject();
		playDetails.put(PLAY_ID, plays.getId());
		playDetails.put(PLAY_TITLE, plays.getTitle());
		playDetails.put(PLAY_LENGTH, plays.getLength());
		playDetails.put(PLAY_GENRE, plays.getGenre());
		playDetails.put(PLAY_DIRECTOR, plays.getDirector());
		playDetails.put(PLAY_RATING, plays.getRating());
		playDetails.put(PLAY_REVIEWS, plays.getReviews());
		playDetails.put(PLAY_SHOW_TIMES, plays.getShowTimes());
		playDetails.put(PLAY_ACTOR_AMOUNT, plays.getAmountActors());
		playDetails.put(PLAY_TIMES_PERFORMED, plays.getTimesPerformed());
		return playDetails;
	}
	
	public static JSONObject getTheatersJSON(Theaters theaters) {
		JSONObject theaterDetails = new JSONObject();
		theaterDetails.put(THEATER_NAME,theaters.getTitle());
		theaterDetails.put(THEATER_RATINGS,theaters.getRatings());
		theaterDetails.put(THEATER_REVIEWS,theaters.getReviews());
		return theaterDetails;
	}
	
	public static JSONObject getUsersJSON(User users) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_USERNAME, users.getUsername());
		userDetails.put(USER_PASSWORD, users.getPassword());
		userDetails.put(USER_EMAIL, users.getEmail());
		userDetails.put(USER_AGE, users.getAge());
		userDetails.put(USER_POINTS, users.getPoints());
		return userDetails;
	}
}
