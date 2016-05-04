import java.util.ArrayList;

public class Star {

  // private variables
  private String starFullName;
  private String starFirstName;
  private String starLastName;
  private String starId;

  // List of movies they starred in
  private ArrayList<String> arrayOfMovieStrings;
  private ArrayList<MovieGenre> arrayOfMovieGenres;

  public Star () {
    starFullName = "";
    starFirstName = "";
    starLastName = "";
    starId = "";

    arrayOfMovieStrings = new ArrayList<String>();
    arrayOfMovieGenres = new ArrayList<MovieGenre>();
  }

  public void setStarFullName(String name){
    starFullName = name;
  }

  public void setFirstName(String first){
    starFirstName = first;
  }

  public void setLastName(String last){
    starLastName = last;
  }

  public void setStarId(String id){
    starId = id;
  }

  public void addMovieTitle(String title) {
    arrayOfMovieStrings.add(title);
  }

  public void addMovieGenres(MovieGenre movie) {
    arrayOfMovieGenres.add(movie);
  }

  public String getStarFullName(){
    return starFullName;
  }

  public String getStarFirstName(){
    return starFirstName;
  }

  public String getStarLastName(){
    return starLastName;
  }

  public String getStarId(){
    return starId;
  }

  public ArrayList<MovieGenre> getMovieGenres() {
    return arrayOfMovieGenres;
  }

  public ArrayList<String> getMovieTitles() {
    return arrayOfMovieStrings;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    int counter = 1;
    sb.append("Movie Details - " + counter);
    for (String movieTitle : arrayOfMovieStrings){
      sb.append("Name of movie:" + movieTitle + "\n");
    }
    sb.append("\n-Star info--\n");
    sb.append("Star ID: " + getStarId() + "\n");
    sb.append("Star name: " + getStarFullName() + "\n");
    // sb.append("Movie Genre: " + getMovieGenre() + "\n");
    counter++;
    return sb.toString();
  }










}
