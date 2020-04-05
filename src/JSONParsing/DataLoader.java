package JSONParsing;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
    public static ArrayList<Show> loadShows() {
    	ArrayList<Show> shows = new ArrayList<Show>();
    	
    	try {
    		FileReader reader = new FileReader(SHOW_FILE_NAME);
    		JSONParser parser = new JSONParser();
    		JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);
    		
    		for (int i = 0; i < showJSON.size(); i++) {
    			JSONObject showListJSON = (JSONObject)showJSON.get(i);
    			String title = (String)showListJSON.get(SHOW_TITLE);
    			long length = (long)showListJSON.get(SHOW_LENGTH);
    			long releaseYear = (long)showListJSON.get(SHOW_RELEASE_YEAR);
    			String genre = (String)showListJSON.get(SHOW_GENRE);
    			String director = (String)showListJSON.get(SHOW_DIRECTOR);
    			long rating = (long)showListJSON.get(SHOW_RATINGS);
    			String reviews = (String)showListJSON.get(SHOW_REVIEWS);
    				int fixedLength = (int)length;
    			int fixedReleaseYear = (int)releaseYear;
    			int fixedRating = (int)rating;
    			
    			shows.add(new Show(title, fixedLength, fixedReleaseYear, genre, director, fixedRating, reviews));
    		}
    		return shows;
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
    		JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);
    		
    		for (int i = 0; i < showJSON.size(); i++) {
    			JSONObject showListJSON = (JSONObject)showJSON.get(i);
    			String title = (String)showListJSON.get(THEATER_NAME);
    			long rating = (long)showListJSON.get(THEATER_RATINGS);
    			String reviews = (String)showListJSON.get(THEATER_REVIEWS);
    			
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
    		JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);
    		for (int i = 0; i < showJSON.size(); i++) {
    			JSONObject showListJSON = (JSONObject)showJSON.get(i);
    			String username = (String)showListJSON.get(USER_USERNAME);
    			String password = (String)showListJSON.get(USER_PASSWORD);
    			String email = (String)showListJSON.get(USER_EMAIL);
    			long longAge = (long)showListJSON.get(USER_AGE);
    			long longPoints = (long)showListJSON.get(USER_POINTS);
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