/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gooey.stuff;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MeganHaskins
 */
public class View1 extends Driver{
 public void View1(){    }
    
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
    public void viewBoard(){
        JFrame frame = new JFrame();
        System.out.println("Give Instructions");
        JPanel basePanel = new JPanel();
        basePanel.setLayout(null);
        JPanel Boardpanel = new JPanel();
        Boardpanel.setLayout(null);
        Boardpanel.setPreferredSize(new Dimension(1000,1000));
        //get board image
        File imageFile = new File("C:\\Users\\MeganHaskins\\Desktop\\Monopoly Images\\Board.JPG");
        BufferedImage boardImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
           try{
           boardImage = ImageIO.read(imageFile);
             } 
          catch(IOException e){
             System.out.println("Error: " + e);
             }
       JLabel photoLabel = new JLabel(new ImageIcon(boardImage));
       Boardpanel.add(photoLabel);
       
       //get tokin image
        imageFile = new File("C:\\Users\\MeganHaskins\\Desktop\\Tokin Fadora.PNG");
        BufferedImage tokinImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
           try{
           tokinImage = ImageIO.read(imageFile);
             } 
          catch(IOException e){
             System.out.println("Error: " + e);
             }
       JLabel tokinLabel = new JLabel(new ImageIcon(tokinImage));
       
       
       
       JPanel tokin1 = new JPanel();
       tokin1.setLayout(null);
       Boardpanel.add(tokin1);
       basePanel.add(Boardpanel);
       frame.getContentPane().add(basePanel);
       frame.pack();
       frame.setVisible(true);  
       playerInformation();
    }
    
    public void setupMenu(){
        int playerCount = 0;
        
        Text space1 = new Text("                  ");
        Text space2 = new Text("                  ");
        Text space3 = new Text("                 ");
        Text space4 = new Text("                                                 ");
        Text space5 = new Text("                                               ");
        
        Text text1 = new Text("Lets set up the game. \n Please select number of players and choose a tokin.\n Number of players allowed 2-4. \n \n Amount of Players:");
        TextField numberResponse = new TextField();
        Text txtP1 = new Text("Player One Tokin: ");
        Text txtP2 = new Text("Player Two Tokin: ");
        Text txtP3 = new Text("Player Three Tokin: ");
        Text txtP4 = new Text("Player Four Tokin: ");
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
             String player1Name = "";
             String player2Name = "";
             String player3Name = "";
             String player4Name = "";
             String stringPlayerAmount;
             int numberOfPlayers;
            double timeAlotment;
            @Override
            public void handle(ActionEvent event) {
               player1Name = TFplayer1.getText();
               player2Name = TFplayer2.getText();
               player3Name = TFplayer3.getText();
               player4Name = TFplayer4.getText();
               stringPlayerAmount = numberResponse.getText();
               if(stringPlayerAmount == "1"){numberOfPlayers = 1;}
               if(stringPlayerAmount == "2"){numberOfPlayers = 2;}
               if(stringPlayerAmount == "3"){numberOfPlayers = 3;}
               if(stringPlayerAmount == "4"){numberOfPlayers = 4;}
                       
                gameMenu();
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
    
    public void gameMenu(){
        FlowPane root = new FlowPane();
        Button btnViewBoard = new Button("View Board");
        Button btnStartTurn = new Button("Start Turn");
        Button btnInstructions = new Button("Instructions");
        
        btnInstructions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                instructionEvent();
            }
        });
        
        btnViewBoard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewBoard();
            }
        });
        
        btnStartTurn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                turnMenu();
            }
        });
        
        root.getChildren().add(btnViewBoard);
        root.getChildren().add(btnStartTurn);
        root.getChildren().add(btnInstructions);
        
        Scene gameMenu = new Scene(root, 500, 450);
        
        Stage gameStage = new Stage();
        gameStage.setTitle("Game Menu");
        gameStage.setScene(gameMenu);
        gameStage.show();
    }
    
    public void turnMenu(){
        FlowPane root = new FlowPane();
        Button btnRollDice = new Button("Roll Dice");
        Button btnManageProperty = new Button("Manage Property");
        Button btnViewBoard = new Button("View Board");
        Button btnEndTurn = new Button("End Turn");
        Button btnForfeit = new Button("Forfiet");
        
        root.getChildren().add(btnRollDice);
        root.getChildren().add(btnManageProperty);
        root.getChildren().add(btnViewBoard);
        root.getChildren().add(btnEndTurn);
        root.getChildren().add(btnForfeit);
        
        Scene gameMenu = new Scene(root, 500, 450);
        
        Stage gameStage = new Stage();
        gameStage.setTitle("Game Menu");
        gameStage.setScene(gameMenu);
        gameStage.show();
    }
    
    public void playerInformation(){
        JFrame frame = new JFrame();
        JPanel allPanel = new JPanel();
        allPanel.setPreferredSize(new Dimension(500,1200));
        
        allPanel.add(PlayerPanel("Player One", "Account Balance"));
        allPanel.add(PlayerPanel("Player Two", "Account Balance"));
        allPanel.add(PlayerPanel("Player Three", "Account Balance"));
        allPanel.add(PlayerPanel("Player Four", "Account Balance"));
        
        frame.getContentPane().add(allPanel);
        frame.pack();
        frame.setVisible(true);  

        
    }
    public JPanel PlayerPanel(String pName,String money){
        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(300,150));
        //Player One Image Panel
        JPanel ImagePanel = new JPanel();
        ImagePanel.setPreferredSize(new Dimension(100,100));
        File imageFile = new File("C:\\Users\\MeganHaskins\\Desktop\\Tokin Fadora.PNG");
        BufferedImage fadoraImage3 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            try{
                fadoraImage3 = ImageIO.read(imageFile);
                } 
            catch(IOException e){
                System.out.println("Error: " + e);
                }
        JLabel photoLabel3 = new JLabel(new ImageIcon(fadoraImage3));
        ImagePanel.add(photoLabel3);
        //Player One Data Panel
        JPanel DataPanel = new JPanel();
        DataPanel.setPreferredSize(new Dimension(150,150));
        JLabel playerThreeName = new JLabel(pName);
        JTextField account3 = new JTextField(money);
        JComboBox playerThreeProp = new JComboBox();
        DataPanel.add(playerThreeName);
        DataPanel.add(account3);
        DataPanel.add(playerThreeProp);
        
        //Layering Panels
        playerPanel.add(ImagePanel);
        playerPanel.add(DataPanel);
        
        return playerPanel;
    }
   
 
}
