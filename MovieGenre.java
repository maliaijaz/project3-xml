
import java.util.ArrayList;

public class MovieGenre {

  // private variables of MovieGenre class

  // for each singular movie entered into the database
  private String movieDirector;

  // for multiple directors
  private ArrayList<String> movieDirectors;

  // for multiple genres
  private ArrayList<String> movieGenres;

  private String movieTitle;
  private String movieYear;
  private String movieGenre;
  private String movieId;

  // the following values will be set to null
  private String trailerUrl = null;
  private String bannerUrl = null;

  public MovieGenre() {
    movieTitle = "";
    movieYear = "";
    movieGenre = "";
    movieId = "";
    movieDirectors = new ArrayList<String>();
    movieGenres = new ArrayList<String>();

  }

// Director arraylist methods

public ArrayList<String> getDirectorsList() {
  return movieDirectors;
}

public void addDirectorToList(String director) {
  movieDirectors.add(director);
}

public String getMovieDirector() {
	return movieDirector;
}

public void setMovieDirector(String movieDirector) {
	this.movieDirector = movieDirector;
}

public String getMovieTitle() {
	return movieTitle;
}

public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
}

public String getMovieYear() {
	return movieYear;
}

public void setMovieYear(String movieYear) {
	this.movieYear = movieYear;
}

public String getMovieGenre() {
	return movieGenre;
}

public void setMovieGenre(String movieGenre) {
	this.movieGenre = movieGenre;
}

public String getMovieId() {
	return movieId;
}

public void setMovieId(String movieId) {
	this.movieId = movieId;
}

public String getTrailerUrl() {
	return trailerUrl;
}

public void setTrailerUrl(String trailerUrl) {
	this.trailerUrl = trailerUrl;
}

public String getBannerUrl() {
	return bannerUrl;
}

public void setBannerUrl(String bannerUrl) {
	this.bannerUrl = bannerUrl;
}

public String toString() {
  StringBuffer sb = new StringBuffer();
  int counter = 1;
  sb.append("Director Details - " + counter);
  for (String director : movieDirectors){
    sb.append("Director Name:" + director + "\n");
  }
  sb.append("\n-Movie info--\n");
  sb.append("Movie ID: " + getMovieId() + "\n");
  sb.append("Movie Name: " + getMovieTitle() + "\n");
  sb.append("Movie Genre: " + getMovieGenre() + "\n");
  counter++;
  return sb.toString();
  }




}
