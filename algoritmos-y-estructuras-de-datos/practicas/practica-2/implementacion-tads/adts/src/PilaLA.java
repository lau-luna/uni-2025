// Stack implementation over my own implementation of ArrayLists

import java.util.EmptyStackException;

public class PilaLA<T> implements Pila<T>  {
  private ListaArreglo<T> lista;
  private int top;
  private int MAX_STACK;

  // Creates an empty stack with a default size of 10.
  public PilaLA() {
    this.lista = new ListaArreglo<>();
    this.top = -1;
    this.MAX_STACK = 10;
  }

  /** Creates an empty stack with a specified size.
   * @param size of the stack to be created.
   * @pre size > 0
   * @throws IllegalArgumentException
   */
  public PilaLA(int size) {
    if (size <= 0)
      throw new IllegalArgumentException("size must be > 0");

    this.lista = new ListaArreglo<>(size);
    this.top = -1;
    this.MAX_STACK = size;
  }
  
  /** Places an element on the top of the Stack
   * @param item to push to the top of the stack
   * @throws StackOverflowError if the stack is full
   */
  // TODO: check
  public void push(T item) {
    this.lista.insertar(item, ++this.top);
  }

  /** Removes the element placed at the top of the stack and returns it.
   * @pre !this.isEmpty()
   * @return the removed element
   * @throws java.util.EmptyStackException if the stack is empty
   */
  // TODO: check
  public T pop() {
    return this.lista.eliminarPos(this.top--);
  }

  /** Returns the element placed at the top of the stack, but does not remove it
   * @pre !this.isEmpty()
   * @return the element placed at the top of the stack.
   * @throws java.util.EmptyStackException if the stack is empty
   */
  // TODO: check
  public T peek() {
    if (this.isEmpty())
      throw new EmptyStackException();

    return this.lista.obtenerElemPos(this.top);
  }

  /** Checks if the stack is isEmpty
   * @return true if there isn't any elements inside the stack
   */
  public boolean isEmpty() {
    return this.lista.esVacia();
  }

  /** Removes all elements placed in the stack, if it's not empty.
   * @pre !this.isEmpty()
   * @throws java.util.EmptyStackException if the stack is empty
   */
  public void clear() {
    this.top = -1;
    this.lista.vaciar();
  }
}
