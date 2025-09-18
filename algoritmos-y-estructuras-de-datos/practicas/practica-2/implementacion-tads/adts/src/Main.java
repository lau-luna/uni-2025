public class Main {
  public static void main(String[] args) {
    /*
    System.out.println("   === Lista Enlazada ===");
    Lista<Integer> listaEnlazada = new ListaEnlazada<>();
    listTest(listaEnlazada);

    System.out.println("");
    System.out.println("");
    System.out.println("   === Lista Arreglo ===");
    Lista<Integer> listaArreglo = new ListaArreglo<>();
    listTest(listaArreglo);
    */

    /*
    PilaLE<Integer> pilaListaEnlazada = new PilaLE<>();
    System.out.println("");
    System.out.println("");
    stackTest(pilaListaEnlazada);
    */
    
    /*
    PilaLA<Integer> pilaListaArreglo = new PilaLA<>();
    System.out.println("");
    System.out.println("");
    stackTest(pilaListaArreglo);
    */

    System.out.println("   === Cola sobre Lista Enlazada ===");
    ColaLE<String> colaListaEnlazada = new ColaLE<>();
    queueTest(colaListaEnlazada);
    System.out.println("");
    System.out.println("");


    System.out.println("   === Cola sobre Lista Arreglo ===");
    ColaLA<String> colaListaArreglo = new ColaLA<>();
    queueTest(colaListaArreglo);
    System.out.println("");
    System.out.println("");


    System.out.println("   === Cola Circular sobre Arreglo Fijo ===");
    CirQueueLA<Integer> colaCircularListaArreglo = new CirQueueLA<>(4);
    circularQueueTest(colaCircularListaArreglo);
    System.out.println("");
    System.out.println("");
  }

  public static void listTest(Lista<Integer> lista) {
    System.out.println("* Inserto 1, 2, 3, 4, 5 en orden al final");
    lista.insertarFin(1);
    lista.insertarFin(2);
    lista.insertarFin(3);
    lista.insertarFin(4);
    lista.insertarFin(5);
    lista.print();

    System.out.println("* Inserto 0 al inicio");
    lista.insertarInicio(0);
    lista.print();

    System.out.println("* Inserto 10 en la pos 6");
    lista.insertar(10, 6);
    lista.print();

    System.out.println("* Inserto 50 en la pos 0");
    lista.insertar(50, 0);
    lista.print();


    System.out.println("* Elimino el último (" + lista.eliminarUltimo() + ")");
    lista.print();
     
    System.out.println("* Elimino el primero (" + lista.eliminarPrimero() + ")");
    lista.print();

    System.out.println("* Elimino pos 0 (" + lista.eliminarPos(0) + ")");
    lista.print();
 
    System.out.println("* Elimino pos 4 (" + lista.eliminarPos(4) + ")");
    lista.print();

    System.out.println("* Elimino pos 1 (" + lista.eliminarPos(1) + ")");
    lista.print();

    System.out.println("* Inserto 10 en pos 2");
    lista.insertar(10, 2);
 
     
    lista.print();
    System.out.println("- Primer elem: " + lista.obtenerPrimero());
    System.out.println("- Ultimo elem: " + lista.obtenerUltimo());
    System.out.println("- Pos 2: " + lista.obtenerElemPos(2));
    System.out.println("- Pos 0: " + lista.obtenerElemPos(0));
    System.out.println("- Pos 3: " + lista.obtenerElemPos(3));
    System.out.println("");

    System.out.println("10 está en pos: " + lista.buscar(10) );
    System.out.println("4 está en pos: " + lista.buscar(4) );
    System.out.println("500 está en pos: " + lista.buscar(500) );
  }

  public static void stackTest(Pila<Integer> pila) {
    pila.push(5);
    pila.push(6);
    pila.push(7);

    pila.pop();
    pila.pop();

    System.out.println(pila.peek()); // deberia mostrar 5
  }

  public static void queueTest(Cola<String> cola) {
    System.out.println("* Encolo Persona 1, 2, 3, 4 en orden");
    cola.queue("Persona 1");
    cola.queue("Persona 2");
    cola.queue("Persona 3");
    cola.queue("Persona 4");
    cola.print();

    System.out.println("* Desencolo: " + cola.dequeue());
    System.out.println("* Desencolo: " + cola.dequeue());
    cola.print();

    System.out.println("* Vacío la cola");
    cola.clear();
    System.out.println("La cola " + (cola.isEmpty() ? "" : "no ") + "se vació correctamente");
  }

  public static void circularQueueTest(CirQueue<Integer> colaCircular) {
    System.out.println("* Encolo 14");
    colaCircular.enqueue(14);
    colaCircular.print();

    System.out.println("* Encolo 22");
    colaCircular.enqueue(22);
    colaCircular.print();

    System.out.println("* Encolo 20");
    colaCircular.enqueue(20);
    colaCircular.print();
 
    System.out.println("* Desencolo: " + colaCircular.dequeue());  
    colaCircular.print();

    System.out.println("* Encolo 15");
    colaCircular.enqueue(15);
    colaCircular.print();

    System.out.println("* Desencolo: " + colaCircular.dequeue());  
    colaCircular.print();

    System.out.println("* Encolo 4");
    colaCircular.enqueue(4);
    colaCircular.print();

    System.out.println("* Encolo 5");
    colaCircular.enqueue(5);
    colaCircular.print();

  }
}
