import java.util.List;

public class Pertenece {
  /**
   * @return true if n is found on list
   * @precondition list must not be null or emptyy
   */
  public static boolean pertenece(List<Integer> list, int n) {
    if (list == null || list.isEmpty())
      throw new IllegalArgumentException("list is empty or null");

    boolean found = false;

    for (int i = 0; i < list.size() && !found; i++)
      if (list.get(i) == n)
        found = true;
  
    return found;
  }
}
