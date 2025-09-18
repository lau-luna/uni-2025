public class Main {
  public static void main(String[] args) {
    ColaLE<String> colaImpresion = new ColaLE<>(50);
    
    colaImpresion.enqueue("Trabajo1.txt");
    colaImpresion.enqueue("Trabajo2.pdf");
    colaImpresion.enqueue("Trabajo3.doc");

    System.out.println("Impreso: " + colaImpresion.dequeue());
    System.out.println("Impreso: " + colaImpresion.dequeue());
    System.out.println("Impreso: " + colaImpresion.dequeue());
  }
}
