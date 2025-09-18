// Stack implementation over my own implementation of LinkedLists

import java.util.EmptyStackException;

public class PilaLE<T> implements Pila<T> {
  private ListaEnlazada<T> lista;
  private int MAX_STACK;
  private int size;

  public PilaLE() {
    this.lista = new ListaEnlazada<>();
    this.MAX_STACK = 100;
    this.size = 0;
  }

  public PilaLE(int MAX_STACK) {
    this.lista = new ListaEnlazada<>();
    this.MAX_STACK = MAX_STACK;
    this.size = 0;
  }

  /** Places an element on the top of the Stack
   * @param item to push to the top of the stack
   */
  public void push(T item) {
    if (this.size == MAX_STACK)
      throw new StackOverflowError();

    lista.insertarInicio(item);
    this.size++;
  }

  /** Removes the element placed at the top of the stack and returns it.
   * @pre !this.isEmpty()
   * @return the removed element
   */
  public T pop() {
    if (this.isEmpty())
      throw new EmptyStackException();

    this.size--;

    return this.lista.eliminarPrimero();
  }

  /** Returns the element placed at the top of the stack, but does not remove it
   * @pre !this.isEmpty()
   * @return the element placed at the top of the stack.
   */
  public T peek() {
    if (this.isEmpty())
      throw new EmptyStackException();

    return this.lista.obtenerPrimero();
  }

  /** Checks if the stack is isEmpty
   * @return true if there isn't any elements inside the stack
   */
  public boolean isEmpty() {
    return this.size <= 0;
  }

  /** Removes all elements placed in the stack, if it's not empty.
   * @pre !this.isEmpty()
   */
  public void clear() {
    if (this.isEmpty())
      throw new EmptyStackException();

    this.lista.vaciar();
    this.size = -1;
  }


}
