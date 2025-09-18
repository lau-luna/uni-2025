public class EmpleadoPorHora extends Empleado {
  private float horasTrabajadas;
  private float tarifaPorHora;

  public EmpleadoPorHora(String nombre, float horasTrabajadas, float tarifaPorHora) {
    this.nombre = nombre;
    this.horasTrabajadas = horasTrabajadas;
    this.tarifaPorHora = tarifaPorHora;
  }

  public float getHorasTrabajadas() {
    return horasTrabajadas;
  }
    
  public float getTarifaPorHora() {
    return tarifaPorHora;
  }
  
  @Override
  public float calcularPago() {
    return this.horasTrabajadas * this.tarifaPorHora;
  }
}
