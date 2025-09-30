public class Main {
  public static void main(String[] args) {
    /*
     * (a) ”7 4 − 6 3 + ∗”, resultado esperado : 27
     * (b) ”5 1 2 + 4 ∗ +3 −”, resultado esperado : 14
     * (c) ”3 9 2 + ∗ 8 − 5 /” , resultado esperado : 5
     */

    String exp1 = "7 4 − 6 3 + ∗";
    System.out.println(resolverPostfija(exp1));

    String exp2 = "5 1 2 + 4 ∗ + 3 −";
    System.out.println(resolverPostfija(exp2));

    String exp3 = "3 9 2 + ∗ 8 − 5 /";
    System.out.println(resolverPostfija(exp3));

    //String exp4 = "4 9 2 + ∗s - 5 /";
    //System.out.println(resolverPostfija(exp4));
  }

  public static int resolverPostfija(String exp) {
    int res = 0;
    String[] arr = exp.split(" ");

    System.out.print("[");
    for (String a : arr) {
      System.out.print(a + " ");
    }
    System.out.println("]");

    PilaLE<Integer> numberStack = new PilaLE<>();

    for (int i = 0; i < arr.length; i++) {
      String actual = arr[i];
      // If the actual element is a number, push it to the stack.
      try {
        int actualInteger = Integer.parseInt(actual);
        numberStack.push(actualInteger);
      } catch (Exception e) {
        // Entering here means the character was not a number
        int num1, num2;
        if (numberStack.isEmpty())
          throw new IllegalStateException(arr[i] + " is not a valid character");
        num2 = numberStack.pop();

        if (numberStack.isEmpty())
          throw new IllegalStateException(arr[i] + " is not a valid character");
        num1 = numberStack.pop();

        switch (actual) {
          case "+":
            res = num1 + num2;
            break;

          case "-", "−":
            res = num1 - num2;
            break;

          case "*", "∗":
            res = num1 * num2;
            break;

          case "/":
            res = num1 / num2;
            break;

          default:
            throw new IllegalStateException(actual + " is not a valid character");
        }

        numberStack.push(res);
      }
    }

    res = numberStack.pop();

    if (!numberStack.isEmpty())
      throw new IllegalStateException("The expression given is unbalanced");

    return res;

  }
}
