package assignment1.part2;

import java.time.LocalDate;

/**
 *
 * @author matheus leite
 */
public class Student extends Person {
    
    private String major;
    private int studentNumber;
    private LocalDate enrollmentDate;
    boolean goodStanding;
    
    public Student(String firstName, String lastName, String streetAddress, 
            String city, String province, String postalCode, LocalDate birthDate,
            String major, int studentNumber, 
            LocalDate enrollmentDate) {
        super(firstName, lastName, streetAddress, city, province, postalCode, birthDate);
        this.setBirthday(birthDate);
        this.enrollmentDate = enrollmentDate;
        this.setStudentNumber(studentNumber);
        this.major = major;
        this.goodStanding = true;
    }
    
    /**
     * Customized set method that verifies if the student number is positive and
     * different from zero
     * @param studentNumber to be attributed to the student 
     */
    public void setStudentNumber(int studentNumber) {
        if( studentNumber > 0) {
            this.studentNumber = studentNumber;
        } else {
            throw new IllegalArgumentException("Student number must be positive"
                    + "and different from zero");
        }
    }
    
    /**
     * Method that returns the year of enrollment of the student
     * @return An integer representing the year of enrollment 
     */
    public int getYearEnrolled() {
        return this.enrollmentDate.getYear();
    }
    
    /**
     * This method returns the number of years the student has completed
     * at the college
     * @return An integer representing the number of years the student has
     * completed at the college
     */
    public int getYearsAtCollege() {
        int yearsEnrolled = LocalDate.now().getYear() - this.getYearEnrolled();
        if(LocalDate.now().getMonth().compareTo(this.enrollmentDate.getMonth()) < 0) {
            yearsEnrolled = yearsEnrolled-1;
        } else if (LocalDate.now().getMonth().compareTo(this.enrollmentDate.getMonth()) == 0) {
            if(LocalDate.now().getDayOfMonth() < this.enrollmentDate.getDayOfMonth()) {
                yearsEnrolled = yearsEnrolled-1;
            }
        }
        return yearsEnrolled;
    }
    
    /**
     * Method that returns if the student is in good standing or not
     * @return True if the student is in good standing, false otherwise
     */
    public boolean inGoodStanding() {
        return this.goodStanding;
    }
    
    /**
     * Method that reinstate the good standing of the student, setting it to true
     */
    public void reinstateStudent() {
        this.goodStanding = true;
    }
    
    /**
     * Customized set method that checks if the given birthday falls into the range
     * of 14-90 years old, setting the new birth date as the student birth date
     * if it is true
     * @param birthdate the new Birth date to be set
     */
    @Override
    public void setBirthday(LocalDate birthdate) {
        int age = LocalDate.now().getYear() - birthdate.getYear();
        if(LocalDate.now().getMonth().compareTo(birthdate.getMonth()) < 0) {
            age = age-1;
        } else if (LocalDate.now().getMonth().compareTo(birthdate.getMonth()) == 0) {
            if(LocalDate.now().getDayOfMonth() < birthdate.getDayOfMonth()) {
                age = age-1;
            }
        }
        
        if(age >= 14 && age <= 90) {
            this.birthdate = birthdate;
        } else {
            throw new IllegalArgumentException("The student age must be between"
                    + "14 and 90 years old");
        }
    }
    
    /**
     * Method that changes the good standing variable of the student to false
     */
    public void suspendStudent() {
        this.goodStanding = false;
    }
    
    
    /**
     * Overridden toString method that returns the first name, last name and 
     * student number as a string
     * @return A String that holds the first name, last name and student number
     */
    @Override
    public String toString() {
        return String.format("%s %s, student number is %d", this.firstName, this.lastName, this.studentNumber);
    }
    
    
    
}
