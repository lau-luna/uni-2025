public class EvaluadorPrefijo implements Evaluador {

  private Estado estado;

  public EvaluadorPrefijo() {
    this.estado = new EstadoVariables();
  }

  /**
   * Método auxiliar que debe dividir la expresión general en los tokens más
   * pequeños. un token es cada unidad mínima significativa que compone la
   * expresión. (Usar espacio como separador, en caso de múltiples espacios
   * seguidos deben ignorarse)
   *
   * Ejemplo de uso:
   * tokenizarExpresion("AND p q") = ["AND", "p", "q"]
   * tokenizarExpresion("AND p OR q b") = ["AND", "p", "OR", "q", "b"]
   * tokenizarExpresion(" AND p q ") = ["AND", "p", "q"]
   * 
   * @param expresion Expresión a tokenizar
   * @return Arreglo de string que representan cada token de la expresión
   */
  private static String[] tokenizarExpresion(String expresion) {
    if (expresion == null || expresion.trim().isEmpty()) {
      throw new IllegalStateException("La expresion no puede ser null o vacia");
    }

    String[] arr = expresion.trim().split(" ");
    return arr;
  }

  /**
   * Valida si una secuencia de tokens es válida.
   * Solo se deben permitir los siguientes tokens:
   * AND, OR, NOT, nombres de variables en el rango [a-z]
   * 
   * @param tokens Listado de tokens a validar
   * @return true si la secuencia es válida, false si la secuencia tiene al menos
   *         un token no permitido
   */
  private boolean validarTokens(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return false;
    }
    String variableP = "abcdefghijklmnopqrstuvwxyz";

    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];

      if (token.length() > 1) {
        if (!token.equals("AND") && !token.equals("OR") && !token.equals("NOT"))
          return false;
      } else {
        if (!variableP.contains(token))
          return false;
      }

    }
    return true;
  }

  @Override
  public void setEstado(Estado variables) {
    this.estado = variables;
  }

  @Override
  public boolean evaluar(String expresionEnPrefija) throws IllegalArgumentException, IllegalStateException {
    String[] tokens = tokenizarExpresion(expresionEnPrefija);
    if (!validarTokens(tokens)) {
      throw new IllegalArgumentException("La expresión a evaluar no es válida.");
    }

    boolean res = false;

    PilaDoblementeEnlazada<Boolean> pila = new PilaDoblementeEnlazada<>();
    // ["AND", "p", "q"] <-

    for (int i = tokens.length - 1; i >= 0; i--) {
      if (tokens[i].equals("AND") || tokens[i].equals("OR") || tokens[i].equals("NOT")) {
        Boolean valor2, valor1;

        switch (tokens[i]) {
          case "AND", "OR":
            if (pila.esVacia())
              throw new IllegalStateException("Expresión desbalanceada.");

            valor2 = pila.tope();
            pila.desapilar();

            if (pila.esVacia())
              throw new IllegalStateException("Expresión desbalanceada.");

            valor1 = pila.tope();
            pila.desapilar();

            res = tokens[i].equals("AND") ? valor1 && valor2 : valor1 || valor2;
            pila.apilar(res);
            break;
          case "NOT":
            if (pila.esVacia())
              throw new IllegalStateException("Expresión desbalanceada.");

            valor1 = pila.tope();
            pila.desapilar();

            res = !valor1;
            pila.apilar(res);
            break;
          default:
            throw new IllegalStateException(tokens[i] + "Es un operador inválido.");
        }
      } else {
        pila.apilar(estado.consultar(tokens[i].charAt(0)));
      }

    }

    pila.desapilar();

    if (!pila.esVacia())
      throw new IllegalStateException("Expresión desbalanceada.");

    return res;
  }

  public static void main(String[] args) {
    Estado e = new EstadoVariables();
    e.guardar('p', true);
    e.guardar('q', false);
    e.guardar('r', true);

    Evaluador eval = new EvaluadorPrefijo();
    eval.setEstado(e);

    System.out.println("p:" + e.consultar('p'));
    System.out.println("q:" + e.consultar('q'));

    System.out.println(eval.evaluar("AND p q")); // Según el estado e debería retornar false
    System.out.println(eval.evaluar("OR p q")); // Según el estado e debería retornar true
    System.out.println(eval.evaluar("AND p OR q r")); // debe ser true AND true OR false true

    System.out.println(eval.evaluar("AND NOT q q")); // "AND NOT false false" //false
    System.out.println(eval.evaluar("OR r AND NOT p q")); // "OR true AND NOT true false" //true

  }

}
