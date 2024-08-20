package application;

import java.util.List;

public class SearchResult {
	public List<Movie>Search;
	 //getter and setter for the search list
	public List<Movie>getSearch(){
		return Search;
	}
	public void setSearch(List<Movie>search) {
		this.Search = search;
	}
}
