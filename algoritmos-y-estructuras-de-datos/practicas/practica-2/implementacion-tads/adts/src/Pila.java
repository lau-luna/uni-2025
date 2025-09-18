// Stack: LIFO

public interface Pila<T> {
  /** Places an element on the top of the Stack
   * @param item to push to the top of the stack
   * @throws StackOverflowError if the stack is full
   */
  abstract void push(T item);

  /** Removes the element placed at the top of the stack and returns it.
   * @pre !this.isEmpty()
   * @return the removed element
   * @throws java.util.EmptyStackException if the stack is empty
   */
  abstract T pop();

  /** Returns the element placed at the top of the stack, but does not remove it
   * @pre !this.isEmpty()
   * @return the element placed at the top of the stack.
   * @throws java.util.EmptyStackException if the stack is empty
   */
  abstract T peek();

  /** Checks if the stack is isEmpty
   * @return true if there isn't any elements inside the stack
   */
  abstract boolean isEmpty();

  /** Removes all elements placed in the stack, if it's not empty.
   * @pre !this.isEmpty()
   * @throws java.util.EmptyStackException if the stack is empty
   */
  abstract void clear();
}
