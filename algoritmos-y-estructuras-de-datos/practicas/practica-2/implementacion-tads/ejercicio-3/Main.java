import java.util.ArrayList;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) {
 
  System.out.println("1" + 
    (Pertenece.pertenece(new ArrayList<>(Arrays.asList(1, 2, 3)), 1) ? "" : "no") 
      + " pertenece a " + "[1, 2, 3]"); 

  System.out.println("5" + 
    (Pertenece.pertenece(new ArrayList<>(Arrays.asList(3, 2, 1)), 5) ? "" : " no") 
      + " pertenece a " + "[3, 2, 1]"); 
  }
}
