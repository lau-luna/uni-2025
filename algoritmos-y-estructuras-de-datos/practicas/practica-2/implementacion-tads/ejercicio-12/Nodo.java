public class Nodo<T> {
  private T info;
  private Nodo<T> next;

  public Nodo(){
    this.info = null;
    this.next = null;
  }

  public Nodo(T elem) {
    this.info = elem;
    this.next = null;
  }

  public T getInfo() {
    return this.info;
  }

  public Nodo<T> getNext() {
    return this.next;
  }

  public void setInfo(T elem) {
    this.info = elem;
  }

  public void setNext(Nodo<T> next) {
    this.next = next;
  }
}
