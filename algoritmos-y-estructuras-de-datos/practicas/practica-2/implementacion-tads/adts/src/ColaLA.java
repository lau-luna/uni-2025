// Queue implementation over my own implementation of Array Lists

import java.util.EmptyStackException;

public class ColaLA<T> implements Cola<T> {
  private ListaArreglo<T> list;
  private int size;
  private final int MAX_QUEUE;

  public ColaLA() {
    this.list = new ListaArreglo<>();
    this.size = 0;
    this.MAX_QUEUE = 10;
  }

  public ColaLA(int MAX_QUEUE) {
    this.list = new ListaArreglo<>();
    this.size = 0;
    this.MAX_QUEUE = MAX_QUEUE;
  }

  /** Places an element at the end of the queue
   * @param elem to be placed
   */
  public void queue(T elem) {
    if (this.size == MAX_QUEUE)
      throw new StackOverflowError();

    this.list.insertarFin(elem);  
    this.size++; 
  }

  /** Deletes the element at the start of the queue
   * @pre !this.isEmpty()
   * @throws EmptyStackException
   */
  public T dequeue() {
    if (this.isEmpty())
      throw new EmptyStackException();

    return this.list.eliminarPrimero();
  }

  /** Checks if the queue is empty
   * @return true if the queue is empty
   */
  public boolean isEmpty() {
    return this.size <= 0;
  }

  /** Removes all elements from the queue
   * @pre !this.isEmpty()
   * @throws EmptyStackException;
   */
  public void clear() {
    if (this.isEmpty())
      throw new EmptyStackException();

    this.list.vaciar();
    this.size = 0;
  }

  /** Prints a representation of the queue
   */
  public void print() {
   this.list.print();
  }
}
