public interface Evaluador {

    /**
     * Esta interfaz representa las operaciones mínimas con las que debe contar
     * nuestro evaluador de expresiones lógicas.
     * 
     * Ejemplo de uso de esta interfaz:
     * 
     * Estado e = new ClaseQueImplementa();
     * e.guardar('p', true);
     * e.guardar('q', false);
     * 
     * Evaluador eval = new ClaseQueImplementa();
     * eval.setEstado(e);
     * 
     * eval.evaluar("AND p q") //Según el estado e debería retornar false
     * eval.evaluar("OR p q") // Según el estado e debería retornar true
     * 
     */

    /**
     * Este método debe permitir fijar el estado que se usará durante la evaluación
     * de las expresiones lógicas.
     * 
     * @param variables Es una instancia de una clase que implementa la interfaz
     *                  Estado.
     */
    public void setEstado(Estado variables);

    /**
     * Este método haciendo uso del estado actual, deberá evaluar la expresión
     * lógica representada de forma prefija y retornar
     * su valor de verdad.
     * 
     * @param expresionEnPrefija Cadena que representa a la expresión a evaluar.
     * @throws IllegalArgumentException Si la expresion pasada para evaluar tiene
     *                                  algún error o no está bien formada.
     * @throws IllegalStateException    Si la expresión pasada para evaluar utiliza
     *                                  una variable no definida en el estado
     *                                  actual.
     */
    public boolean evaluar(String expresionEnPrefija) throws IllegalArgumentException, IllegalStateException;

}