public interface Cola<T> {
  /** Places an element at the end of the queue
   * @param elem to be placed
   */
  abstract void enqueue(T elem);

  /** Deletes the element at the start of the queue
   * @pre !this.isEmpty()
   * @throws EmptyStackException
   */
  abstract T dequeue();

  /** Checks if the queue is empty
   * @return true if the queue is empty
   */
  abstract boolean isEmpty();

  /** Removes all elements from the queue
   * @pre !this.isEmpty()
   */
  abstract void clear();

  /** Prints a representation of the queue
   */
  abstract void print();
}
