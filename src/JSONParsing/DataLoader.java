package JSONParsing;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.Show;
import main.Theaters;

/*
 * parses our jsons and loads them into array lists
 * 
 */
public class DataLoader extends DataConstants{
	
	
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
    	
}