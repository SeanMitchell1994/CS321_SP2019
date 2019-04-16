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
    
    //needed trade variables
    int tradeP1;
    int tradeP2;
    int selectionCount;
    int trade1index;
    int trade2index;
    
 public void View1(){  turnCounter = 0; }
    
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
                
       JPanel panel = new JPanel();
       panel.setPreferredSize(new Dimension(1000,1000));
       JLabel instructionText = new JLabel("These are the Instructions to play: \n win");
       panel.add(instructionText);

       JFrame frame = new JFrame("Instructions");
       frame.getContentPane().add(panel);
       frame.pack();
       frame.setVisible(true);  
    }
    
    //Will be edited to display current player locations
    public void viewBoard(Player currentP){
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
        //Get tokin Image
       /* JLabel tokinPhoto1 = new JLabel(gameBoard.get_Player(0).Get_Image());
        tokinPanel1.add(tokinPhoto1); 
        JLabel tokinPhoto2 = new JLabel(gameBoard.get_Player(1).Get_Image());
        tokinPanel2.add(tokinPhoto2); 
        JLabel tokinPhoto3 = new JLabel(gameBoard.get_Player(2).Get_Image());
        tokinPanel3.add(tokinPhoto1); 
        JLabel tokinPhoto4 = new JLabel(gameBoard.get_Player(3).Get_Image());
        tokinPanel4.add(tokinPhoto1);         
        */
        
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
             playerTurns();            
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
        
        Text text1 = new Text("Lets set up the game. \n Please select number of players and choose a tokin.\n Number of players allowed 2-4. \n \n Amount of Players:");
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
        Text txtTime = new Text("Please select a time alotment for each player's turn: ");
        TextField TFTime = new TextField();
        Button btnfinish = new Button("Finish");
        
         btnfinish.setOnAction(new EventHandler<ActionEvent>() {
          Stage setupMenu = new Stage();
             String player1Name = "one";
             String player2Name = "two";
             String player3Name = "thee";
             String player4Name = "four";
             String stringPlayerAmount;
             int numberOfPlayers;
             int timeAlotment;
            @Override
            public void handle(ActionEvent event) {
               player1Name = TFplayer1.getText();
               player2Name = TFplayer2.getText();
               player3Name = TFplayer3.getText();
               player4Name = TFplayer4.getText();
               stringPlayerAmount = numberResponse.getText();
               if("1".equals(stringPlayerAmount)){numberOfPlayers = 1;}
               if("2".equals(stringPlayerAmount)){numberOfPlayers = 2;}
               if("3".equals(stringPlayerAmount)){numberOfPlayers = 3;}
               if("4".equals(stringPlayerAmount)){numberOfPlayers = 4;}
               
               maxPlayers = numberOfPlayers;
              
               if(numberOfPlayers == 1 || numberOfPlayers == 2 || numberOfPlayers == 3 || numberOfPlayers == 4){
                 gameBoard = new Board(numberOfPlayers, player1Name, player2Name, player3Name, player4Name, timeAlotment, 17);
                  viewBoard(gameBoard.get_Player(0));
              }        
            }
        });
        
         //Adding Children to Root
        FlowPane root = new FlowPane(); root.getChildren().add(text1);  root.getChildren().add(numberResponse);
        root.getChildren().add(text15); root.getChildren().add(text2); root.getChildren().add(txtP1);
        root.getChildren().add(TFplayer1); root.getChildren().add(space1); root.getChildren().add(txtP2);
        root.getChildren().add(TFplayer2); root.getChildren().add(space2); root.getChildren().add(txtP3);
        root.getChildren().add(TFplayer3); root.getChildren().add(space3); root.getChildren().add(txtP4);
        root.getChildren().add(TFplayer4); root.getChildren().add(space4); root.getChildren().add(txtTime);
        root.getChildren().add(TFTime); root.getChildren().add(space5); root.getChildren().add(btnfinish);

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
       
       public void playerTurns(){
           viewBoard(gameBoard.get_Player(turnCounter));
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
            String[] P1properties = new String[40]; //player.Get_Property_Amount()  
            for(int i =0; i < gameBoard.get_Player(0).Get_Property_Amount(); i++ ){
            P1properties[i] = gameBoard.get_Player(0).Get_Property_Name(i);
                   }
            JComboBox player1Properties = new JComboBox(P1properties); 
            
            String[] P2properties = new String[40]; 
            for(int i =0; i < gameBoard.get_Player(1).Get_Property_Amount(); i++ ){
            P2properties[i] = gameBoard.get_Player(1).Get_Property_Name(i);
                   }
            JComboBox player2Properties = new JComboBox(P2properties);  
            
            String[] P3properties = new String[40];  
            for(int i =0; i < gameBoard.get_Player(2).Get_Property_Amount(); i++ ){
            P3properties[i] = gameBoard.get_Player(2).Get_Property_Name(i);
                   }
            JComboBox player3Properties = new JComboBox(P3properties);  
            
            String[] P4properties = new String[40];  
            for(int i =0; i < gameBoard.get_Player(3).Get_Property_Amount(); i++ ){
            P4properties[i] = gameBoard.get_Player(3).Get_Property_Name(i);
                   }
            JComboBox player4Properties = new JComboBox(P4properties);  
            
            tradeP1 = 0;
            tradeP2 = 0;
            selectionCount = 0;
            trade1index = 0;
            trade2index=0;
                if(player1Properties.getSelectedItem() != null){
                    trade1index = player1Properties.getSelectedIndex();
                    tradeP1 = 1;
                    selectionCount++;
                }
                if(player2Properties.getSelectedItem() != null){
                    
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
                if(player3Properties.getSelectedItem() != null){
                    
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
                if(player4Properties.getSelectedItem() != null){
                    
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
            if(selectionCount <2){
             tradeP1 = 5;
            tradeP2 = 5;
            selectionCount = 2;
            trade1index = 0;
            trade2index=0;   
            }
            
             
            btnTrade.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                   }                     
                 @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                 frame.dispose();                                                                        //int trade indexes
                 Confirm_Trade(currentP, gameBoard.get_Player(tradeP1-1), gameBoard.get_Player(tradeP1-1), trade1index, trade2index);
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
}
