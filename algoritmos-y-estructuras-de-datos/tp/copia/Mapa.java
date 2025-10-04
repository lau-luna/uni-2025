public class Mapa {
  private Character[] variables;
  private Boolean[] valores;
  private int contadorVariables, contadorValores;

  public Mapa() {
    this.variables = new Character[26];
    this.valores = new Boolean[26];
    this.contadorVariables = 0;
    this.contadorValores = 0;
  }

  /**
   * Mapea una variable caracter a un valor booleano.
   * Si la variable ya estaba registrada, sobreescribe su valor.
   * 
   * @pre var debe ser un caracter en el rango [a-z]
   * @throws IllegalArgumentException si la variable no es un caracter entre [a-z]
   */
  public void registrar(char var, boolean valor) {
    if (!"abcdefghijklmnopqrstuvwxyz".contains("" + var))
      throw new IllegalArgumentException("El nombre de la variable no es valido: " + var);
    
    // Variable ya registrada
    if (this.buscarVariable(var) != -1) {
      valores[this.buscarVariable(var)] = valor; 
    } else {
      // Variable no registrada
      variables[this.contadorVariables++] = var;
      valores[this.contadorValores++] = valor;
    }
  }

  /**
   * Devuelve el valor booleano de una variable registrada.
   * 
   * @pre var debe ser un caracter en el rango [a-z]
   * @throws IllegalArgumentException si la variable no es un caracter entre [a-z]
   * @throws IllegalStateException si se quiere consultar una variable no registrada
   */
  public boolean consultar(char var) {
    if (!"abcdefghijklmnopqrstuvwxyz".contains("" + var))
      throw new IllegalArgumentException("El nombre de la variable no es valido: " + var);
   
    if (this.buscarVariable(var) == -1)
      throw new IllegalStateException("Variable no registrada");

    return valores[this.buscarVariable(var)];
  }

  /**
   * Busca si una variable está registrada y devuelve su posición o -1 si no la
   * encuentra
   * 
   * @return posicion de la variable o -1 si no la encuentra
   * @pre var debe ser un caracter en el rango [a-z]
   * @throws IllegalArgumentException si la variable no es un caracter entre [a-z]
   */
  public int buscarVariable(char var) {
    if (!"abcdefghijklmnopqrstuvwxyz".contains("" + var))
      throw new IllegalArgumentException("El nombre de la variable no es valido: " + var);

    for (int i = 0; i < this.contadorVariables; i++) {
      if (this.variables[i] == var) {
        return i;
      }
    }
    return -1;
  }

  /*
  public static void main(String[] args) {
    Mapa mapa = new Mapa();
    mapa.registrar('p', true);
    mapa.registrar('r', false);
    
    System.out.println("r está en pos: " + mapa.buscarVariable('p'));
    System.out.println("r está en pos: " + mapa.buscarVariable('r'));
    
    System.out.println("p: " + mapa.consultar('p'));
    System.out.println("r: " + mapa.consultar('r'));
    // System.out.println("q: " + mapa.consultar('q'));
  }
  */

}
