package monopolydriver;

/**
 * Decks class
 * 
 * This class contains the constructor for the Decks object. It includes methods
 * to read in the card information from Cards.xml and place in two separate decks 
 * (Chance and Charger Chest), print every card in a deck, shuffle the deck, and
 * draw/remove a card from the deck
 * 
 * @author Ansley Solomon
 */
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Decks {

    private final ArrayList<Card> chanceDeck = new ArrayList<>();
    private final ArrayList<Card> ccDeck = new ArrayList<>();
    
    /**
     * Default constructor for Decks object
     * Creates a shuffled Chance deck and a shuffled CC deck
     * @author Ansley Solomon
     */
    public Decks(){
        shuffle("chance");
        shuffle("cc");
    }
    
    /**
     * Prints information for every card in deck
     * For testing purposes
     * @author Ansley Solomon
     * @param type The deck that is being printed (Chance or CC)
     */
    public void PrintAll(String type){
        if ("chance".equals(type)){
            for (int i = 0; i < chanceDeck.size(); i++){
                System.out.println("ID: " + chanceDeck.get(i).getID());
                System.out.println("Type: " + chanceDeck.get(i).getCardType());
                System.out.println("Text: " + chanceDeck.get(i).getText());
                System.out.println("Event Type: " + chanceDeck.get(i).getEventType());
                System.out.println("Event Type: " + chanceDeck.get(i).getEventValue());
                System.out.println();
            }
        }
        else if ("cc".equals(type)){
            for (int i = 0; i < ccDeck.size(); i++){
                System.out.println("ID: " + ccDeck.get(i).getID());
                System.out.println("Type: " + ccDeck.get(i).getCardType());
                System.out.println("Text: " + ccDeck.get(i).getText());
                System.out.println("Event Type: " + ccDeck.get(i).getEventType());
                System.out.println("Event Type: " + ccDeck.get(i).getEventValue());
                System.out.println();
            }
        }
    }

    /**
     * Reads in the XML file, puts information into cards, puts cards into deck
     * @author Ansley Solomon
     * @param type Type of deck to create (Chance or CC)
     */
    private void readXML(String type){
        try{
            File fXmlFile = new File("cards.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("card");
            for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;

                    if ("chance".equals(type)){
                        if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("chance")){
                            String id = eElement.getElementsByTagName("id_number").item(0).getTextContent();
                            String text = eElement.getElementsByTagName("text").item(0).getTextContent();
                            String event_type = eElement.getElementsByTagName("event_type").item(0).getTextContent();
                            String event_value = eElement.getElementsByTagName("event_value").item(0).getTextContent();
                            
                            Card chanceCard = new Card(id, text, "Chance", event_type, event_value);
                            chanceDeck.add(chanceCard);  
                        }
                    }
                    if ("cc".equals(type)){
                        if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("chargerChest")){
                            String id = eElement.getElementsByTagName("id_number").item(0).getTextContent();
                            String text = eElement.getElementsByTagName("text").item(0).getTextContent();
                            String event_type = eElement.getElementsByTagName("event_type").item(0).getTextContent();
                            String event_value = eElement.getElementsByTagName("event_value").item(0).getTextContent();
                            
                            Card ccCard = new Card(id, text, "Charger Chest",event_type, event_value);
                            ccDeck.add(ccCard);
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e){

        }
    }

    /**
     * Clears the deck, creates a new deck, and randomizes the deck
     * @author Ansley Solomon
     * @param type Which deck to shuffle (Chance or CC)
     */
    public void shuffle(String type){
        if ("chance".equals(type)){
            chanceDeck.clear();
            readXML("chance");
            Collections.shuffle(chanceDeck);
        } 
        else if ("cc".equals(type)){
            ccDeck.clear();
            readXML("cc");
            Collections.shuffle(ccDeck);
        }
    }
    
    /**
     * Chooses first card in deck, displays it, and removes from deck
     * @author Ansley Solomon
     * @param type Which deck to draw from (Chance or CC)
     * @return Returns the first card in the chosen deck
     */
    public Card draw(String type){
        Card temp;
        // Should change print to displayCard function
        if ("chance".equals(type)){
            System.out.println(chanceDeck.get(0).getText());
            temp = chanceDeck.get(0);
            chanceDeck.remove(0);
            return temp;
        }
        else if ("cc".equals(type)){
            System.out.println(ccDeck.get(0).getText());
            temp = ccDeck.get(0);
            ccDeck.remove(0);
            return temp;
        }
        else{
            System.out.println("Error");
            return null;
        }
    }
}
