import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MeganHaskins
 */
public class View1 extends Mdriver{
    Board gameBoard;
    int turnCounter;
    int maxPlayers;
    int rotations;
    int maxRotations;
    
    //needed trade variables
    int tradeP1;
    int tradeP2;
    int selectionCount;
    int trade1index;
    int trade2index;
    
 public void View1(){  turnCounter = 0; rotations = 0; maxRotations = 0; }
    
  public void welcomeMenu(){
        Button btnStart = new Button();
        Button btnInstructions = new Button();
        Button btnExit = new Button();
        btnInstructions.setText("Instructions");
        btnStart.setText("Start Game");
        btnExit.setText("Exit Game");
        
        //Exit Event
         btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Exit Program");
            }
        });
         
         //Instruction Event
        btnInstructions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
              public void handle(ActionEvent event) { 
                  instructionEvent();
            }         
        });
        
        //Start Event
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setupMenu();
            }
        });   
        
        FlowPane root = new FlowPane();
        root.getChildren().add(btnStart);
        root.getChildren().add(btnInstructions);
        root.getChildren().add(btnExit);
        
        Scene Startscene = new Scene(root, 400, 350);
        Stage welcomeMenu = new Stage();
        welcomeMenu.setTitle("UAH Monopoly Start Menu");
        welcomeMenu.setScene(Startscene);
        welcomeMenu.show();
    }
  
  public void instructionEvent(){
       System.out.println("Give Instructions");
       Font font = new Font("Courier", Font.BOLD,13);

       JPanel panel = new JPanel();
       panel.setLayout(new FlowLayout());
       panel.setPreferredSize(new Dimension(1000,1000));
       String Lspace = "                                                                                                                                                                                           ";
       String LLspace = "                           ";
       JLabel instruct1 = new JLabel("Monopoly Instructions" + LLspace); 
       instruct1.setFont(font);
       JLabel instruct2 = new JLabel("Object" + Lspace);
       instruct2.setFont(font);
       JLabel instruct3 = new JLabel("The object of Monopoly is to become the wealthiest player by buying, selling, trading, and collecting");
       JLabel instruct4 = new JLabel("rent on properties. In this version, a number of rounds is set at the beginning of the game, and the");
       JLabel instruct5 = new JLabel("player who is the richest after the set number of rounds is declared the winner.");
       JLabel instruct6 = new JLabel("Start" + Lspace);
       instruct6.setFont(font);
       JLabel instruct7 = new JLabel("To start the game, each player enters their name and is assigned a token. Each player starts out");
       JLabel instruct8 = new JLabel("with $1,500. Each player token starts on the “Go” tile.        ");
       JLabel instruct9 = new JLabel("Turns" + Lspace);
       instruct9.setFont(font);
       JLabel instruct10 = new JLabel("On your turn, click the “Roll Dice” button. Your token will automatically move the correct number of spaces (1-12). ");
       JLabel instruct11= new JLabel("-If you land on an unowned property, crosswalk, or utility, you have the option to buy it.");
       JLabel instruct12= new JLabel("-If you land on a property, a crosswalk, or utility that is already owned, you must pay rent to its owner.");
       JLabel instruct13 = new JLabel("-If you land on a “Chance” or “Charger Chest” tile, a card will be drawn which gives an event (gain or lose money, or move on the board).");
       JLabel instruct14 = new JLabel("-If you land on “Free Parking”, you don’t have to pay rent or draw a card.");
       JLabel instruct15 = new JLabel("-If you land on “Jail”, nothing happens. You are just passing through.");
       JLabel instruct16 = new JLabel("-If you land on “Go to Jail”, your player is now incarcerated (see Jail section of instructions)             .");
       JLabel instruct17 = new JLabel("Buying, Selling, and Trading Properties" + Lspace);
       instruct17.setFont(font);
       JLabel instruct18 = new JLabel("There are two ways to buy a property, crosswalk, or utility: (1) land on the tile, or (2) buy or trade it from another player.");
       JLabel instruct19 = new JLabel("If you own all the tiles of one color, this is a monopoly. Rent is more expensive on properties where the owner has a monopoly");
       JLabel instruct20 = new JLabel("On your turn, you have the option of selling or trading properties. The other player must agree to your");
       JLabel instruct21 = new JLabel("proposed sale or trade. If they do not, the sale or trade doesn’t happen.");
       JLabel instruct22 = new JLabel("Mortgaging Properties" + Lspace);
       instruct22.setFont(font);
       JLabel instruct23 = new JLabel("Players have the option to mortgage their properties on their turn. If you mortgage a property, you receive a certain amount of money.");
       JLabel instruct24 = new JLabel("Rent is not collected when a morgaged property is landed on.");
       JLabel instruct25 = new JLabel("Jail" + Lspace + "           ");
       instruct25.setFont(font);
       JLabel instruct26 = new JLabel("If you find yourself incarcerated, there are two ways to get out of jail: (1) Use a “Get Out of Jail Free");
       JLabel instruct27 = new JLabel("or (2) Pay $50. Else you must pay the $50 on your third turn in jail.");
       JLabel instruct28 = new JLabel("Winning and Losing" + LLspace + "                                                                                                                                                                ");
       instruct28.setFont(font);
       JLabel instruct29 = new JLabel("If a player ends a turn with a negative account balance they are eliminated from the game. ");
       JLabel instruct30 = new JLabel("The game ends when only one player remains or when the aloted amount of turns has ended.");
       JLabel instruct31 = new JLabel("The last player standing or the player with the most assets (money and properties) at the end of the rounds wins the game. ");
       JLabel instruct32 = new JLabel();
       panel.add(instruct1); panel.add(instruct2); panel.add(instruct3); panel.add(instruct4); panel.add(instruct5); panel.add(instruct6);
       panel.add(instruct7); panel.add(instruct8); panel.add(instruct9); panel.add(instruct10); panel.add(instruct11); panel.add(instruct12);
       panel.add(instruct13); panel.add(instruct14); panel.add(instruct15); panel.add(instruct16); panel.add(instruct17); panel.add(instruct18);
       panel.add(instruct19); panel.add(instruct20); panel.add(instruct21); panel.add(instruct22); panel.add(instruct23); panel.add(instruct24);
       panel.add(instruct25); panel.add(instruct26); panel.add(instruct27); panel.add(instruct28); panel.add(instruct29); panel.add(instruct30);
       panel.add(instruct31); panel.add(instruct32); 
       JFrame frame = new JFrame("Instructions");
       frame.getContentPane().add(panel);
       frame.pack();
       frame.setVisible(true);
    }
    
    //Will be edited to display current player locations
    public void viewBoard(Player currentP){
        if(currentP.Get_Playable() == true){
            rotations++;
       if(rotations > maxRotations){
           Completed_Window();
       }
       else{
           JFrame frame = new JFrame();
       JPanel basePanel = new JPanel();
       JLayeredPane lpane = new JLayeredPane();
       JPanel boardPanel = new JPanel();
       JPanel controlPanel = new JPanel();
       controlPanel.setLayout(new FlowLayout());
       JButton btnRollDice = new JButton("Roll Dice");
       JButton btnManageProperty = new JButton("Manage Property");
       Button btnViewBoard = new Button("View Board");
       Button btnEndTurn = new Button("End Turn");
       Button btnForfeit = new Button("Forfiet");
       JTextField turnInfo = new JTextField("I will place info here");
       controlPanel.add(btnRollDice);
       controlPanel.add(btnRollDice);
 
       boardPanel.setPreferredSize(new Dimension(1000,800));
       //
        //get board image
       //
        File imageFile = new File("Board.JPG");
        BufferedImage boardImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
           try{
           boardImage = ImageIO.read(imageFile);
             } 
          catch(IOException e){
             System.out.println("Error: " + e);
             }
        JLabel photoLabel = new JLabel(new ImageIcon(boardImage));
        boardPanel.add(photoLabel);
        JPanel tokinPanel1 = new JPanel();
        JPanel tokinPanel2 = new JPanel();
        JPanel tokinPanel3 = new JPanel();
        JPanel tokinPanel4 = new JPanel();

        basePanel.setPreferredSize(new Dimension(1500, 1000));
        basePanel.setLayout(new BorderLayout());
        basePanel.add(lpane, BorderLayout.CENTER);
        basePanel.add(controlPanel, BorderLayout.SOUTH);
        lpane.setBounds(0, 0, 900, 900);
        boardPanel.setBackground(Color.BLUE);
        boardPanel.setBounds(0, 0, 900, 900);
        boardPanel.setOpaque(true);
        tokinPanel1.setBackground(Color.GREEN);
        tokinPanel2.setBackground(Color.BLUE);
        tokinPanel3.setBackground(Color.BLACK);
        tokinPanel4.setBackground(Color.YELLOW);
        
        //needs to be editable
        tokinPanel1.setBounds(gameBoard.get_Player(0).Get_XCordinate(), gameBoard.get_Player(0).Get_YCordinate(), 30, 30);
        tokinPanel2.setBounds(gameBoard.get_Player(1).Get_XCordinate(), gameBoard.get_Player(1).Get_YCordinate(), 30, 30);
        if(maxPlayers >= 3){
             tokinPanel3.setBounds(gameBoard.get_Player(2).Get_XCordinate(), gameBoard.get_Player(2).Get_YCordinate(), 30, 30);
             lpane.add(tokinPanel3, new Integer(1), 0);
             tokinPanel3.setOpaque(true);
        }
         if(maxPlayers >= 4){
             tokinPanel4.setBounds(gameBoard.get_Player(3).Get_XCordinate(), gameBoard.get_Player(3).Get_YCordinate(), 30, 30);
             lpane.add(tokinPanel4, new Integer(1), 0);
             tokinPanel4.setOpaque(true);
         }
        
        tokinPanel1.setOpaque(true); tokinPanel2.setOpaque(true); 
        lpane.add(boardPanel, new Integer(0), 0);
        lpane.add(tokinPanel2, new Integer(1), 0);
        lpane.add(tokinPanel1, new Integer(1), 0);
       
        //needs to be updateable
        JPanel panelplease = playerInformation();
        panelplease.setPreferredSize(new Dimension(500, 950));
        
 //Control Menu Buttons
        JPanel controlP = new JPanel();
        JButton btnManageProp = new JButton("Manage Property");
        JButton btnRollDice1 = new JButton("Roll Dice");
        JTextField TFresults = new JTextField(currentP.Get_Name()+" Start Turn");
        btnRollDice1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             currentP.PlayerRoll();
            } 
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
             int rolled = currentP.PlayerRoll();
             TFresults.setText("The player rolled a: " + rolled);
             frame.dispose();
             afterRollBoard(currentP, "The player rolled a: " + rolled);    
           }
        } );
        
        btnManageProp.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             
            } 
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
             managePropertyMenu(currentP);              
           }
        } );
        controlP.add(btnManageProp);
        controlP.add(btnRollDice1);
        controlP.add(TFresults);
        
        panelplease.add(controlP);
        basePanel.add(panelplease, BorderLayout.EAST);
        frame.add(basePanel);
        frame.pack();
        frame.setVisible(true);
        }
      }
       else{
             turnCounter++;
             if(turnCounter == maxPlayers){
                 turnCounter = 0;
             }
             currentP.Update_Playability();
             playerTurns(0, currentP);    
               }
  
    }

     public void afterRollBoard(Player currentP, String rollResult){
        JFrame frame = new JFrame();
        JPanel basePanel = new JPanel();
       JLayeredPane lpane = new JLayeredPane();
       JPanel boardPanel = new JPanel();
       
       JPanel controlPanel = new JPanel();
       controlPanel.setLayout(new FlowLayout());
        JButton btnManageProperty = new JButton("Manage Property");
        JButton btnEndTurn = new JButton("End Turn");
        JButton btnForfeit = new JButton("Forfiet");
        
        //////////////////////////////////////////////////////////////////////////////END TURN
         btnEndTurn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            } 
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
             frame.dispose();
             turnCounter++;
             if(turnCounter == maxPlayers){
                 turnCounter = 0;
             }
             currentP.Update_Playability();
             if(currentP.Get_Playable() == false){
                 playerTurns(1, currentP); 
             }
             else{
                playerTurns(0, currentP); 
             }
                         
           }
        } );
        
       boardPanel.setPreferredSize(new Dimension(1000,800));
        //get board image
       //
        File imageFile = new File("Board.JPG");
        BufferedImage boardImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
           try{
           boardImage = ImageIO.read(imageFile);
             } 
          catch(IOException e){
             System.out.println("Error: " + e);
             }
       JLabel photoLabel = new JLabel(new ImageIcon(boardImage));
       boardPanel.add(photoLabel);
       
        JPanel tokinPanel1 = new JPanel();
        JPanel tokinPanel2 = new JPanel();
        JPanel tokinPanel3 = new JPanel();
        JPanel tokinPanel4 = new JPanel();
        
        //Get tokin Image
        basePanel.setPreferredSize(new Dimension(1500, 1000));
        basePanel.setLayout(new BorderLayout());
        basePanel.add(lpane, BorderLayout.CENTER);
        basePanel.add(controlPanel, BorderLayout.SOUTH);
        lpane.setBounds(0, 0, 900, 900);
        boardPanel.setBackground(Color.BLUE);
        boardPanel.setBounds(0, 0, 900, 900);
        boardPanel.setOpaque(true);
        tokinPanel1.setBackground(Color.GREEN);
        tokinPanel2.setBackground(Color.BLUE);
        tokinPanel3.setBackground(Color.BLACK);
        tokinPanel4.setBackground(Color.YELLOW);
        
        //needs to be editable
        tokinPanel1.setBounds(gameBoard.get_Player(0).Get_XCordinate(), gameBoard.get_Player(0).Get_YCordinate(), 30, 30);
        tokinPanel2.setBounds(gameBoard.get_Player(1).Get_XCordinate(), gameBoard.get_Player(1).Get_YCordinate(), 30, 30);
        tokinPanel3.setBounds(gameBoard.get_Player(2).Get_XCordinate(), gameBoard.get_Player(2).Get_YCordinate(), 30, 30);
        tokinPanel4.setBounds(gameBoard.get_Player(3).Get_XCordinate(), gameBoard.get_Player(3).Get_YCordinate(), 30, 30);
        tokinPanel1.setOpaque(true); tokinPanel2.setOpaque(true); tokinPanel3.setOpaque(true); tokinPanel4.setOpaque(true);
        lpane.add(boardPanel, new Integer(0), 0);
        lpane.add(tokinPanel4, new Integer(1), 0);
        lpane.add(tokinPanel3, new Integer(1), 0);
        lpane.add(tokinPanel2, new Integer(1), 0);
        lpane.add(tokinPanel1, new Integer(1), 0);
       
        //needs to be updateable
        JPanel panelplease = playerInformation();
        panelplease.setPreferredSize(new Dimension(500, 950));
        
 //Control Menu Buttons
        JPanel controlP = new JPanel();
        JButton btnManageProp = new JButton("Manage Property");
        JTextField TFresults = new JTextField(rollResult);
        btnManageProp.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             
            } 
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
             managePropertyMenu(currentP);   
             frame.dispose();
           }
        } );      
        controlP.add(btnManageProp);
        controlP.add(btnEndTurn);
        controlP.add(TFresults);
        
        panelplease.add(controlP);
        //basePanel.add(playerInformation(), BorderLayout.EAST);
        basePanel.add(panelplease, BorderLayout.EAST);
        //ADD CONTROL PANEL HERE
       // basePanel.add(controlMenu(), BorderLayout.SOUTH);
        
        frame.add(basePanel);
        frame.pack();
        frame.setVisible(true);        
    }
    
     
     //CONVERT TO JPANEL
    public void setupMenu(){     
        Text space1 = new Text("                  ");
        Text space2 = new Text("                  ");
        Text space3 = new Text("                 ");
        Text space4 = new Text("                                                 ");
        Text space5 = new Text("                                               ");
        
        Text text1 = new Text("Lets set up the game. \n Please give player names and choose turn length for the game. \n Turn Amount: ");
        TextField numberResponse = new TextField();
        Text txtP1 = new Text("Player One Name:  ");
        Text txtP2 = new Text("Player Two Name:  ");
        Text txtP3 = new Text("Player Three Name:  ");
        Text txtP4 = new Text("Player Four Name:  ");
        TextField TFplayer1 = new TextField();
        TextField TFplayer2 = new TextField();
        TextField TFplayer3 = new TextField();
        TextField TFplayer4 = new TextField();
        Text text2 = new Text("\n Next, select tokins: Fadora, Laptop, Rocket, Horse, Beaker, Glasses          \n");
        Text text15 = new Text("                                                            \n");
        
        Button btnfinish = new Button("Finish");
        
         btnfinish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
               maxRotations = Integer.parseInt(numberResponse.getText());
               System.out.println(""+rotations);
               maxPlayers = 4;
              
                 gameBoard = new Board(TFplayer1.getText(), TFplayer2.getText(), TFplayer3.getText(), TFplayer4.getText());
                 viewBoard(gameBoard.get_Player(0));
                      
            }
        });
        
         //Adding Children to Root
        FlowPane root = new FlowPane(); root.getChildren().add(text1);  root.getChildren().add(numberResponse);
        root.getChildren().add(text15); root.getChildren().add(text2); root.getChildren().add(txtP1);
        root.getChildren().add(TFplayer1); root.getChildren().add(space1); root.getChildren().add(txtP2);
        root.getChildren().add(TFplayer2); root.getChildren().add(space2); root.getChildren().add(txtP3);
        root.getChildren().add(TFplayer3); root.getChildren().add(space3); root.getChildren().add(txtP4);
        root.getChildren().add(TFplayer4); root.getChildren().add(space4); 
        root.getChildren().add(space5); root.getChildren().add(btnfinish);

        Scene setupScene = new Scene(root, 400, 350);

        Stage setupMenu = new Stage();
        setupMenu.setTitle("Setup Menu");
        setupMenu.setScene(setupScene);
        setupMenu.show();      
    }
    
    public JPanel playerInformation(){
        JFrame frame = new JFrame();
        JPanel allPanel = new JPanel();
        allPanel.setPreferredSize(new Dimension(350,1200));
        
        for(int i =0; i < maxPlayers; i++){
          allPanel.add(PlayerPanel(gameBoard.get_Player(i)));  
        }
        return allPanel;
    }

      public JPanel PlayerPanel(Player player){

        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(300,150));
        //Player One Image Panel
        JPanel ImagePanel = new JPanel();
        ImagePanel.setPreferredSize(new Dimension(100,100));
        JLabel photoLabel3 = new JLabel(player.Get_Image());
        ImagePanel.add(photoLabel3);
        
        //Player One Data Panel
        JPanel DataPanel = new JPanel();
        DataPanel.setPreferredSize(new Dimension(150,150));
        JLabel playerThreeName = new JLabel(player.Get_Name());
        JTextField account3 = new JTextField( "" +player.Get_Money());
        String[] properties = new String[40]; //player.Get_Property_Amount()  
        for(int i =0; i < player.Get_Property_Amount(); i++ ){
            properties[i] = player.Get_Property_Name(i);
        }
        
        JComboBox playerThreeProp = new JComboBox(properties);  //COMBO BOX
        String prop = "property";
        
        
        DataPanel.add(playerThreeName);
        DataPanel.add(account3);
        DataPanel.add(playerThreeProp);
        
        //Layering Panels
        playerPanel.add(ImagePanel);
        playerPanel.add(DataPanel);
        
        return playerPanel;
    }
      
       public void managePropertyMenu(Player currentP){
       JFrame frame = new JFrame("Manage Property");
       JPanel basePanel = new JPanel();
       JButton btnBuyP = new JButton("Buy Property");
       JButton btnMorgageP = new JButton("Morgage Property");
       JButton btnTradeP = new JButton("Trade Property");
       basePanel.setLayout(new FlowLayout());
       
        btnBuyP.addActionListener(new ActionListener() { 
                     public void actionPerformed(ActionEvent e) { 
                         
                      } 
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                           Purchase_Menu(currentP);
                           frame.dispose();
                        }
                     } );
        btnTradeP.addActionListener(new ActionListener() { 
                     public void actionPerformed(ActionEvent e) { 
                         
                      } 
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                           afterRollBoard(currentP, "");
                           Trade_Menu(currentP);
                           frame.dispose();
                        }
                     } );
        
         btnMorgageP.addActionListener(new ActionListener() { 
                     public void actionPerformed(ActionEvent e) { 
                         
                      } 
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                           afterRollBoard(currentP, "");
                           Morgage_Menu(currentP);
                           frame.dispose();
                        }
                     } );
        if(currentP.Get_Location()%5 != 0 || currentP.Get_Location() !=2 || currentP.Get_Location() !=7 ){
           basePanel.add(btnBuyP);
       }
       basePanel.add(btnMorgageP); basePanel.add(btnTradeP);
       
       frame.add(basePanel);
       frame.pack();
       frame.setVisible(true); 
       }
       
       public void playerTurns(int window, Player currentP){
           if(window != 0){
               viewBoard(gameBoard.get_Player(turnCounter)); 
               Player_Elimination(currentP);
           }
           else{
             viewBoard(gameBoard.get_Player(turnCounter));  
           }  
       }
       
       public void Error_Window(String message){
       JFrame frame = new JFrame("ERROR");
       frame.setSize(300, 300);
       JPanel basePanel = new JPanel();
       JLabel errorTxt = new JLabel(message);
       basePanel.setLayout(new FlowLayout());
       basePanel.add(errorTxt);
       
       frame.add(basePanel);
       frame.pack();
       frame.setVisible(true); 
       }
       
       public void Purchase_Menu(Player currentP){
           JFrame frame = new JFrame("Purchase Menu");
           JPanel basePanel = new JPanel();
           basePanel.setLayout(new FlowLayout());
            JLabel buyable = new JLabel();
            buyable.setText("This Property is able to be purchased"); 
            JLabel propName = new JLabel();            
            propName.setText("Property Name: " + gameBoard.Get_Board(currentP.Get_Location()).getName());
           JLabel propPrice = new JLabel();
           propPrice.setText("Property Price: " + gameBoard.Get_Board(currentP.Get_Location()).getPrice());
            
            if(currentP.Get_Location() == 0 || currentP.Get_Location() == 2 || currentP.Get_Location() == 4 || currentP.Get_Location() == 7 ){
                JLabel invalid = new JLabel("invalid purchase");
                basePanel.add(invalid);
                afterRollBoard(currentP, "");
                frame.setSize(300, 300);
                frame.add(basePanel);
                frame.pack();
                frame.setVisible(true);  
            }
            else{
               JButton btnPurchase = new JButton("Purchase");
            JButton btnCancel = new JButton("Cancel");
            
                btnPurchase.addActionListener(new ActionListener() { 
                 public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                 currentP.Buy_Property(gameBoard.Get_Board(currentP.Get_Location()));   
                 frame.dispose();
                 afterRollBoard(currentP, "  ");
                    }
                } );

       frame.setSize(300, 300);
       basePanel.add(btnPurchase);
       frame.add(basePanel);
       frame.pack();
       frame.setVisible(true);   
                
            }   
       }
       
    public void Trade_Menu(Player currentP){
            JFrame frame = new JFrame("Trade Menu");
            frame.setSize(150,150);
            JPanel basePanel = new JPanel();
            basePanel.setLayout(new FlowLayout());
            JLabel buyable = new JLabel();
            buyable.setText("This Property is able to be purchased"); 
            JButton btnTrade = new JButton("Trade");
            JButton btnCancel = new JButton("Cancel");
            JLabel Linstructions = new JLabel("Please Select the Properties that you would like to trade:      ");
            JLabel Lspace2 = new JLabel("    ");
            JLabel Lprop1 = new JLabel("  " + gameBoard.get_Player(0).Get_Name()+"   ");
            JLabel Lprop2 = new JLabel("" + gameBoard.get_Player(1).Get_Name() + "   ");
            JLabel Lprop3 = new JLabel("" + gameBoard.get_Player(2).Get_Name() +"   ");
            JLabel Lprop4 = new JLabel("" + gameBoard.get_Player(3).Get_Name() + "   ");
            String[] P1properties = new String[41]; //player.Get_Property_Amount() 
            P1properties[0] = "no trade";
            for(int i =1; i < gameBoard.get_Player(0).Get_Property_Amount()+1; i++ ){
            P1properties[i] = gameBoard.get_Player(0).Get_Property_Name(i-1);
                   }
            JComboBox player1Properties = new JComboBox(P1properties); 
            
            String[] P2properties = new String[41]; 
            P2properties[0] = "no trade";
            for(int i =1; i < gameBoard.get_Player(1).Get_Property_Amount()+1; i++ ){
            P2properties[i] = gameBoard.get_Player(1).Get_Property_Name(i-1);
                   }
            JComboBox player2Properties = new JComboBox(P2properties);  
            
            String[] P3properties = new String[41];  
            P3properties[0] = "no trade";
            for(int i =1; i < gameBoard.get_Player(2).Get_Property_Amount()+1; i++ ){
            P3properties[i] = gameBoard.get_Player(2).Get_Property_Name(i-1);
                   }
            JComboBox player3Properties = new JComboBox(P3properties);  
            
            String[] P4properties = new String[41];
            P4properties[0] = "no trade";
            for(int i =1; i < gameBoard.get_Player(3).Get_Property_Amount()+1; i++ ){
            P4properties[i] = gameBoard.get_Player(3).Get_Property_Name(i-1);
                   }
            JComboBox player4Properties = new JComboBox(P4properties);  
             
            btnTrade.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                 frame.dispose();   
                 tradeP1 = 0;
                tradeP2 = 0;
                selectionCount = 0;
                trade1index = 7;
                trade2index=7;
                if(player1Properties.getSelectedIndex() != 0){
                    trade1index = player1Properties.getSelectedIndex();
                    tradeP1 = 1;
                    selectionCount++;
                 }
                if(player2Properties.getSelectedIndex() != 0){
                  if(tradeP1 != 0){
                        tradeP2 = 2;
                        trade2index = player2Properties.getSelectedIndex();
                    }
                    else{
                        tradeP1 = 2;
                        trade1index = player2Properties.getSelectedIndex();
                    }
                    selectionCount++;  
                } 
                if(player3Properties.getSelectedIndex() != 0){ 
                 if(tradeP1 != 0){
                        tradeP2 = 3;
                        trade2index = player3Properties.getSelectedIndex();
                    }
                    else{
                        tradeP1 = 3;
                        trade1index = player3Properties.getSelectedIndex();
                    }
                    selectionCount++;   
                }
  
                if(player4Properties.getSelectedIndex() != 0){
                 if(tradeP1 != 0){
                        tradeP2 = 4;
                        trade2index = player4Properties.getSelectedIndex();
                    }
                    else{
                        tradeP1 = 4;
                        trade1index = player4Properties.getSelectedIndex();
                    }
                     selectionCount++;       
                }
                trade1index = player1Properties.getSelectedIndex();
                trade2index = player2Properties.getSelectedIndex();
                System.out.println("trade1index: " + trade1index + "  2:  " + trade2index + "selection count " + selectionCount + "  P1: " + tradeP1 + "  P2: " + tradeP2);
                if(selectionCount != 2){
                tradeP1 = 0;
                tradeP2 = 0;
                selectionCount = 2;
                trade1index = 72;
                trade2index=72;   
                }
                  
                 if(tradeP1 + tradeP2 == 0){
                     System.out.println("trade indexes and such: P1 - " + tradeP1 + "P2 - " + tradeP2 + "trade1index: " + trade1index + "trade2index: " + trade2index );
                     Error_Window("Trade could not be completed");
                 }
                 else{
                    System.out.println("TRADE WORKED \n trade indexes and such: P1 - " + tradeP1 + "P2 - " + tradeP2 + "trade1index: " + trade1index + "trade2index: " + trade2index ); //int trade indexes
                 Confirm_Trade(currentP, gameBoard.get_Player(tradeP1-1), gameBoard.get_Player(tradeP1-1), trade1index-1, trade2index-1);
                      
                 }
                  }
                } );
            btnCancel.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {   
                 frame.dispose();
                    }
                } );

       basePanel.setSize(150,150);
       basePanel.add(btnTrade); basePanel.add(btnCancel); basePanel.add(Linstructions);
       basePanel.add(Lprop1);basePanel.add(player1Properties); basePanel.add(Lprop2); basePanel.add(player2Properties);
       basePanel.add(Lprop3);basePanel.add(player3Properties); basePanel.add(Lprop4); basePanel.add(player4Properties); basePanel.add(Lspace2); 

       frame.add(basePanel);
       frame.pack();
       frame.setVisible(true);
       }
       
       public void Morgage_Menu(Player currentP){
           JFrame frame = new JFrame("Morgage Menu");
           JPanel basePanel = new JPanel();
           basePanel.setLayout(new FlowLayout());
           JButton btnMorgage = new JButton("Morgage");
           JButton btnCancel = new JButton("Cancel");
           JLabel Linstructions = new JLabel("    Please select the property you wish to morgage and press morgage:   ");
           
           String[] properties = new String[40];   
                for(int i =0; i < currentP.Get_Property_Amount(); i++ ){
                 properties[i] = currentP.Get_Property_Name(i);
                   }
            JComboBox playerProperties = new JComboBox(properties); 
           
           btnMorgage.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                 frame.dispose();
                         /////
                 //ADD Morgage Logic
                         ////
                    }
                } );
            btnCancel.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {   
                 frame.dispose();
                    }
                } );
           basePanel.add(btnMorgage); basePanel.add(btnCancel); basePanel.add(Linstructions); basePanel.add(playerProperties);
           frame.add(basePanel);
           frame.pack();
           frame.setVisible(true);
       }
       
       public void Confirm_Trade(Player currentP, Player tradeP1, Player tradeP2, int trade1index, int trade2index){
           JFrame frame = new JFrame("Confirm Trade");
           JPanel basePanel = new JPanel();
           JLabel invalidTrade = new JLabel("The selected trade was invalid");
           JButton btnTrade = new JButton("Trade");
           JButton btnCancel = new JButton("Cancel");
           
           btnTrade.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                 frame.dispose();
                         /////
                 //ADD Trade Logic
                         ////
                    }
                } );
            btnCancel.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {   
                 frame.dispose();
                    }
                } );
           
           
           if(trade1index == 0 && trade2index == 0){
               basePanel.add(invalidTrade);
               frame.add(basePanel);
               frame.pack();
               frame.setVisible(true);
           }
           else{
               basePanel.setLayout(new FlowLayout());
               frame.setSize(300,300);
               basePanel.setSize(300,300);
               JLabel LConfirm = new JLabel("Do the selceted players confirm the Trade?                                                         ");
               JLabel PlayerTrader1 = new JLabel(tradeP1.Get_Name() + " - " );
               JLabel PlayerTrader2 = new JLabel(tradeP2.Get_Name());
               JLabel prop1 = new JLabel(tradeP1.Get_Property_Name(trade1index));
               JLabel prop2 = new JLabel(tradeP2.Get_Property_Name(trade2index));
               JLabel Lspace = new JLabel("                                                                       ");
               basePanel.add(LConfirm); basePanel.add(PlayerTrader1); basePanel.add(prop1); basePanel.add(PlayerTrader2); basePanel.add(prop2);
               basePanel.add(Lspace);
               basePanel.add(btnTrade); basePanel.add(btnCancel);    
           }
       }
       
       public void Chance_Window(Player currentP){
           JFrame frame = new JFrame("Chance Card");
           JPanel basePanel = new JPanel();
           basePanel.setLayout(new FlowLayout());
           basePanel.setSize(300,300);
           frame.setSize(300,300);
           //sean has example in his code
           //gameBoard.Get_Board(tile index).getEvent(currentP);
           //Jlabel eventTxt = new Jlabel("This is the text to show");
           //basePanel.add(evenTxt);
           
           //actual event logic
           frame.add(basePanel);
           frame.pack();
           frame.setVisible(true);
       }
       public void Community_Window(Player currentP){
           JFrame frame = new JFrame("Community Chest");
           JPanel basePanel = new JPanel();
           basePanel.setLayout(new FlowLayout());
           basePanel.setSize(300,300);
           frame.setSize(300,300);
           //Jlabel eventTxt = new Jlabel();
           //basePanel.add(evenTxt);
           
           //actual event logic
           frame.add(basePanel);
           frame.pack();
           frame.setVisible(true);
       }
       
       public void Completed_Window(){
           JPanel basePanel = new JPanel();
           basePanel.setSize(1000,1000);
           basePanel.setLayout(new FlowLayout());
           JFrame frame = new JFrame("Finished!");
           frame.setSize(1000,1000);
           JTextField txtmessage = new JTextField("The game is complete! \n Let's see the standings :D \n");
           JLabel Lfinish = new JLabel("The game is complete! Let's see the standings :D ");
           JLabel Lplayer1 = new JLabel(gameBoard.get_Player(0).Get_Name()+" total worth: " + gameBoard.get_Player(0).Get_Total_Worth());
           JLabel Lplayer2 = new JLabel(gameBoard.get_Player(1).Get_Name()+" total worth: "+ gameBoard.get_Player(1).Get_Total_Worth());
           JLabel Lplayer3 = new JLabel(gameBoard.get_Player(2).Get_Name()+" total worth: "+ gameBoard.get_Player(2).Get_Total_Worth());
           JLabel Lplayer4 = new JLabel(gameBoard.get_Player(3).Get_Name()+" total worth: "+ gameBoard.get_Player(3).Get_Total_Worth());
           JLabel Lwinner = new JLabel();
           int highestAmount = 0;
           int highestIndex = 0;
           for(int i = 0; i<4; i++){
               if(gameBoard.get_Player(i).Get_Total_Worth() >= highestAmount ){
                   highestIndex = i;
                   highestAmount = gameBoard.get_Player(i).Get_Total_Worth();
               }
           }
           Lwinner.setText("The winner is " + gameBoard.get_Player(highestIndex).Get_Name() + "!");
           basePanel.add(txtmessage);
           basePanel.add(Lplayer1); basePanel.add(Lplayer2); basePanel.add(Lplayer3); basePanel.add(Lplayer4); 
           basePanel.add(Lwinner);
           
           frame.add(basePanel);
           frame.pack();
           frame.setVisible(true);
       }
       
    public void Player_Elimination(Player currentP){
        JFrame frame = new JFrame("Player Elimination");
        JPanel panel = new JPanel();
        frame.setSize(150,150);
        panel.setSize(150,150);
        panel.setLayout(new FlowLayout());
        JLabel Lmessage = new JLabel(currentP.Get_Name() + "'s account balance has dropped below zero. ");
        JLabel Lmessage2 = new JLabel(currentP.Get_Name() + " has been eliminated from the game.");
        panel.add(Lmessage); panel.add(Lmessage2);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
