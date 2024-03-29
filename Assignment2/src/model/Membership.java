package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.HashMap;

/**
 *
 * @author matheus leite
 */
public class Membership {
    
    private String type, status;
    private LocalDate startDate, endDate;
    private double price;
    private HashMap<String, Double> rates;
    
    
    /**
     * Customized constructor for the Membership class
     * @param type the type of the membership
     * @param startDate the start date of the membership
     * @param endDate the end date of the membership
     */
    public Membership(String type, LocalDate startDate, LocalDate endDate) {
        this.initializeRates();
        this.setType(type);
        this.setPeriod(startDate, endDate);
        this.setPrice();
    }

    /**
     * This method checks if the period of the membership is valid
     * @param startDate the start date of the membership
     * @param endDate the end date of the membership
     */
    private void setPeriod(LocalDate startDate, LocalDate endDate) {
        
        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("The end date must be at least on "
                    + "the same day as the start date");
        }
        
        if(startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The start date must be today's date"
                    + " or a date in the future");
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.updateStatus();
    }

    
    /**
     * This method initializes the hash map rates with fixed values
     */
    private void initializeRates() {
        this.rates = new HashMap<String, Double>();
        this.rates.put("GYM", 0.5);
        this.rates.put("ROCKWALL", 0.3);
        this.rates.put("FULLFACILITY", 0.8);
    }
    
    /**
     * Default get method for the type attribute
     * @return a String representing the type of the membership
     */
    public String getType() {
        return type;
    }

    /**
     * Customized set method for the type of the membership
     * @param type the new type of the membership
     */
    private void setType(String type) {
        type = type.toUpperCase();
        
        for (String validType : this.rates.keySet()) {
            if(type.equals(validType)) {
                this.type = type;
                return;
            }
        }
        throw new IllegalArgumentException("The membership type is invalid");   
    }

    
    /**
     * This method updates the status of the membership
     */
    public void updateStatus() {
        if(this.endDate.isBefore(LocalDate.now())) {
            this.status = "EXPIRED";
        } else {
            this.status = "ACTIVE";
        }
            

    }
    
    /**
     * Customized method to set the price of the membership
     */
    public void setPrice() {
        double typeRate = this.rates.get(this.type);
        if(this.startDate.equals(this.endDate)) {
            this.price = typeRate + 5;
        } else {
            long length = DAYS.between(this.startDate, this.endDate);
            this.price = typeRate * length * 20;
        }
        
       //Simple way to round the price
       this.price = (Math.round(this.price * 100)) / 100.0;
    }

    /**
     * Default get method for the startDate attribute
     * @return a String representing the type of the membership
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    
    /**
     * Default get method for the endDate attribute
     * @return a String representing the type of the membership
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    
    /**
     * Default get method for the price attribute
     * @return a String representing the type of the membership
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Default get method for the status attribute
     * @return a String representing the type of the membership
     */
    public String getStatus() {
        this.updateStatus();
        return status;
    }
    
    /**
     * This method returns the membership in a human readable way
     * @return A String object representing the Membership object
     */
    public String toString() {
        return String.format("Membership type: %s%n"
                + "Membership status %s%n"
                + "Start date %s%n"
                + "End date %s%n", this.getType(), this.getStatus(), 
                this.getStartDate().toString(), this.getEndDate().toString());
    }
    
    
    
}
