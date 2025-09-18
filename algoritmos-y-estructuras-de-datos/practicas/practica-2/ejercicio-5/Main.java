import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Circulo c1 = new Circulo(5);
    System.out.println("\n=== Circulo 1 ===");
    System.out.println("Radio: " + c1.getRadio());
    System.out.println("Area: " + c1.area());
    System.out.println("Perimetro: " + c1.perimetro());

    Rectangulo r1 = new Rectangulo(10, 10);
    System.out.println("\n=== Rectangulo 1 ===");
    System.out.println("Alto: " + r1.getAncho() + ". Ancho: " + r1.getAlto());
    System.out.println("Area: " + r1.area());
    System.out.println("Perimetro: " + r1.perimetro());

    Triangulo t1 = new Triangulo(3, 4, 3, 4, 5) ;
    System.out.println("\n=== Triangulo 1 ===");
    System.out.println("Base: " + t1.getBase() + ". Altura: " + t1.getAltura());
    System.out.println("Lado 1: " + t1.getLado1() + ". Lado 2: " + t1.getLado2() + ". Lado 3: " + t1.getLado3());
    System.out.println("Area: " + t1.area());
    System.out.println("Perimetro: " + t1.perimetro());

    
    System.out.println("\n=== Polimorfismo ===");
    ArrayList<Figura> figuras = new ArrayList<>();
    figuras.add(c1);
    figuras.add(r1);
    figuras.add(t1);

    int totalArea = 0;

    for (Figura f : figuras) {
      totalArea += f.area();
    }
    
    System.out.println("El area total es: " +  totalArea);
  }
}
