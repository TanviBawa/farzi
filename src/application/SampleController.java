package application;

import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import com.google.gson.Gson;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SampleController {
	
	 @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private BorderPane borderPane;

	    @FXML
	    private Button btnSearch;

	 
	    @FXML
	    private HBox hBox;

	    @FXML
	    private Label mTitle;

	    @FXML
	    private Label mID;
	    
	    @FXML
	    private Label mYear;
	    
	    @FXML
	    private Label mType;

	    @FXML
	    private ImageView posterImageView;

	    @FXML
	    private TextField searchMovie;

	    @FXML
	    private Label searchTextField;

	    public void getSearchResults() {
	    	OMDBAPIService omdbService = new OMDBAPIService();
	    	try {
	    		// Get the search parameter from the TextField
	    		String searchParam = searchMovie.getText();
	    		System.out.println(searchParam);
	    		// Make the API call
	    		String jsonInput = omdbService.searchMovies(searchParam);
	    		// Print the response
	    		System.out.println(jsonInput);
	    		
	    		Gson gson = new Gson();
	    		// Parse JSON string to SearchResult object
	    		SearchResult searchResult = gson.fromJson(jsonInput, SearchResult.class);
	    		
	    		// Access individual movie elements and print them
	    		int i = 0;
	    		for (Movie movie : searchResult.getSearch()) {
	    			if (i == 0) {
	    				System.out.println("Title: " + movie.getTitle());
	    				System.out.println("Year: " + movie.getYear());
	    				System.out.println("imdbID: " + movie.getimdbID());
	    				System.out.println("Type: " + movie.getType());
	    				System.out.println("Poster: " + movie.getPoster());
	    				System.out.println();
	    				i++;
	    				
	    				// Title
	    				mTitle.setText(movie.getTitle());
	    				
	    				// Year
	    				mYear.setText(movie.getYear());
	    				
	    				// Type
	    				mType.setText(movie.getType());
	    				
	    				// ID
	    				mID.setText(movie.getimdbID());
	    				
	    				// Poster
	    				String imageUrl = movie.getPoster();
	    				this.setPosterImage(imageUrl);
	    			}
	    		}
	    	} catch (IOException | InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
	    	
	    // Method to set image for posterImageView
	    public void setPosterImage(String imageUrl) {
	    	Image image = new Image(imageUrl);
	    	posterImageView.setImage(image);
	    }
}
