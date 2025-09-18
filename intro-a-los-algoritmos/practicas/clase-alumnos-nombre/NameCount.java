
/**
 * Write a description of class NameCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NameCount
{
    // instance variables - replace the example below with your own
    private String name;
    private int count;

    /**
     * Constructor for objects of class NameCount
     */
    public NameCount(String name, int count)
    {
        this.name = name;
        this.count = count;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    } 

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }
}
