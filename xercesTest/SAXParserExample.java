
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler{

	List movies;

	List stars;

	private String tempVal;

	//to maintain context
	private Movie tempMovie;
	private Star tempStar;



	public SAXParserExample(){
		movies = new ArrayList();
		stars = new ArrayList();
	}

	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {

		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("employees.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){

		System.out.println("No of Movies '" + movies.size() + "'.");

		Iterator itMovie = movies.iterator();
		while(itMovie.hasNext()) {
			System.out.println(itMovie.next().toString());
		}
		System.out.println("\n\n\n");

		System.out.println("Number of Stars '" + stars.size() + "'.");
		Iterator itStars = stars.iterator();
		while(itStars.hasNext()) {
			System.out.println(itStars.next().toString());
		}
	}


	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("dirfilms")) {
			//create a new instance of employee
			tempMovie = new Movie();
			// tempEmp.setType(attributes.getValue("type"));
		}
		if(qName.equalsIgnoreCase("m")) {
			//create a new instance of employee
			tempStar = new Star();
			// tempEmp.setType(attributes.getValue("type"));
		}
		// there could be several movies under a single director

	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("dirfilms")) {
			//add it to the list
			movies.add(tempMovie);
		}
		else if (qName.equalsIgnoreCase("m")){
			System.out.println("\nThe movie this star is in is: " + tempVal);

		}
		else if (qName.equalsIgnoreCase("a")){
			System.out.println("\nThe actor is: " + tempVal);

			// we need to split the actor's name into first and last name
      String[] starsArray = tempVal.split(" ");

			tempStar.setFirst_name(starsArray[0]);
			tempStar.setLast_name(starsArray[1]);


			// Give the movie object the Star object that consists of the name
			// tempMovie.addStar(tempStar);

			// we need to split the actor's name into first and last name

		}
		else if (qName.equalsIgnoreCase("dirid")) {
			System.out.println("The director ID is: " + tempVal);
		}else if (qName.equalsIgnoreCase("is")) {
			tempMovie.setDirector(tempVal);
		}else if (qName.equalsIgnoreCase("castnote")) {
			System.out.println("The castnote is: " + tempVal);
		}
		else if (qName.equalsIgnoreCase("f")) {
			tempMovie.setStringId(tempVal);
		}
		else if (qName.equalsIgnoreCase("t")) {
			System.out.println("-----The value of tempval: " + tempVal);
			tempMovie.setTitle(tempVal);
			String getVal = tempMovie.getTitle();
			System.out.println("-----The value of tempval after get title: " + tempVal);

			tempStar.addMovie(tempMovie);

		}
		else if (qName.equalsIgnoreCase("a")) {
			tempMovie.setTitle(tempVal);
		}
		else if (qName.equalsIgnoreCase("p")) {
			System.out.println("The type of role is: " + tempVal);
		}
		else if (qName.equalsIgnoreCase("r")) {
			System.out.println("The description of the role is: " + tempVal);
		}
		else if (qName.equalsIgnoreCase("n")) {
			System.out.println("The n is: " + tempVal);
		}
		else if (qName.equalsIgnoreCase("award")) {
			System.out.println("The award is: " + tempVal);
		}



	}

	public static void main(String[] args){
		SAXParserExample spe = new SAXParserExample();
		spe.runExample();
	}

}
