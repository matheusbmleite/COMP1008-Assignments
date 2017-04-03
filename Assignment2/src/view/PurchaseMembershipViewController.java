/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
    public void calculateTotalButtonPushed() {
        try {
            this.membership = new Membership(this.typeChoiceBox.getValue(),
                this.startDatePicker.getValue(), 
                this.endDatePicker.getValue());
            this.totalTextField.setText(Double.toString(this.membership.getPrice()));
        }catch (IllegalArgumentException e) {
            this.errorLabel.setText(e.getMessage());
        }
        
    }
    public void purchaseButtonPushed() {
        
    }
    
    
    
}
