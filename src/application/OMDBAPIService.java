package application;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class OMDBAPIService {

	private static final String API_KEY = "1ed1b1d9";
	private static final String SEARCH_URL = "https://www.omdbapi.com/?apikey="+API_KEY + "&s=";
	
	public String searchMovies (String searchParam) throws IOException, InterruptedException{
		String encodedSearchParam=URLEncoder.encode(searchParam,StandardCharsets.UTF_8);
		
		//Construct the URL for the API Call
		String apiUrl = SEARCH_URL + encodedSearchParam;
		
		//Create a HttpClient
		HttpClient client = HttpClient.newHttpClient();
	
		//Create the Http Request
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
		
		//Send the request and handle the response aschronchously
		HttpResponse<String>response = client.send(request,BodyHandlers.ofString());
	
		//Return the response body
		return response.body();
		
	}
	
	public static void main(String[] args) {
		OMDBAPIService omdbService = new OMDBAPIService();
		try {
			//Example search parameter
			String searchParam = "Farzi";
			//Make the API call
			String response = omdbService.searchMovies(searchParam);
			
			//Print Response
			System.out.println(response);
		}
		catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
