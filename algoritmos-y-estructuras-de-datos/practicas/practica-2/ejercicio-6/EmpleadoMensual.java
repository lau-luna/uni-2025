public class EmpleadoMensual extends Empleado {

  /**
   * Class Constructor
   * @pre nombre != null && nombre.length() > 0
   * @pre salarioTotal > 0
   */
  public EmpleadoMensual(String nombre, float salarioTotal) {
    if (nombre == null || nombre.length() == 0) 
      throw new IllegalArgumentException("nombre must'n be null or empty");

    if (salarioTotal <= 0) 
      throw new IllegalArgumentException("salarioTotal must be > 0");

    this.nombre = nombre;
    this.salarioTotal = salarioTotal;
  }
  
  @Override
  public float calcularPago() {
    return super.getSalarioTotal();
  }

}
