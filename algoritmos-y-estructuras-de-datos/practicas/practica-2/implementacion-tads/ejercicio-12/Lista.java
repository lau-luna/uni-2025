public interface Lista<T> {
  /** Inserta un elemento al final de la Lista
   * @param elem El elemento a insertar.
   */
  abstract void insertarFin(T elem);
  
  /** Inserta un elemento al inicio de la lista.
   * @param elem El elemento a insertar.
   */
  abstract void insertarInicio(T elem);

  /** Inserta un elemento en una posición específica
   * @pre La posición debe ser válida (0 <= pos < longitud)
   * @param elem el elemento a insertar
   * @param pos La posición donde se desea insertar el elemento.
   * @throws IndexOutOfBoundsException
   */
  abstract void insertar(T elem, int pos);

  /** Elimina y devuelve el último elemento de la lista.
   * @pre la lista no debe ser vacía
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  abstract T eliminarUltimo();

  /** Elimina y devuelve el primer elemento de la lista.
   * @pre la lista no debe ser vacía
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  abstract T eliminarPrimero();

  /** Elimina el elemento en la posición especificada.
   * @pre la lista no debe ser vacía
   * @pre La posición debe ser válida (0 <= pos < longitud)
   * @return El elemento eliminado
   * @throws IllegalStateException
   */
  abstract T eliminarPos(int pos);

  /** Devuelve el primer elemento de la lista.
   * @pre la lista no debe ser vacía
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  abstract T obtenerPrimero();
  
  /** Devuelve el ultimo elemento de la lista.
   * @pre la lista no debe ser vacía
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  abstract T obtenerUltimo();

  /** Devuelve el elemento de la lista en la posición especificada.
   * @pre la lista no debe ser vacía
   * @return El primer elemento de la lista
   * @throws IllegalStateException
   */
  abstract T obtenerElemPos(int pos);


  /** Retorna la posición en la que se encuentra un elemento o -1 en caso que no se encuentre.
   * @return la posicion en la que se encuentra el elemento en la lista.
   * @return -1 si no se encuentra el elemento en la lista.
   */
  abstract int buscar(T elem);

  /**
   * Retorna la cantidad de elementos que actualmente almacena la lista.
   * @return cantidad de elementos de la lista.
   */
  abstract int longitud();

  /** Retorna verdadero si la lista no contiene elementos, falso en caso contrario.
   * @return true si la lista está vacía
   * @return false si hay al menos un elemento almacenado en la lista.
   */ 
  abstract boolean esVacia();

  /* Imprime por pantalla los elementos de la lista
   */
  abstract void print();
  
}
