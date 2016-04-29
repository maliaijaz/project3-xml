

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
	// List stars;

	private String tempVal;

	//to maintain context
	private Movie tempMovie;
	// private Star tempStar;


	public SAXParserExample(){
		movies = new ArrayList();
		// stars = new ArrayList();
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

		Iterator it = movies.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
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
	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("dirfilms")) {
			//add it to the list
			movies.add(tempMovie);
		}else if (qName.equalsIgnoreCase("dirid")) {
			System.out.println("The director ID is: " + tempVal);
		}else if (qName.equalsIgnoreCase("is")) {
			tempMovie.setDirector(tempVal);
		}else if (qName.equalsIgnoreCase("castnote")) {
			System.out.println("The castnote is: " + tempVal);
		}

	}

	public static void main(String[] args){
		SAXParserExample spe = new SAXParserExample();
		spe.runExample();
	}

}
