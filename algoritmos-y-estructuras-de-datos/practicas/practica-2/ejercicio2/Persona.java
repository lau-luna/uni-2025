public class Persona {
  private int dni;
  private String nombre;
  private String apellido;
  
  public Persona() {
    this.dni = -1;
    this.nombre = "";
    this.apellido = "";
  }

  public Persona(int dni, String nombre, String apellido) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  /// Getters
  public int getDni() {
    return this.dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getApellido() {
    return this.apellido;
  }


  /// Setters
  public void setDni(int dni) {
    this.dni = dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }


  /// Métodos
  public void print() {
    System.out.println("-----------------------------------");
    System.out.println("  * DNI: " + this.dni);
    System.out.println("  * Nombre: " + this.nombre);
    System.out.println("  * Apellido: " + this.apellido);
  }

  public String getInfo() {
    return "-------------------------------------" + "\n" + "  * DNI: " + this.dni + "\n" + "  * Nombre: " + this.nombre + "\n" + "  * Apellido: " + this.apellido;
  }
}
