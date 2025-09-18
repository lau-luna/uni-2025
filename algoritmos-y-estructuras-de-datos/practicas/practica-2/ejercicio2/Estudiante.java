public class Estudiante extends Persona {
  private boolean esRegular;
  private float promedio;
  private int cantidadMateriasAprobadas;
  private int cantidadMateriasTotal;
  private float sumaDeNotas;


  public Estudiante() {
    this.esRegular = false;
    this.promedio = 0;
    this.cantidadMateriasAprobadas = 0;
  }

  public Estudiante(int dni, String nombre, String  apellido, boolean esRegular) {
    super(dni, nombre, apellido);
    this.esRegular = esRegular;
    this.promedio = 0;
    this.cantidadMateriasAprobadas = 0;
    this.cantidadMateriasTotal = 0;
    this.sumaDeNotas = 0;
  }

  // Getters
  public boolean getEsRegular() {
    return this.esRegular;
  }

  public float getPromedio() {
    return this.promedio;
  }

  public int getCantidadMateriasAprobadas() {
    return this.cantidadMateriasAprobadas;
  }

  
  /// Métodos
  public void print() {
    super.print();
    System.out.println("  * " + (this.esRegular ? "Es" : "No es") + " regular.");
    System.out.println("  * Promedio: " + this.promedio);
    System.out.println("  * Materias aprobadas: " + this.cantidadMateriasAprobadas);
  }
  
  @Override
  public String getInfo() {
    return super.getInfo() + "\n" + "  * " + (this.esRegular ? "Es" : "No es") + " regular." + "  * Promedio: " + this.promedio + "\n" + "  * Materias aprobadas: " + this.cantidadMateriasAprobadas;
  }

  /**
   * actualiza su promedio y la cantintidad de materias aprobadas
   */
  public void aproboMateria(int nota) {
    this.cantidadMateriasTotal++;

    if (nota >= 5)
      this.cantidadMateriasAprobadas++;

    this.sumaDeNotas = this.sumaDeNotas + nota;

    this.promedio = this.sumaDeNotas / this.cantidadMateriasTotal; 
  }
}
