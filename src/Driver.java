/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooey.stuff;

import java.io.InputStream;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 *
 * @author MeganHaskins
 */
public class Driver extends Application {
   
    @Override
    public void start(Stage primaryStage) {
        
        InputStream holder = Driver.class.getClassLoader().getResourceAsStream("PracticeFile.txt");
        System.out.println("Next step?");
        View1 trialView = new View1();
        trialView.welcomeMenu();    
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
