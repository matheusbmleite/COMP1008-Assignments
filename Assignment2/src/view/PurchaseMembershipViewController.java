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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;
import model.Members;
import model.Membership;

/**
 * FXML Controller class
 *
 * @author matheus leite
 */
public class PurchaseMembershipViewController implements Initializable {
    
    //Labels
    @FXML private Label typeLabel;
    @FXML private Label startDateLabel;
    @FXML private Label endDateLabel;
    @FXML private Label totalLabel;
    @FXML private Label errorLabel;
    
    //Date Pickers and ChoiceBox
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ChoiceBox<String> typeChoiceBox;
    
    //textField
    @FXML private TextField totalTextField;
    
    private Member member;
    private Members members;
    private Membership membership;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setText("");
        this.totalTextField.setEditable(false);
        
        //setting up the choice box
        this.typeChoiceBox.getItems().addAll("GYM", "ROCKWALL", "FULLFACILITY");
        this.typeChoiceBox.setValue("GYM");
    }
    
    /**
     * This method receives a member to which the membership will be purchased
     * and the members list to update it
     * @param members
     * @param member 
     */
    public void receiveData (Members members, Member member) { 
        this.members = members;
        this.member = member;
    }
    
    /**
     * This method will calculate the total of the purchase and display it in 
     * the total text field
     */
    public void calculateTotalButtonPushed() {
        this.errorLabel.setText("");
        try {
            this.membership = new Membership(this.typeChoiceBox.getValue(),
                this.startDatePicker.getValue(), 
                this.endDatePicker.getValue());
            String price = String.format("%.2f", this.membership.getPrice());
            System.out.println(this.membership.getPrice());
            this.totalTextField.setText(price);
        }catch (IllegalArgumentException e) {
            this.errorLabel.setText(e.getMessage());
        }
        
    }
    
    /**
     * This method will create a new membership and assign it to the member 
     * selected on the last view, it will also change the view to the main panel
     * of the application
     * @param event
     * @throws IOException 
     */
    public void purchaseButtonPushed(ActionEvent event) throws IOException {
        try {
            this.membership = new Membership(this.typeChoiceBox.getValue(),
                this.startDatePicker.getValue(), 
                this.endDatePicker.getValue());
            this.member.addMembership(membership);
            this.changeView(event);
        }catch (IllegalArgumentException e) {
            this.errorLabel.setText(e.getMessage());
        }
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
        controller.setMemberList(members);
        
         //Getting the stage object
         Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
         stage.setTitle("COMP 1008 GYM");
         stage.setScene(tableViewScene);
         stage.show();
    }
    
    
    
}
