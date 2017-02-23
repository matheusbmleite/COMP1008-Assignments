package assignment1.part2;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 *
 * @author matheus leite
 */
public class Person {
    String firstName, lastName, streetAddress, city, province, postalCode;
    LocalDate birthdate;

    /**
     * Customized constructor for the person class
     * @param firstName Given Name of the person
     * @param lastName Surname of the person
     * @param streetAddress Street address
     * @param city City 
     * @param province Province
     * @param postalCode Postal Code in the form of A1A1A1 where A is a letter
     * and 1 is a digit
     * @param birthDate Birth date of the person
     */
    public Person(String firstName, String lastName, String streetAddress, 
            String city, String province, String postalCode, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.setPostalCode(postalCode);
        this.birthdate = birthDate;
    }

    /**
     * default getter for the first name attribute
     * @return a String containing the first Name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * default getter for the last name attribute
     * @return A String with the last name of the person
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * default getter for the street address attribute
     * @return A String with the street address of the person
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * default getter for the city attribute
     * @return A String with the city of the person
     */
    public String getCity() {
        return city;
    }

    /**
     * default getter for the province attribute
     * @return A String with the province attribute of the person
     */
    public String getProvince() {
        return province;
    }

    /**
     * default getter for the postal code attribute
     * @return A String with the postal code of the person
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * default getter for the birth date attribute 
     * @return A Local Date with the birth date of the person
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    /**
     * This method returns the full address within the following format: 
     * streetAddress, city, province, postalCode
     * @return the Full address as a single String
     */
    public String getFullAddress() {
        return String.format("%s, %s, %s, %s", this.streetAddress, this.city, this.province, this.postalCode);
    }
    
    /**
     * This method returns the year of the person
     * @return An integer representing the year of the person
     */
    public int getAge() {
        int age = LocalDate.now().getYear() - this.getYearBorn();
        if(LocalDate.now().getMonth().compareTo(this.birthdate.getMonth()) < 0) {
            age = age-1;
        } else if (LocalDate.now().getMonth().compareTo(this.birthdate.getMonth()) == 0) {
            if(LocalDate.now().getDayOfMonth() < this.birthdate.getDayOfMonth()) {
                age = age-1;
            }
        }
        
        return age;     
    }
    
    /**
     * This method returns the year that the person was born
     * @return An integer representing the year that the person was born
     */
    public int getYearBorn() {
        return this.birthdate.getYear();
    }
    
    /**
     * default setter for the first name attribute
     * @param firstName the new first name of the person 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * default setter for the last name attribute
     * @param lastName the new last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * default setter for the street address attribute
     * @param streetAddress the new street address of the person
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    /**
     * default setter for the city attribute
     * @param city the new city of the person
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
     * @param province new province of the person
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * default setter for the birth date attribute
     * @param birthdate new birth date for the person
     */
    public void setBirthday(LocalDate birthdate) {
        this.birthdate = birthdate;
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
     * This method change the complete address of the person
     * @param street the new street address
     * @param city the new city 
     * @param province the new province
     * @param postalCode the new postal code
     */
    public void changeAddress(String street, String city, String province, String postalCode) {
        this.setStreetAddress(street);
        this.setCity(city);
        this.setProvince(province);
        this.setPostalCode(postalCode);
    }
    
    /**
     * Customized to String that returns a string with the first and last name
     * of the Person
     * @return A String holding the first and last name of the person separated
     * by a space character
     */
    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}