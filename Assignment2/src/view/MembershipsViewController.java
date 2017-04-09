package view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Member;
import model.Members;
import model.Membership;

/**
 * FXML Controller class
 *
 * @author matheus leite
 */
public class MembershipsViewController implements Initializable {
    
    //Labels that will be populated
    @FXML private Label membershipNumLabel;
    @FXML private Label fnameLabel;
    @FXML private Label lnameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    
    //fixed labels
     @FXML private Label membershipNumLabelFixed;
    @FXML private Label fnameLabelFixed;
    @FXML private Label lnameLabelFixed;
    @FXML private Label emailLabelFixed;
    @FXML private Label phoneLabelFixed;
    
    //configuring the table
    @FXML private TableView<Membership> tableView;
    @FXML private TableColumn<Membership, String> membershipType;
    @FXML private TableColumn<Membership, String> membershipStatus;
    @FXML private TableColumn<Membership, LocalDate> membershipStartDate;
    @FXML private TableColumn<Membership, LocalDate> membershipEndDate;
    @FXML private TableColumn<Membership, Double> membershipPrice;
    
    private Member member;
    private Members members;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        membershipType.setCellValueFactory(new PropertyValueFactory<Membership, String>("type"));
        membershipStatus.setCellValueFactory(new PropertyValueFactory<Membership, String>("status"));
        membershipStartDate.setCellValueFactory(new PropertyValueFactory<Membership, LocalDate>("startDate"));
        membershipEndDate.setCellValueFactory(new PropertyValueFactory<Membership, LocalDate>("endDate"));
        membershipPrice.setCellValueFactory(new PropertyValueFactory<Membership, Double>("price"));
        
        //Setting the id for the css
        this.membershipNumLabelFixed.setId("memberLabel");
        this.fnameLabelFixed.setId("memberLabel");
        this.lnameLabelFixed.setId("memberLabel");
        this.emailLabelFixed.setId("memberLabel");
        this.phoneLabelFixed.setId("memberLabel");
    }

    /**
     * This method gets the membership list as an observable list
     * @return ObservableList<Membership> representing the memberships assigned to
     * a member
     */
    public ObservableList<Membership> getMemberships() {
        return FXCollections.observableArrayList(this.member.getMemberships());
    }
    
    /**
     * This method receives a member from which the memberships are to be displayed
     * @param member 
     */
    public void receiveData (Members members, Member member) { 
        this.member = member;
        this.members = members;
        //loading memberships
        tableView.setItems(getMemberships());
        
        this.membershipNumLabel.setText(Integer.toString(member.getMembershipNumber()));
        this.fnameLabel.setText(member.getFirstName());
        this.lnameLabel.setText(member.getLastName());
        this.emailLabel.setText(member.getEmailAddress());
        this.phoneLabel.setText(member.getPhoneNumber());
    }
    
    /**
     * Method that returns to the main scene (main panel) of the application when
     * a button is pushed
     * @param event
     * @throws IOException 
     */
    public void okButtonPushed(ActionEvent event) throws IOException {
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
