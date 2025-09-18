public class Caja<T> {
  private T contenido;

  public Caja(){
    this.contenido = null;
  }

  /**
   * Guarda un item en la Caja
   * @param item a guardarse en contenido
   * @pre true
   * @post guarda un item en la caja
   */
  public void guardar(T item) {
    if (item == null)
      throw new IllegalArgumentException("item musn't be null");

    this.contenido = item;
  }

  /**
   * Retorna el item almacenado
   */
  public T obtener() {
    return this.contenido;
  }

  /**
   * Imprime información sobre el objeto guardado en la terminal
   */
  public void mostrarInfo(){
    if (contenido == null) {
      System.out.println("La caja está vacía");
    } else {
      System.out.println(this.contenido.toString());
    }
  }

}
