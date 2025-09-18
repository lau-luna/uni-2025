// Specification of a circular queue
public interface CirQueue<T> {
  /**
   * A cicular queue has:
   * @field front: where the first element is inserted, and it's the first to be retrieved.
  *  @field rear: where the last element is inserted, and it's the last to be retrieved.
   * @field size: indicates how many elements there are inside the queue.
   * @field capacity: limit of element the queue can store.
   */


  /** Inserts element on the rear of the queue, Then increments the size by 1.
   * @pre !this.isFull()
   * @throws IllegalStateException
   */
abstract void enqueue(T elem);

/** Retrieves the element at the front of the queue, increments the front modularly in respect of the queue capacity.
 * @return the retrieved element at the front
 * @pre !this.isEmpty()
 * @throws IllegalStateException;
 */
abstract T dequeue();

/** Checks if the queue is empty.
 * @return true if the queue is empty
 */
abstract boolean isEmpty();

/** Checks if the queue is is full.
 * @return true if the queue is full.
 */
abstract boolean isFull();

/** Prints a representation of the queue via terminal.
 */
abstract void print();
}
