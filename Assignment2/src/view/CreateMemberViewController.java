package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Member;
import model.Members;

/**
 * FXML Controller class
 *
 * @author matheus leite
 */
public class CreateMemberViewController implements Initializable {
    
      //Labels
    @FXML private Label fnameLabel;
    @FXML private Label lnameLabel;
    @FXML private Label streetAddressLabel;
    @FXML private Label cityLabel;
    @FXML private Label provinceLabel;
    @FXML private Label postalCodeLabel;
    @FXML private Label birthdateLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label errorLabel;
    
    //TextFields
    @FXML private TextField fnameTextField;
    @FXML private TextField lnameTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField postalCodeTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField phoneTextField;
    
    //ChoiceBox and DatePicker
    @FXML private ChoiceBox<String> provinceChoiceBox;
    @FXML private DatePicker birthdateDatePicker;
    
    //Button
    @FXML private Button createButton;
    
    //Members of the application
    private Members newMembers;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setText("");
        
        //setting up the choice box
        this.provinceChoiceBox.getItems().addAll("ON", "QC", "NS", "NB", "MB", 
                "BC", "PE", "SK", "AB", "NL");
        this.provinceChoiceBox.setValue("ON");
        
    }

    /**
     * This method is launched every time the create button is pressed, it 
     * creates a new member, add this new member to the members list and returns 
     * to the main panel of the application
     * @param event 
     * @throws IOException 
     */
    public void createButtonPushed(ActionEvent event) throws IOException {
        Member newMember;
        try {
            newMember = new Member(fnameTextField.getText(), lnameTextField.getText(), 
            streetAddressTextField.getText(), cityTextField.getText(), 
                    provinceChoiceBox.getValue(), 
                    postalCodeTextField.getText(), 
                    birthdateDatePicker.getValue(), emailTextField.getText(),
                    phoneTextField.getText());
            newMembers.addMember(newMember);
            this.changeView(event);
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
            
        }
    }
    
    /**
     * This method receive the members list from the main panel of the application
     * @param members 
     */
    public void receiveMembers(Members members) {
        this.newMembers = members;
    }
    
    /**
     * This method change the scene to the main panel of the application, passing
     * the new members list to it
     * @param event
     * @throws IOException 
     */
    public void changeView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPanelView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
         
        //Passing the member list to the main panel of the application
        MainPanelViewController controller = loader.getController();
        controller.getMemberList(newMembers);
        
         //Getting the stage object
         Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
         stage.setTitle("COMP 1008 GYM");
         stage.setScene(tableViewScene);
         stage.show();
    }
    
}
