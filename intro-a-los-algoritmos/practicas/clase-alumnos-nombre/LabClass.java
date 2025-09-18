import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class LabClass
{
    private String name;
    private ArrayList<Student> students;
    private ArrayList<NameCount> list;
    private int capacity;
    
    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */
    public LabClass(int maxNumberOfStudents, String name)
    {
        this.name = name;
        this.students = new ArrayList<Student>();
        this.capacity = maxNumberOfStudents;
    }

    public void enrrollStudent(Student newStudent){
        if(students.size() >= this.capacity){
            System.out.println("Max student capacity has been reached.");
        }else{
            this.students.add(newStudent);
        }
    }

    public void printList(){
        System.out.println("Class: " + this.name);
        int studentId = 1;
        for(Student student : this.students){
            System.out.println(studentId + ": " + student.getName());
            studentId++;
        }
    }

    public String getMostCommonName(){
        assert this.students.size() == 0 : "There's no students enrolled in this class.";  
        for(Student student : this.students){
            studentCount = new ArrayList<NameCout>(this.student.getName(), this.student.);
            if (this.students.getName()){

            }


        }
    }
}
