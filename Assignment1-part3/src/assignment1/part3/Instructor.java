package assignment1.part3;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author matheus leite
 */
public class Instructor extends Person {
    
    private int employeeNum;
    private LocalDate hireDate;
    private ArrayList<String> teachableCourses;
    
    
    /**
     * Customized constructor for the class Instructor
     * @param firstName the first name of the instructor
     * @param lastName the last name of the instructor
     * @param streetAddress the street address of the instructor
     * @param city the city of the instructor
     * @param province the province of the instructor
     * @param postalCode the postal code of the instructor
     * @param birthDate the birthdate of the instructor
     * @param employeeNumber the employee number of the instructor
     * @param hireDate the hire date of the instructor
     */
    public Instructor(String firstName, String lastName, String streetAddress, 
            String city, String province, String postalCode, LocalDate birthDate,
            int employeeNumber, LocalDate hireDate) {
        
        super(firstName, lastName, streetAddress, city, province, postalCode, 
                birthDate);
        
        this.employeeNum = employeeNumber;
        this.setHireDate(hireDate);
        this.teachableCourses = new ArrayList<String>();
    }
    
    /**
     * Default get method for the employeeNum attribute
     * @return An integer representing the employee number
     */
    public int getEmployeeNum() {
        return employeeNum;
    }
    
    /**
     * Default get method for the hireDate attribute
     * @return A local date representing the date that the instructor was hired
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Default method that returns an arrayList of the teachable courses
     * by this instructor
     * @return An arrayList<String> with the teachable courses by this
     * instructor
     */
    public ArrayList<String> getTeachableCourses() {
        return teachableCourses;
    }
    
    
    /**
     * Method that checks if the hire date is older than 80 years or it is in
     * the future. If the hire date is younger or equals to 80 years it sets the
     * variable hireDate to the new hireDate
     * @param hireDate The new hire date of the instructor
     */
    public void setHireDate(LocalDate hireDate) {
        int yearsHired = LocalDate.now().getYear() - hireDate.getYear();
        if(LocalDate.now().getMonth().compareTo(hireDate.getMonth()) < 0) {
            yearsHired = yearsHired-1;
        } else if (LocalDate.now().getMonth().compareTo(hireDate.getMonth()) == 0) {
            if(LocalDate.now().getDayOfMonth() < hireDate.getDayOfMonth()) {
                yearsHired = yearsHired-1;
            }
        }
        
        if(yearsHired > 80 || yearsHired < 0) {
            throw new IllegalArgumentException("The hire date must not be older"
                    + "than 80 years");
        } else {
            this.hireDate = hireDate;
        }
    }
    
    /**
     * Method that adds a new teachable course to the instructor
     * @param courseCode A String representing the course code
     */
    public void addTeachableCourse(String courseCode) {
        this.teachableCourses.add(courseCode.toUpperCase());
    }
    
    /**
     * Method that returns true if the courseCode is in the teachable courses
     * list
     * @param courseCode A String containing a course code to be tested
     * @return true if the course code is in the teachable courses, false otherwise
     */
    public boolean canTeach(String courseCode) {
        return this.teachableCourses.contains(courseCode.toUpperCase());
    }
    
    /**
     * Method that returns an integer representing the years that the instructor
     * worked at the college
     * @return An integer representing the years that the instructor
     * worked at the college
     */
    public int getYearsAtCollege() {
       int yearsHired = LocalDate.now().getYear() - hireDate.getYear();
        if(LocalDate.now().getMonth().compareTo(hireDate.getMonth()) < 0) {
            yearsHired = yearsHired-1;
        } else if (LocalDate.now().getMonth().compareTo(hireDate.getMonth()) == 0) {
            if(LocalDate.now().getDayOfMonth() < hireDate.getDayOfMonth()) {
                yearsHired = yearsHired-1;
            }
        }
        return yearsHired;
    }
    
    /**
     * Method that returns a A String with all the subjects that the instructor 
     * is certified to teach
     * @return A String with all the subjects that the instructor is certified
     * to teach
     */
    public String listOfSubjectsCertifiedToTeach() {
        String teachableCourses ="";
        for(String course : this.teachableCourses) {
            if(teachableCourses.length() != 0) {
                teachableCourses += ", ";
            }
            teachableCourses += course;
        }
        return teachableCourses;
    }
    
    /**
     * Customized set method that checks if the given birthday falls into the range
     * of 18-100 years old, setting the new birth date as the instructor birth date
     * if it is true
     * @param birthdate the new birth date to be set
     */
    @Override
    public void setBirthday(LocalDate birthdate) {
        int age = birthdate.until(LocalDate.now()).getYears();
        if(age >= 18 && age <= 100) {
            this.setBirthday(birthdate);
        } else {
            throw new IllegalArgumentException("The instructor age must be between"
                    + "18 and 100 years old");
        }
    }
    
    /**
     * Overridden toString method that returns the first name, last name and 
     * employee number as a string
     * @return A String that holds the first name, last name and employee number
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.getFirstName(), this.getLastName(), 
                this.employeeNum);
    }
    
    
}
