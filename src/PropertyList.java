// Imports
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

public class PropertyList {
    
    // Author: Ansley Solomon
    // Variables
    private final ArrayList<Property> properties = new ArrayList<>();
    private final ArrayList<Crosswalk> crosswalks = new ArrayList<>();
    private final ArrayList<Utility> utilities = new ArrayList<>();
    
    // Author: Ansley Solomon
    // Constructor
    public PropertyList(){
        readXML();
        //printAll();
    }
    
    // Author: Ansley Solomon
    // printAll()
    // For testing purposes
    public void printAll(){
        //System.out.print("Size: "+properties.size()+"\n");
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
    }
    
    // Author: Ansley Solomon
    // readXML()
    // Reads in the XML file; puts all the information into properties, crosswalks,
    // and utilities; adds all property types to array list
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
                        String buildingCost = eElement.getElementsByTagName("buildingCost").item(0).getTextContent();
                        String rent = eElement.getElementsByTagName("rent").item(0).getTextContent();
                        String monopolyRent = eElement.getElementsByTagName("monopolyRent").item(0).getTextContent();
                        String rentHouse1 = eElement.getElementsByTagName("rentHouse1").item(0).getTextContent();
                        String rentHouse2 = eElement.getElementsByTagName("rentHouse2").item(0).getTextContent();
                        String rentHouse3 = eElement.getElementsByTagName("rentHouse3").item(0).getTextContent();
                        String rentHouse4 = eElement.getElementsByTagName("rentHouse4").item(0).getTextContent();
                        String rentHotel = eElement.getElementsByTagName("rentHotel").item(0).getTextContent();

                        Property prop = new Property(name, location, color, price, mortgageValue, buildingCost, rent, 
                                monopolyRent, rentHouse1, rentHouse2, rentHouse3, rentHouse4, rentHotel);
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

                        Crosswalk prop = new Crosswalk(name, location, price, rent1, rent2, rent3, rent4);
                        crosswalks.add(prop);
                    }

                    else if (eElement.hasAttribute("category") && eElement.getAttribute("category").equals("utility")){
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                        String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        String mortgageValue = eElement.getElementsByTagName("mortgageValue").item(0).getTextContent();

                        Utility prop = new Utility(name, location, price, mortgageValue);
                        utilities.add(prop);
                    }
                }
             }
        }catch (ParserConfigurationException | SAXException | IOException | DOMException e){
            System.out.print(e);
        }
    }
    
    public ArrayList<Property> Get_Property()
    {
        //System.out.print("Get Properties XML!\n");
        return properties;
    }
    
    public ArrayList<Crosswalk> Get_CW()
    {
        //System.out.print("Get Crosswalks XML!\n");
        return crosswalks;
    }
    
        public ArrayList<Utility> Get_U()
    {
        //System.out.print("Get Utilities XML!\n");
        return utilities;
    }
}
