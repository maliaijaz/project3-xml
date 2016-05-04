
// insert stars sequentially

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

public class StarSAXParser extends DefaultHandler{

	List stars;

	List finalListOfStars;

	private String tempVal;

	List temporaryArray;

	//to maintain context
	private Star tempStar;


	public StarSAXParser(){
		stars = new ArrayList();
		finalListOfStars = new ArrayList();
		temporaryArray = new ArrayList();
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
			sp.parse("cast.xml", this);

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

		System.out.println("Number of Stars '" + stars.size() + "'.");

		// Iterator it = stars.iterator();
		// while(it.hasNext()) {
		// 	System.out.println(it.next().toString());
		// }
	}


	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("m")) {
			//create a new instance of employee
			tempStar = new Star();
		}
	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("m")) {
			//add it to the list
			stars.add(tempStar);
		}else if (qName.equalsIgnoreCase("f")) {
			tempStar.setStarId(tempVal);
			temporaryArray.add(tempVal); // adds the film ID
		}else if (qName.equalsIgnoreCase("t")) {
			tempStar.addMovieTitle(tempVal);
			temporaryArray.add(tempVal); // adds movie title
		}else if (qName.equalsIgnoreCase("a")) {
			tempStar.setStarFullName(tempVal); // adds star's full name
			temporaryArray.add(tempVal);
			// String[] nameArray = tempVal.split("\\s+");
			// tempStar.setFirstName = nameArray[0];
			// tempStar.setLastName = nameArray[1];
		}
		finalListOfStars.add(tempStar);
	}

	public static void main(String[] args){
		System.out.println("\nStarting SAX Parser\n");
		StarSAXParser spe = new StarSAXParser();
		spe.runExample();
		System.out.println("Here's teh temporary array: " + spe.temporaryArray);
	}

}
