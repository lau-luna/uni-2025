import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    listaEmpleados.add(new EmpleadoMensual("Lautaro Luna", 1000000));
    listaEmpleados.add(new EmpleadoMensual("Lucio Gomez", 2100000));
    listaEmpleados.add(new EmpleadoPorHora("Juan Perez", 10, 7000));
    listaEmpleados.add(new EmpleadoPorHora("John Doe", 6, 9000));

    System.out.println(" === Lista de empleados ===");
    for (Empleado e : listaEmpleados) {
      System.out.println(e.getNombre());
      System.out.println( (e instanceof EmpleadoPorHora ? "Horas: " + ((EmpleadoPorHora) e).getHorasTrabajadas() + ". Tarifa x hora: " + ((EmpleadoPorHora) e).getTarifaPorHora() : "") ); // Epic casting
      System.out.println("Pago: $" + e.calcularPago());
      System.out.println("------------------------");
    }
  }
}
