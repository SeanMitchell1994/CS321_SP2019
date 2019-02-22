/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gooeypractice;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author MeganHaskins
 */
public class GooeyPractice extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(2000,2000));
        File imageFile = new File("C:\\Users\\MeganHaskins\\Desktop\\Monopoly Images\\Board.JPG");
        BufferedImage boardImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
         try{
             boardImage = ImageIO.read(imageFile);
            } 
         catch(IOException e){
            System.out.println("Error: " + e);
            }
         
        JFrame frame = new JFrame();
          
        JLabel photoLabel = new JLabel(new ImageIcon(boardImage));
        panel.add(photoLabel);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
