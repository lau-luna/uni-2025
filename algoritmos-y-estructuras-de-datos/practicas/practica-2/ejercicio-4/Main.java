import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Caja<Integer> cajaEntero = new Caja<>();
    cajaEntero.guardar(100);
    cajaEntero.mostrarInfo();


    Caja<String> cajaString = new Caja<>();
    cajaString.guardar("Hola");
    cajaString.mostrarInfo();

    Caja<Persona> cajaPersona = new Caja<>();
    cajaPersona.guardar(new Persona(1390890, "Lautaro", "Luna"));
    cajaPersona.mostrarInfo();

    System.out.println("\n\n==== Lista de cajas ====");

    ArrayList<Caja<?>> listaCajas = new ArrayList<>();
    listaCajas.add(cajaEntero);
    listaCajas.add(cajaString);
    listaCajas.add(cajaPersona);

    for (Caja<?> caja : listaCajas) {
      Object contenido = caja.obtener();
      System.out.println(contenido.toString());
    }
  }
}
