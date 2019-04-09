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
    // Variables
    private final ArrayList<Card> chanceDeck = new ArrayList<>();
    private final ArrayList<Card> ccDeck = new ArrayList<>();
    
    // Author: Ansley Solomon
    // Constructor
    public Decks(){
        shuffle("chance");
        shuffle("cc");
       // PrintAll("chance");
        //PrintAll("cc");
    }
    
    // Author: Ansley Solomon
    // For every card in deck, print ID number, card type, and text
    // For testing purposes
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

    
    // Author: Ansley Solomon
    // readXML()
    // Reads in the XML file, puts information into cards, puts cards in deck
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
    
    // Author: Ansley Solomon
    // shuffle()
    // Clears the deck, creates a new deck, and randomizes
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
    
    // Author: Ansley Solomon
    // draw()
    // Chooses first card in deck, displays it, and removes from deck
    public void draw(String type){
        
        // Should change print to displayCard function
        if ("chance".equals(type)){
            System.out.println(chanceDeck.get(0).getText());
            chanceDeck.remove(0);
        }
        else if ("cc".equals(type)){
            System.out.println(ccDeck.get(0).getText());
            ccDeck.remove(0);
        }
        else{
            System.out.println("Error");
        }
        
    }
        
}
