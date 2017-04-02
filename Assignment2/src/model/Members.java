/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author matheus leite
 */
public class Members {
    private ArrayList<Member> membersList;
    private int uniqueId = 1000;
    
    
    /**
     * Customized constructor for the members class
     */
    public Members() {
        this.membersList = new ArrayList<Member>();
    }
    
    /**
     * Method that adds a new member to the members list
     * @param newMember the new member to be added to the new list
     */
    public void addMember(Member newMember) {
        newMember.setMembershipNumber(this.getUniqueId());
        this.membersList.add(newMember);
    }
    
    /**
     * Method that assigns an uniqueId to each member
     * @return the uniqueId to be assigned for a new member
     */
    private int getUniqueId() {
        this.uniqueId += 1;
        return this.uniqueId;
    }  
    
    /**
     * Method that returns the member list
     * @return An arrayList with all the members
     */
    public ArrayList<Member> getMembersList() {
        return this.membersList;
    }
    
}
