package monopolydriver;

/**
 * Main class for the PropertyList object
 * @author Ansley Solomon, Sean Mitchell
 */

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PropertyList{
    
    // Variables
    private final ArrayList<Property_Tile> properties = new ArrayList<>();
    private final ArrayList<Crosswalk_Tile> crosswalks = new ArrayList<>();
    private final ArrayList<Utility_Tile> utilities = new ArrayList<>();
    private final ArrayList<Card_Tile> charger_chest = new ArrayList<>();
    private final ArrayList<Card_Tile> chance = new ArrayList<>();
    private final ArrayList<Corner_Tile> corner_tiles = new ArrayList<>();
    private final ArrayList<Other_Tile> other_tiles = new ArrayList<>();
    
    /**
     * Default constructor
     * @author Ansley Solomon
     */
    public PropertyList(){
        readXML();
        //printAll();
    }
    
    /**
     * Prints the entire list of Properties, Crosswalks, and Utilities
     * For testing purposes
     * @author Ansley Solomon
     */
    public void printAll()
    {
        for (int  i = 0; i < properties.size(); i++){
            System.out.println("Name: " + properties.get(i).getName());
            System.out.println("Location: "  + properties.get(i).getLocation());
            System.out.println("Price: " + properties.get(i).getPrice());
            System.out.println();
        }  
        for (int i = 0; i < crosswalks.size(); i++){
            System.out.println("Name: " + crosswalks.get(i).getName());
            System.out.println("Location: "  + crosswalks.get(i).getLocation());
            System.out.println("Price: " + crosswalks.get(i).getPrice());
            System.out.println();
        }
        for (int i = 0; i < utilities.size(); i++){
            System.out.println("Name: " + utilities.get(i).getName());
            System.out.println("Location: "  + crosswalks.get(i).getLocation());
            System.out.println("Price: " + utilities.get(i).getPrice());
            System.out.println();
        }
        for (int i = 0; i < charger_chest.size(); i++)
        {
            System.out.println("Name: " + charger_chest.get(i).getName());
            System.out.println("Location: "  + charger_chest.get(i).getLocation());
            System.out.println();
        }
        for (int i = 0; i < chance.size(); i++)
        {
            System.out.println("Name: " + chance.get(i).getName());
            System.out.println("Location: "  + chance.get(i).getLocation());
            System.out.println();
        }
        for (int i = 0; i < corner_tiles.size(); i++)
        {
            System.out.println("Name: " + corner_tiles.get(i).getName());
            System.out.println("Location: "  + corner_tiles.get(i).getLocation());
            System.out.println();
        }
        for (int i = 0; i < other_tiles.size(); i++)
        {
            System.out.println("Name: " + other_tiles.get(i).getName());
            System.out.println("Location: "  + other_tiles.get(i).getLocation());
		System.out.println("Cost: "  + other_tiles.get(i).getCost());
            System.out.println();
        }
    }
    
    /**
     * Reads in the XML file 
     * Puts all the information into properties, crosswalks, and utilities 
     * Adds all property types to array lists
     * @author Ansley Solomon
     */
    private void readXML(){
        try{
            File fXmlFile = new File("properties.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("property");
             for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("property")){
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        String color = eElement.getElementsByTagName("color").item(0).getTextContent();
                        String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        String mortgageValue = eElement.getElementsByTagName("mortgageValue").item(0).getTextContent();
                        String rent = eElement.getElementsByTagName("rent").item(0).getTextContent();
                        String monopolyRent = eElement.getElementsByTagName("monopolyRent").item(0).getTextContent();
                        
                        Property_Tile prop = new Property_Tile(name, location, color, price, mortgageValue, rent, monopolyRent);
                        properties.add(prop); 
                    }
                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("crosswalk")){
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        String rent1 = eElement.getElementsByTagName("rent1").item(0).getTextContent();
                        String rent2 = eElement.getElementsByTagName("rent2").item(0).getTextContent();
                        String rent3 = eElement.getElementsByTagName("rent3").item(0).getTextContent();
                        String rent4 = eElement.getElementsByTagName("rent4").item(0).getTextContent();
                        Crosswalk_Tile prop = new Crosswalk_Tile(name, location, price, rent1, rent2, rent3, rent4);
                        crosswalks.add(prop);
                    }
                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("utility")){
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        String mortgageValue = eElement.getElementsByTagName("mortgageValue").item(0).getTextContent();
                        Utility_Tile prop = new Utility_Tile(name, location, price, mortgageValue);
                        utilities.add(prop);
                    }
                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("charger_chest"))
                    {
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        Card_Tile prop = new Card_Tile(name, location);
                        charger_chest.add(prop);
                    }
                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("chance"))
                    {
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        Card_Tile prop = new Card_Tile(name, location);
                        chance.add(prop);
                    }
                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("corner"))
                    {
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        Corner_Tile prop = new Corner_Tile(name, location);
                        corner_tiles.add(prop);
                    }
            		else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("other"))
                    {
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
			String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        Other_Tile prop = new Other_Tile(name, location, price);
                        other_tiles.add(prop);
                    }
                }
             }
        }catch (ParserConfigurationException | SAXException | IOException | DOMException e){
            System.out.print(e);
        }
    }
    
    /**
     * Returns the ArrayList of Properties
     * @author Sean Mitchell
     * @return ArrayList properties
     */
    public ArrayList<Property_Tile> Get_Property()
    {
        //System.out.print("Get Properties XML!\n");
        return properties;
    }
    
    /**
     * Returns the ArrayList of Crosswalks
     * @author Sean Mitchell
     * @return ArrayList crosswalks
     */
    public ArrayList<Crosswalk_Tile> Get_CW()
    {
        //System.out.print("Get Crosswalks XML!\n");
        return crosswalks;
    }
    
    /**
     * Returns the ArrayList of Utilities
     * author Sean Mitchell
     * @return ArrayList utilities
     */
    public ArrayList<Utility_Tile> Get_U()
    {
        //System.out.print("Get Utilities XML!\n");
        return utilities;
    }
    
    /**
     * Returns the ArrayList of Utilities
     * author Sean Mitchell
     * @return ArrayList utilities
     */
    public ArrayList<Card_Tile> Get_CC()
    {
        //System.out.print("Get Utilities XML!\n");
        return charger_chest;
    }
    
    /**
     * Returns the ArrayList of Utilities
     * author Sean Mitchell
     * @return ArrayList utilities
     */
    public ArrayList<Card_Tile> Get_C()
    {
        //System.out.print("Get Utilities XML!\n");
        return chance;
    }
    
    /**
     * Returns the ArrayList of Utilities
     * author Sean Mitchell
     * @return ArrayList utilities
     */
    public ArrayList<Corner_Tile> Get_CT()
    {
        //System.out.print("Get Utilities XML!\n");
        return corner_tiles;
    }

    public ArrayList<Other_Tile> Get_OT()
    {
        //System.out.print("Get Utilities XML!\n");
        return other_tiles;
    }


}