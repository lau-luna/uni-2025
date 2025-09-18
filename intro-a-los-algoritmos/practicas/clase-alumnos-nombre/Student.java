
/**
 * Just a Student.
 *
 * @author (Lautaro Luna)
 * @version (a version number or a date)
 */
public class Student
{
    // Student's name, not including surname
    private String name;

    /**
     * Constructor for objects of class Student
     */
    public Student(String name)
    {
        this.name = name;
    }

    /**
     * Change name
     */
    public void setName(String name){
        this.name = name;
    }

    /*
     * Return the name
     */

    public String getName(){
        return this.name;
    }
}
