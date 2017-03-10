package assignment1.part3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author matheus leite
 */
public class Course {
    private Instructor instructor;
    private String courseCode, courseName, courseRoom, courseDescription;
    private DayOfWeek courseDay;
    private LocalTime startTime;
    private int maxStudents, durationInHours;
    private ArrayList<Student> students;
    
    /**
     * Customized Constructor for the class Course
     * @param courseCode the code of the course
     * @param courseName the name of the course
     * @param courseDescription the description of the course
     * @param courseRoom the room of the course
     * @param instructor the instructor of the course
     * @param courseDay the day of the course
     * @param startTime the start time of the course
     * @param durationInHours the duration in hours of the course
     * @param maxStudents the maximum number of students
     */
    public Course(String courseCode, String courseName, String courseDescription,
            String courseRoom, Instructor instructor, DayOfWeek courseDay, 
            LocalTime startTime, int durationInHours, int maxStudents) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        this.durationInHours = durationInHours;
        this.setProf(instructor);
        this.setStartTime(startTime);
        this.setMaxNumberOfStudents(maxStudents);
        
        this.students = new ArrayList<Student>();
        
        
        
    }

    /**
     * Method that verifies if the instructor is able to teach the course, if 
     * yes, the instructor is set as instructor of the course
     * @param instructor instructor to be set as instructor of the course
     */
    public void setProf(Instructor instructor) {
        if(instructor.getTeachableCourses().contains(this.courseCode)) {
            this.instructor = instructor;
        } else {
            throw new IllegalArgumentException("The instructor is not able to"
                    + " teach this course");
        }
    }

    /**
     * Method that verifies if the start time is within the range of 8am and 6pm
     * if yes, it sets the start time of the class with the given start time
     * @param startTime a start time to be set as new start time of the course class
     */
    public void setStartTime(LocalTime startTime) {
        if(startTime.isBefore(LocalTime.of(8,0)) 
                || startTime.isAfter(LocalTime.of(18, 0))) {
            throw new IllegalArgumentException("The start time of the class must"
                    + " be from 8am to 6pm");
        } else {
            this.startTime = startTime;
        }
    }

    /**
     * Method that verifies if the maxStudents is within the range of 10-50
     * if yes, it sets the max students variable of the course class to the new 
     * max students number given
     * @param maxStudents a max students number to be set as max students of the
     * class course
     */
    public void setMaxNumberOfStudents(int maxStudents) {
        if(maxStudents >= 10 && maxStudents <= 50) {
            this.maxStudents = maxStudents;
        } else {
            throw new IllegalArgumentException("The maximum number of students"
                    + " must be between 10 and 50");
        }
    }
    
    /**
     * Method that sets the day of class of the course
     * @param courseDay representing the day of class desired for the course
     */
    public void setDayOfClass(DayOfWeek courseDay) {
        if(courseDay.getValue() == DayOfWeek.SATURDAY.getValue() || 
                courseDay.getValue() == DayOfWeek.SUNDAY.getValue()) {
            throw new IllegalArgumentException("The class must be hold in a"
                    + " business day");
        } else {
            this.courseDay = courseDay;
        }
        
    }  
    
    /**
     * Method that add a new student to the course
     * @param student the student to be added to the course
     */
    public void addStudent(Student student) throws InvalidStudentException {
        if(student.inGoodStanding()) {
            if(this.getNumberOfStudentsEnrolled() < this.getMaxNumberOfStudents()) {
                this.students.add(student);
            } else {
                throw new InvalidStudentException("The course is full");
            }
        } else {
            throw new InvalidStudentException("The student isn't in good standing");
        }
    }

    /**
     * Method that returns the number of enrolled students in this course
     * @return an integer representing the number of enrolled students in the 
     * course
     */
    public int getNumberOfStudentsEnrolled() {
        return this.students.size();
    }
    
    /**
     * Method that returns the max number of the students to be enrolled in this
     * course
     * @return an integer representing the max number of students to be enrolled
     * in this course
     */
    public int getMaxNumberOfStudents() {
        return this.maxStudents;
    }
    
    
    
    /**
     * Method that returns the average time students of this course were enrolled
     * at the college
     * @return a double representing the average time the students of this course
     * were enrolled at the college
     */
    public double averageStudentTimeAtCollege() {
        if(this.students.isEmpty()) {
            return 0.0;
        } else {
            int sumOfYears = 0;
            for(Student student : this.students) {
                sumOfYears+= student.getYearsAtCollege();
            }
            return (double) sumOfYears/this.getNumberOfStudentsEnrolled();
            }
    }
    
    /**
     * Method that returns the instructor of the course
     * @return the instructor of the course
     */
    public Instructor getProf() {
        return this.instructor;
    }

    /**
     * Method that returns the course code
     * @return a String representing the course code
     */
    public String getCourseCode() {
        return this.courseCode;
    }
    
    /**
     * Method that returns the course name
     * @return a String representing the course name
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Method that returns the room of the course
     * @return a String representing the room of the course
     */
    public String getRoom() {
        return this.courseRoom;
    }
    
    /**
     * Method that returns the description of the course
     * @return a String representing the description of the course
     */
    public String getDescription() {
        return this.courseDescription;
    }
    
    /**
     * Method that returns the day of class of the course
     * @return a Day of Week object representing the day of class
     */
    public DayOfWeek getDayOfClass() {
        return this.courseDay;
    }
    
    /**
     * Method that returns the startTime of the course
     * @return a LocalTime representing the start time of the course
     */
    public LocalTime getStartTime() {
        return this.startTime;
    }
    
    /**
     * Method that returns the duration of the course
     * @return an integer representing the duration of the course in hours
     */
    public int getDuration() {
        return this.durationInHours;
    }
    
    /**
     * Method that returns the students of the course
     * @return an ArrayList with the student enrolled in the course
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    /**
     * Method that returns the class list of the course
     * @return A string representing the class list of the couse
     */
    public String showClassList() {
        String classList = "";
        int counter = 0;
        for(Student student : students) {
            if(counter == this.getMaxNumberOfStudents()) {
                classList += student.toString();
            } else {
                classList += student.toString()+"\n";
            }
            counter++;
        }
        return classList;
    }
    
    /**
     * Method that returns the course as a String
     * @return a String containing the course name and course code separated by
     * a space
     */
    public String toString() {
        return String.format("%s %s", this.courseName, this.courseCode);
    }
    
}
