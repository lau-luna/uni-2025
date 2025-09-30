public class Main {
  public static void main(String[] args) {
    char var = '1';

    if (!"abcdefghijklmnopqrstuvxyz".contains(""+var)) 
      throw new IllegalArgumentException("caca");
    
  }
}
