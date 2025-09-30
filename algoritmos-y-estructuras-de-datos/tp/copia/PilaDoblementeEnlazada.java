public class PilaDoblementeEnlazada<T> implements Pila<T> {

    private NodoPila<T> inicio;
    private NodoPila<T> fin;

    PilaDoblementeEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public T tope() throws IllegalStateException {
        if (this.esVacia()) {
            throw new IllegalStateException("No se puede consultar el tope en pila vacia");
        }

        return this.inicio.getItem();
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null && this.fin == null;
    }

    @Override
    public void apilar(T elem) throws IllegalStateException {
      // Ver cómo implementar capacidad máxima de la pila.

      NodoPila<T> nodoNuevo = new NodoPila<>(inicio, elem, null);
      
      if (this.esVacia()) {
        this.inicio = nodoNuevo;
        this.fin = nodoNuevo;
      } else {
        this.inicio.setNext(nodoNuevo);
        this.inicio = nodoNuevo;
      }  
    }

    @Override
    public void desapilar() throws IllegalStateException {
       if (this.esVacia())
         throw new IllegalStateException("La pila está vacía.");

       if (this.inicio == this.fin) {
         this.inicio = null;
         this.fin = null;
       } else {
         this.inicio = this.inicio.getPrev();
         this.inicio.getNext().setPrev(null);
         this.inicio.setNext(null);
       }

    }

    @Override
    public void imprimir() {
      // Esto imprime de inicio a fin
        NodoPila<T> temp = this.inicio;
        while (temp != null) {
            System.out.print(temp.getItem());
            System.out.print(", ");
            temp = temp.getNext();
        }
        System.out.println("");
    }

    @Override
    public void imprimirReversa() {
      // Esto imprime de fin a inicio
        NodoPila<T> temp = this.fin;
        while (temp != null) {
            System.out.print(temp.getItem());
            System.out.print(", ");
            temp = temp.getPrev();
        }
        System.out.println("");
    }

}
