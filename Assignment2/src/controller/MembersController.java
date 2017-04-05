package controller;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Members;
import view.MainPanelViewController;

/**
 *
 * @author matheus leite
 */
public class MembersController extends Application {
    private MainPanelViewController mainPanelController;
    private Members members;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.readFromFile();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/MainPanelView.fxml"));
        AnchorPane anchorPane = loader.load();
        
         
        //Passing the member list to the main panel of the application
        this.mainPanelController = loader.getController();
        this.mainPanelController.setMemberList(this.members);
        
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("COMP 1008 GYM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Overriding the stop method, so it executes the save before closing the 
     * application
     */
    @Override
    public void stop(){
        this.saveToFile();
    }
    
    /**
     * Converting the members to Json and writing it to a file called 
     * members.json
     */
    private void saveToFile() {
        Members members = this.mainPanelController.getMembers();
        Gson gson = new Gson();
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        //converting members to json
        gson.toJson(members);
        //converting the json to a string
        String jsonInString = gson.toJson(members);
        
        //writing it to a file called members.json
        try {
            fileWriter = new FileWriter("./resources/members.json");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonInString);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("The file couldn't be saved");
        }
    }
    
    /**
     * This method read the members from a json file and create the object with 
     * the information from the file
     */
    private void readFromFile() {
        Gson gson = new Gson();
        try {
            this.members = gson.fromJson(new FileReader("./resources/members.json"), Members.class);
        } catch (FileNotFoundException e) {
            //If there's no file, do nothing
        }
        
    }

}
