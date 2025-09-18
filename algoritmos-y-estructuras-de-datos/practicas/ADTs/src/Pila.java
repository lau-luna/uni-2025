// Aplicar genericidad

public interface Pila<O> {

  /**
   * Returns the top of the stack without removing it if it's not empty.
   * @throws UnderFlowException if the stack is empty.
   * @see #isEmpty()
   */
  public O peek();

  /**
   * Checks if the stack is empty.
   * @return true if the stack is empty.
   */
  public boolean isEmpty();

  /**
   * Pushes an element onto the top of the stack.
   * @param elem is the elemnt to be pushed.
   * @throws OverFlowException if the stack is full.
   * @return true if the element was pushed succesfully.
   */
  public boolean push(O elem);

  /**
   * Pops the top of the stack and returns is as an object, if the stack's not empty.
   * @return top of the stack.
   * @throws UnderFlowException if the stack is empty.
   * @see #isEmpty()
   */
  public O pop();

  /**
   * Empties the stack completely
   * @throws UnderFlowException if the stack is empty already.
   * @return true if the stack was emptied succesfully.
  * @see #isEmpty()
   */
  public boolean empty();

  /**
   * Returns the lenght of the stack.
   * @return lenght of the stack
   */
  public int size();

  /**
   * Returns the capacity of the stack.
   * @return capacity of the stack
   */
  public int capacity();
}
