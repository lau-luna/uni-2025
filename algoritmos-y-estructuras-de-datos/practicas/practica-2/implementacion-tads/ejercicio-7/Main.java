public class Main {
  public static void main(String[] args) {
    String[] expresiones = { "(3 + 4) * 2",
        "20 + ( 10",
        "((10 * 2) + 5",
        "(45 / 7) + (30 - 2)" };

    for (String expresion : expresiones) {
      System.out.println(expresion + (isBalanced(expresion) ? " " : " no") + " está balanceada");
    }
  }

  public static boolean isBalanced(String mathExpression) {
    if (mathExpression.trim().isEmpty())
      throw new IllegalArgumentException("Expresión vacía");

    PilaLE<Character> stack = new PilaLE<>();
    for (int i = 0; i < mathExpression.length(); i++) {
      if (mathExpression.charAt(i) == '(') {
        stack.push(mathExpression.charAt(i));
      } else if (mathExpression.charAt(i) == ')') {
        stack.pop();
      }
    }

    return stack.isEmpty();
  }

}
