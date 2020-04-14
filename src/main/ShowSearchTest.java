package main;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import JSONParsing.DataLists;

class ShowSearchTest {

	
	
	@Test
	public void testSearchByGenre() {
		ShowSearch test = new ShowSearch();
		String showType = "movie";
		String genreSearch= "Action"; 
		test.searchByGenre(true, showType, genreSearch);
		System.out.println();
	}
	
	
	@Test
	public void testSearchByAgeRating() {
		ShowSearch test = new ShowSearch();
		String showType = "movie";
		String ageRating= "R"; 
		test.searchByAgeRating(true, showType, ageRating);
		System.out.println();
	}
	
	@Test
	public void searchByAgeRating2() {
		ShowSearch test = new ShowSearch();
		String showType = "movie";
		String ageRating= "PG"; 
		test.searchByAgeRating(true, showType, ageRating);
		System.out.println();
	}
	
	@Test
	public void SearchByTheater() {
		ShowSearch test = new ShowSearch();
		String theaterName= "Royal Theater";
		test.searchByTheater(theaterName);
	}

}
