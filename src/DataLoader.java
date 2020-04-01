import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
}