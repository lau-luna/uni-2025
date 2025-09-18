import java.util.EmptyStackException;

public class PilaArray<O> implements Pila<O>{
  private int MAX_STACK = 100;
  private O[] items;
  private int size;   // It's the stack's size

  // Empty constructor
  @SuppressWarnings("unchecked")
  public PilaArray() {
    this.items = (O[]) new Object[MAX_STACK];  // Epic casting
    this.size = 0;
  }

  /**
   * Class constructor
   */
  @SuppressWarnings("unchecked")
  public PilaArray(int capacity){
    if (capacity <= 0)
      throw new IllegalArgumentException();
    this.MAX_STACK = capacity;
    this.items = (O[]) new Object[this.MAX_STACK];  // Epic casting
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public O peek(){
    if (isEmpty())
      throw new EmptyStackException();

    return this.items[this.size - 1];
  }

  @Override
  public boolean push(O elem) {
    if (size == MAX_STACK)
      throw new StackOverflowError("Stack is full");

    items[size] = elem;
    size++;

    return true;
  }

  @Override
  public O pop(){
    if (isEmpty())
      throw new EmptyStackException();

    size--;
    O elem = items[size];
    items[size] = null;

    return elem; 
  }

  @Override
  public boolean empty(){
    if (isEmpty())
      throw new EmptyStackException();

    for (int i = 0; i < this.size; i++)
      items[i] = null;

    size = 0;

    return true;
  }

  @Override
  public int size() {
    return this.size;
  }
  
  @Override
  public int capacity() {
    return this.MAX_STACK;
  }
}
