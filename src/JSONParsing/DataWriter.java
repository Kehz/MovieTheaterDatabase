package JSONParsing;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	
	
	public static void saveShows() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Show> showList = dataLists.getShows();
		JSONArray jsonTitles = new JSONArray();
		
		for (int i = 0; i < showList.size(); i++) {
			jsonTitles.add(getShowsJSON(showList.get(i)));
		}
		
		//write json
		try (FileWriter file = new FileWriter(SHOW_FILE_NAME)){
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
	
	public static JSONObject getShowsJSON(Show show) {
		JSONObject showDetails = new JSONObject();
		showDetails.put(SHOW_TITLE, show.getTitle());
		showDetails.put(SHOW_LENGTH, show.getLength());
		showDetails.put(SHOW_RELEASE_YEAR, show.getReleaseYear());
		showDetails.put(SHOW_GENRE, show.getGenre());
		showDetails.put(SHOW_DIRECTOR, show.getDirector());
		showDetails.put(SHOW_RATINGS, show.getRating());
		showDetails.put(SHOW_REVIEWS, show.getReviews());
		return showDetails;
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
