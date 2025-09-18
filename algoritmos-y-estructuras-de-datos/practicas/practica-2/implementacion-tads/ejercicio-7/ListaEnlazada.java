public class ListaEnlazada<T> implements Lista<T> {
  private Nodo<T> cabeza;
  private int longitud;

  // Crea una lista vacía, cabeza apunta a null;
  public ListaEnlazada() {
    this.cabeza = null;
    this.longitud = 0;
  }

  @Override
  public void insertarFin(T elem) {
    Nodo<T> nodoAInsertar = new Nodo<>(elem);

    // Lista vacía
    if (cabeza == null) {
      cabeza = nodoAInsertar;
    } else {
      Nodo<T> auxiliar = cabeza;

      while (auxiliar.getNext() != null) {
        auxiliar = auxiliar.getNext();
      }

      auxiliar.setNext(nodoAInsertar);
    }

    this.longitud++;
  }

  @Override
  public void insertarInicio(T elem) {
    Nodo<T> nodoAInsertar = new Nodo<>(elem);

    nodoAInsertar.setNext(cabeza);
    cabeza = nodoAInsertar;

    this.longitud++;
  }

  @Override
  public void insertar(T elem, int pos) {
    if (pos < 0 || pos > this.longitud)
      throw new IllegalArgumentException("Posicion fuera de rango");

    if (elem == null)
      throw new IllegalArgumentException("elem es null");

    if (pos == 0) {
      insertarInicio(elem);
      return;

    } else if (pos == this.longitud) {
      insertarFin(elem);
      return;
    }

    Nodo<T> nodoAInsertar = new Nodo<>(elem);
    Nodo<T> auxiliar = cabeza;

    for (int i = 0; i < pos - 1; i++) {
      auxiliar = auxiliar.getNext();
    }

    nodoAInsertar.setNext(auxiliar.getNext());
    auxiliar.setNext(nodoAInsertar);

    this.longitud++;
  }

  @Override
  public T eliminarUltimo() {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    Nodo<T> auxiliar = cabeza;
    T elemEliminado;

    if (this.longitud() == 1) {
      elemEliminado = auxiliar.getInfo();
      eliminarPrimero();
    } else {
      for (int i = 0; i < this.longitud - 2; i++)
        auxiliar = auxiliar.getNext();

      elemEliminado = auxiliar.getNext().getInfo();

      auxiliar.setNext(null);
    }

    this.longitud--;
    return elemEliminado;
  }

  @Override
  public T eliminarPrimero() {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    T elemEliminado;

    if (this.longitud == 1) {
      elemEliminado = cabeza.getInfo();
      cabeza = null;
    } else {
      elemEliminado = cabeza.getInfo();
      cabeza = cabeza.getNext();
    }

    this.longitud--;
    return elemEliminado;
  }

  @Override
  public T eliminarPos(int pos) {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    if (pos == 0) {
      return eliminarPrimero();
    } else if (pos == this.longitud - 1) {
      return eliminarUltimo();
    } else {
      Nodo<T> auxiliar = cabeza;
      T elemEliminado;

      for (int i = 0; i < pos - 1 ; i++)
        auxiliar = auxiliar.getNext();

      elemEliminado = auxiliar.getInfo();
      auxiliar.setNext(auxiliar.getNext().getNext());

      this.longitud--;
      return elemEliminado;
    }
  }

  @Override
  public T obtenerPrimero() {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    return cabeza.getInfo();
  }

  @Override
  public T obtenerUltimo() {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    if (this.longitud == 1) {
      return obtenerPrimero();
    } else {
      Nodo<T> auxiliar = cabeza;

      for (int i = 0; i < this.longitud - 1; i++)
        auxiliar = auxiliar.getNext();

      return auxiliar.getInfo();
    }
  }

  @Override
  public T obtenerElemPos(int pos) {
    if (esVacia())
      throw new IllegalStateException("La lista está vacía");

    if (pos < 0 || pos >= this.longitud)
      throw new IllegalArgumentException("posición inválida");

    if (pos == 0) {
      return obtenerPrimero();
    } else if (pos == this.longitud - 1) {
      return obtenerUltimo();
    } else {
      Nodo<T> auxiliar = cabeza;

      for (int i = 0; i < pos; i++) 
        auxiliar = auxiliar.getNext();

      return auxiliar.getInfo();
    }
  }

  @Override
  public int buscar(T elem) {    
    Nodo<T> auxiliar = cabeza;
    for (int i = 0; i < this.longitud; i++) {
      if (auxiliar.getInfo() == elem)
        return i;

      auxiliar = auxiliar.getNext();
    } 

    return -1;
  }

  @Override
  public boolean esVacia() {
    return this.cabeza == null;
  }

  @Override
  public int longitud() {
    return this.longitud;
  }

  @Override
  public void print() {
    Nodo<T> auxiliar = cabeza;

    System.out.println("Longitud: " + this.longitud);
    System.out.print("[");

    for (int i = 0; i < this.longitud; i++) {
      System.out.print(auxiliar.getInfo().toString() + (auxiliar.getNext() == null ? "" : ", ") );
      auxiliar = auxiliar.getNext();
    }

    System.out.println("]");
    System.out.println("");
  }

  public void vaciar() {
    this.cabeza = null;
  }
}
