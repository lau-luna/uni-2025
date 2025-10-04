public class EstadoVariables implements Estado {

  /// Consultar si se puede agregar este atributo y constructor, porque no veo otra forma de poder usar map
  private Mapa variables;

  public EstadoVariables() {
    variables = new Mapa();
  }

  @Override
  public void guardar(char variable, boolean valor) throws IllegalArgumentException {
    if (!"abcdefghijklmnopqrstuvwxyz".contains("" + variable))
      throw new IllegalArgumentException("El nombre de la variable no es valido: " + variable);

    variables.registrar(variable, valor);
  }

  @Override
  public boolean consultar(char variable) throws IllegalArgumentException, IllegalStateException {
    if (!"abcdefghijklmnopqrstuvwxyz".contains("" + variable))
      throw new IllegalArgumentException("El nombre de la variable no es valido: " + variable);

    if (variables.buscarVariable(variable) == -1) {
      throw new IllegalStateException("No existe esa variable");
    }

    return variables.consultar(variable);
  }
  
  /*
  public static void main(String[] args) {
    Estado mapa = new EstadoVariables();
    mapa.guardar('p', true);
    mapa.guardar('r', false); 
    mapa.guardar('q', false); 
    
    System.out.println("p: " + mapa.consultar('p'));
    System.out.println("r: " + mapa.consultar('r'));
    System.out.println("q: " + mapa.consultar('q'));

    
    mapa.guardar('q', true); 
    System.out.println("q: " + mapa.consultar('q'));
    // System.out.println("q: " + mapa.consultar('q'));
  }
  */
}
