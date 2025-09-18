import java.util.LinkedList;
import java.util.Random;

public class RandomList {
  public static LinkedList<Integer> generateRandomList(int n) {
    LinkedList<Integer> list = new LinkedList<>();

    Random rand = new Random();

    for (int i = 0; i < n; i++)
      list.add(rand.nextInt(101));

    return list;
  }
}
