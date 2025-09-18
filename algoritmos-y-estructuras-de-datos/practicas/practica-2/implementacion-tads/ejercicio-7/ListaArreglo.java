public class ListaArreglo<T> implements Lista<T> {
  private T[] arr;

  @SuppressWarnings("unchecked")
  public ListaArreglo() {
    this.arr = (T[]) new Object[0];
  }

  @SuppressWarnings("unchecked")
  public ListaArreglo(int lenght) {
    this.arr = (T[]) new Object[lenght]; // Casting porque no se puede hacer directamente un arreglo de T[]
  }

  /**
   * Inserta un elemento al final de la Lista
   * 
   * @param elem El elemento a insertar.
   */
  @SuppressWarnings("unchecked")
  public void insertarFin(T elem) {
    T[] arrAux = (T[]) new Object[this.arr.length + 1];

    for (int i = 0; i < arr.length; i++)
      arrAux[i] = this.arr[i];

    arrAux[arrAux.length - 1] = elem;

    this.arr = arrAux;
  }

  /**
   * Inserta un elemento al inicio de la lista.
   * 
   * @param elem El elemento a insertar.
   */
  @SuppressWarnings("unchecked")
  public void insertarInicio(T elem) {
    T[] arrAux = (T[]) new Object[this.arr.length + 1];

    for (int i = 1; i < arrAux.length; i++)
      arrAux[i] = this.arr[i-1];

    arrAux[0] = elem;

    this.arr = arrAux;
  }

  /**
   * Inserta un elemento en una posición específica
   * 
   * @pre La posición debe ser válida (0 <= pos < longitud)
   * @param elem el elemento a insertar
   * @param pos  La posición donde se desea insertar el elemento.
   * @throws IndexOutOfBoundsException
   */
  // TODO: checkear
  @SuppressWarnings("unchecked")
  public void insertar(T elem, int pos) {
    if (pos < 0 || pos > this.arr.length)
      throw new IllegalArgumentException("posición inválida");

    T[] arrAux = (T[]) new Object[this.arr.length + 1];

    if (pos == 0) {
      insertarInicio(elem);
    } else if (pos == this.arr.length) {
      insertarFin(elem);
    } else {
      for (int i = 0; i < pos; i++)
        arrAux[i] = this.arr[i];

      arrAux[pos] = elem;

      for (int i = pos + 1; i < arrAux.length; i++)
        arrAux[i] = this.arr[i-1];

      this.arr = arrAux;
    }
  }

  /**
   * Elimina y devuelve el último elemento de la lista.
   * 
   * @pre la lista no debe ser vacía
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  // TODO: checkear
  @SuppressWarnings("unchecked")
  public T eliminarUltimo() {
    if (esVacia())
      throw new IllegalStateException("lista vacía");

    T[] arrAux = (T[]) new Object[this.arr.length - 1];
    T elemEliminado = this.arr[this.arr.length - 1];

    for (int i = 0; i < arrAux.length; i++)
      arrAux[i] = this.arr[i];

    this.arr = arrAux;

    return elemEliminado;
  }

  /**
   * Elimina y devuelve el primer elemento de la lista.
   * 
   * @pre la lista no debe ser vacía
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  @SuppressWarnings("unchecked")
  public T eliminarPrimero() {
    if (esVacia())
      throw new IllegalStateException("lista vacía");

    T[] arrAux = (T[]) new Object[this.arr.length - 1];
    T elemEliminado = this.arr[0];

    for (int i = 1; i < this.arr.length; i++)
      arrAux[i - 1] = this.arr[i];

    this.arr = arrAux;

    return elemEliminado;
  }

  /**
   * Elimina el elemento en la posición especificada.
   * 
   * @pre la lista no debe ser vacía
   * @pre La posición debe ser válida (0 <= pos < longitud)
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  @SuppressWarnings("unchecked")
  public T eliminarPos(int pos) {
    if (esVacia())
      throw new IllegalStateException("lista vacía");

    if (pos < 0 || pos > this.arr.length)
      throw new IllegalArgumentException("posicion invalida");

    T elemEliminado = this.arr[pos];
    T[] arrAux = (T[]) new Object[this.arr.length - 1];

    for (int i = 0; i < pos; i++)
      arrAux[i] = this.arr[i];

    for (int i = pos + 1; i < this.arr.length; i++)
      arrAux[i - 1] = this.arr[i];

    this.arr = arrAux;

    return elemEliminado;
  }

  /**
   * Devuelve el primer elemento de la lista.
   * 
   * @pre la lista no debe ser vacía
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  public T obtenerPrimero() {
    if (esVacia())
      throw new IllegalStateException("lista vacia");
    return this.arr[0];
  }

  /**
   * Devuelve el ultimo elemento de la lista.
   * 
   * @pre la lista no debe ser vacía
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  // TODO: chekear
  public T obtenerUltimo() {
    if (esVacia())
      throw new IllegalStateException("lista vacia");
    return this.arr[this.arr.length - 1];
  }

  /**
   * Devuelve el elemento de la lista en la posición especificada.
   * 
   * @pre la lista no debe ser vacía
   * @pre La posición debe ser válida (0 <= pos < longitud)
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  // TODO:checkear
  public T obtenerElemPos(int pos) {
    if (esVacia())
      throw new IllegalStateException("lista vacia");

    if (pos < 0 || pos > this.arr.length)
      throw new IllegalArgumentException("posicion invalida");

    return this.arr[pos];
  }

  /**
   * Retorna la posición en la que se encuentra un elemento o -1 en caso que no se
   * encuentre.
   * 
   * @return la posicion en la que se encuentra el elemento en la lista.
   * @return -1 si no se encuentra el elemento en la lista.
   */
  // TODO: checkear
  public int buscar(T elem) {
    for (int i = 0; i < this.arr.length; i++)
      if (this.arr[i].equals(elem))
        return i;

    return -1;
  }

  /**
   * Retorna la cantidad de elementos que actualmente almacena la lista.
   * 
   * @return cantidad de elementos de la lista.
   */
  public int longitud() {
    return this.arr.length;
  }

  /**
   * Retorna verdadero si la lista no contiene elementos, falso en caso contrario.
   * 
   * @return true si la lista está vacía
   * @return false si hay al menos un elemento almacenado en la lista.
   */
  public boolean esVacia() {
    return this.arr.length == 0;
  }

  /*
   * Imprime por pantalla los elementos de la lista
   */
  public void print() {
    System.out.println("Longitud: " + this.arr.length);
    System.out.print("[");

    for (int i = 0; i < this.arr.length; i++) {
      System.out.print(this.arr[i].toString() + (i == this.arr.length - 1 ? "" : ", "));
    }

    System.out.println("]");
    System.out.println("");
  }

  // Elimina todos los elementos de la lista y la deja vacía
  @SuppressWarnings("unchecked")
  public void vaciar() {
    this.arr = (T[]) new Object[0];
  }
}
