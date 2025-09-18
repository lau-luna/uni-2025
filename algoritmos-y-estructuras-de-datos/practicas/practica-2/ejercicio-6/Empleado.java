public abstract class Empleado {
  /**
   * @field nombre; es el nombre del empleado.
   * @field salarioTotal; es el salario total de 12 meses del empleado.
   */
  protected String nombre;
  protected float salarioTotal; 

  public String getNombre() {
    return this.nombre;
  }

  public float getSalarioTotal() {
    return this.salarioTotal;
  }
  
  abstract float calcularPago();

}
