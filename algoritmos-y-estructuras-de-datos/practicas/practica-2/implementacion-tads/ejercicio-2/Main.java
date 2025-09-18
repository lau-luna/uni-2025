import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = RandomList.generateRandomList(4);

    System.out.println(list.toString());
  }
}
