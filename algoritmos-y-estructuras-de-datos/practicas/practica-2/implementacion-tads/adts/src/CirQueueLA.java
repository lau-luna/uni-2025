// Circular Queue implementation over my own implementation of Array Lists
// Using static memory

public class CirQueueLA<T> implements CirQueue<T> {
  private T[] arr;
  private int front, rear, size, capacity;

  // Empty class constructor that defines a queue with default capacity of 10
  // elements.
  @SuppressWarnings("unchecked")
  public CirQueueLA() {
    this.arr = (T[]) new Object[10];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
    this.capacity = 10;
  }

  /**
   * Class constructor that defines a queue with a specificed capacity
   * 
   * @param capacity of the queue
   * @pre capacity > 0
   * @throws IllegalArgumentException
   */
  @SuppressWarnings("unchecked")
  public CirQueueLA(int capacity) {
    if (capacity <= 0)
      throw new IllegalArgumentException("capacity must be >= 1");

    this.arr = (T[]) new Object[capacity];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
    this.capacity = capacity;
  }

  /**
   * Inserts element on the rear of the queue, Then increments the size by 1.
   * 
   * @pre !this.isFull()
   * @throws IllegalStateException
   */
  public void enqueue(T elem) {
    if (this.isFull())
      throw new IllegalStateException("Full queue");

    this.rear = (this.front + this.size) % this.capacity;
    this.arr[rear] = elem;

    this.size++;

    System.out.print("front: " + this.front);
    System.out.print(". rear: " + this.rear);
    System.out.println(". size: " + this.size);
  }

  /**
   * Retrieves the element at the front of the queue, increments the front
   * modularly in respect of the queue capacity.
   * 
   * @return the retrieved element at the front
   * @pre !this.isEmpty()
   * @throws IllegalStateException;
   */
  public T dequeue() {
    if (this.isEmpty())
      throw new IllegalStateException("Empty queue");

    T retrieved = this.arr[front];
    this.arr[front] = null;
    this.front = (this.front + 1) % this.capacity;
    this.size--;

    System.out.print("front: " + this.front);
    System.out.print(". rear: " + this.rear);
    System.out.println(". size: " + this.size);

    return retrieved;
  }

  /**
   * Checks if the queue is empty.
   * 
   * @return true if the queue is empty
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Checks if the queue is is full.
   * 
   * @return true if the queue is full.
   */
  public boolean isFull() {
    return this.size == this.capacity;
  }

  /**
   * Prints a representation of the queue via terminal.
   */
  public void print() {
    System.out.println("Capacity: " + this.arr.length);
    System.out.print("[");

    for (int i = 0; i < this.arr.length; i++) {
      if (this.arr[i] != null) {
        System.out.print(this.arr[i].toString() + (i == this.arr.length - 1 ? "" : ", "));
      } else {
        System.out.print((i == this.arr.length - 1 ? "-" : "-, "));
      }
    }

    System.out.println("]");
    System.out.println("");
  }
}
