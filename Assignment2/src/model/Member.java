package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author matheus leite
 */
public class Member {
    private String firstName, lastName, streetAddress, city, province, 
            postalCode, emailAddress, phoneNumber;
    private LocalDate birthdate;
    private int membershipNumber;
    private ArrayList<Membership> memberships;

    /**
     * Customized constructor for the Member class
     * @param firstName Given Name of the Member
     * @param lastName Surname of the Member
     * @param streetAddress Street address
     * @param city City 
     * @param province Province
     * @param postalCode Postal Code in the form of A1A1A1 where A is a letter
     * and 1 is a digit
     * @param birthDate Birth date of the Member
     * @param emailAddress emailAddress of the member
     * @param phoneNumber phoneNumber of the member
     */
    public Member(String firstName, String lastName, String streetAddress, 
            String city, String province, String postalCode, LocalDate birthDate,
            String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.emailAddress = emailAddress;
        this.setPhoneNumber(phoneNumber);
        this.setPostalCode(postalCode);
        this.birthdate = birthDate;
        this.membershipNumber = -1;
        this.memberships = new ArrayList<Membership>();
    }

    /**
     * default getter for the first name attribute
     * @return a String containing the first Name of the Member
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * default getter for the last name attribute
     * @return A String with the last name of the Member
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * default getter for the street address attribute
     * @return A String with the street address of the Member
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * default getter for the city attribute
     * @return A String with the city of the Member
     */
    public String getCity() {
        return city;
    }

    /**
     * default getter for the province attribute
     * @return A String with the province attribute of the Member
     */
    public String getProvince() {
        return province;
    }

    /**
     * default getter for the postal code attribute
     * @return A String with the postal code of the Member
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * default getter for the birth date attribute 
     * @return A Local Date with the birth date of the Member
     */
    public LocalDate getBirthday() {
        return birthdate;
    }
    
    /**
     * This method returns the phone number of the Member
     * @return A String representing the phone number of the Member
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    /**
     * This method returns the email address of the Member
     * @return A String representing the email address of the Member
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    /**
     * This method returns the membership number of the Member
     * @return An integer representing the membership number of the Member
     */
    public int getMembershipNumber() {
        return this.membershipNumber;
    }
    
    /**
     * This method returns the memberships of the Member
     * @return An array list with the memberships of the member
     */
    public ArrayList<Membership> getMemberships() {
        return this.memberships;
    }
    
    /**
     * This method adds a new membership to the memberships list
     * @param newMembership to be added to the memberships list
     */
    public void addMembership(Membership newMembership) {
        this.memberships.add(newMembership);
    }
    
    /**
     * default setter for the first name attribute
     * @param firstName the new first name of the Member 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * default setter for the last name attribute
     * @param lastName the new last name of the Member
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * default setter for the street address attribute
     * @param streetAddress the new street address of the Member
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    /**
     * default setter for the city attribute
     * @param city the new city of the Member
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * customized setter for the postal code attribute, it tests if the postal 
     * code complies with the pattern A1A1A1 where A is a letter and 1 is a digit
     * @param postalCode the new postal code 
     */
    public void setPostalCode(String postalCode) {
        this.validatePostalCode(postalCode);
    }
    
    /**
     * default setter for the province attribute
     * @param province new province of the Member
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * default setter for the birth date attribute
     * @param birthdate new birth date for the Member
     */
    public void setBirthday(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    /**
     * customized setter for the phone number attribute
     * @param phoneNumber new phoneNumber for the Member
     */
    public void setPhoneNumber(String phoneNumber) {
        this.validatePhoneNumber(phoneNumber);
    }
    
    /**
     * default setter for the email address attribute
     * @param emailAddress new emailAddress for the Member
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    /**
     * customized setter for the membership number attribute
     * @param membershipNumber the membership number to be set
     */
    protected void setMembershipNumber(int membershipNumber) {
        if(this.membershipNumber == -1) {
            this.membershipNumber = membershipNumber;            
        } 
    }
    
    /**
     * This method validates the length of the phone number and if it follows the
     * pattern 1111111111
     * @param phoneNumber 
     */
    private void validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 10) {
            throw new IllegalArgumentException("The phone number must have 10 characters");            
        }else if(!Pattern.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d", phoneNumber)) {
            throw new IllegalArgumentException("The phone number must follow the "
                    + "pattern 1111111111 where 1 is a digit");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }
    
    /**
     * This method validates the length of the postal code and if it follows the
     * pattern A1A1A1
     * @param postalCode 
     */
    private void validatePostalCode(String postalCode) {
        if(postalCode.length() != 6) {
            throw new IllegalArgumentException("The postal code must have 6 characters");            
        }else if(!Pattern.matches("[A-Z]\\d[A-z]\\d[A-Z]\\d", postalCode.toUpperCase())) {
            throw new IllegalArgumentException("The postal code must follow the "
                    + "pattern A1A1A1 where A is a letter and 1 is a digit");
        } else {
            this.postalCode = postalCode.toUpperCase();
        }
    }
    
    /**
     * Customized to String that returns a string with the first and last name
     * of the Member
     * @return A String holding the first and last name of the Member separated
     * by a space character
     */
    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

}