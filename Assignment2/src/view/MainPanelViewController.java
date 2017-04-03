/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Member;
import model.Members;

/**
 * FXML Controller class
 *
 * @author matheus leite
 */
public class MainPanelViewController implements Initializable {
    
    //configuring the table
    @FXML private TableView<Member> tableView;
    @FXML private TableColumn<Member, Integer> membershipNumColumn;
    @FXML private TableColumn<Member, String> firstNameColumn;
    @FXML private TableColumn<Member, String> lastNameColumn;
    @FXML private TableColumn<Member, LocalDate> birthdayColumn;
    @FXML private TableColumn<Member, String> emailColumn;
    @FXML private TableColumn<Member, String> phoneColumn;
    
    private Member newMember;
    private Members members = new Members();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        membershipNumColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("membershipNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Member, LocalDate>("birthday"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("emailAddress"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
        
        //loading members
        tableView.setItems(getMembers());
    }    
    
    /**
     * This method gets the members list as an observable list
     * @return ObservableList<Member> representing the members of the application
     */
    public ObservableList<Member> getMembers() {
        return FXCollections.observableArrayList(members.getMembersList());
    }
    
    /**
     * This method receives an updated member list and updates the table with it
     * @param updatedMembers An updated Members object
     */
    public void getMemberList(Members updatedMembers) {
        this.members = updatedMembers;
        //loading updated members
        tableView.setItems(getMembers());
    }
    
    /**
     * This method changes the scene to the create member, passing the Members
     * object to it
     * @param event
     * @throws IOException 
     */
    public void addMemberButtonPushed(ActionEvent event) throws IOException {
               
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CreateMemberView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        CreateMemberViewController controller = loader.getController();
        controller.receiveMembers(members);
        
        //Getting the stage object
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Create Member");
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    public void purchaseMembershipButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PurchaseMembershipView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        PurchaseMembershipViewController controller = loader.getController();
        controller.receiveData(members, this.tableView.getSelectionModel().getSelectedItem());
        
        //Getting the stage object
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Purchase Membership");
        stage.setScene(tableViewScene);
        stage.show();
    }
    
}
