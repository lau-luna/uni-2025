public interface Estado {

    // Decisión de diseño: para facilitar el diseño de nuestro evaluador de
    // expresiones, asumiremos que solo se permienten 26 variables lógicas
    // es decir, las letras de la A a la Z en minúsculas. Ejemplo: p,q,r,s.

    /**
     * Ejemplo de uso de la interfaz
     * 
     * Estado e = new ClaseQueImplementa();
     * e.guardar('p', true);
     * e.guardar('q', false);
     * 
     * Luego, el estado puede ser utilizado durante la evaluación. Cada vez que se
     * use una variable, se puede consultar su estado con
     * e.consultar('p')
     */

    /**
     * Este método es el encargado de almacenar en el estado a una variable junto a
     * su valor de verdad asociado.
     * En caso que la variable ya se encuentre en el estado, se debe reemplazar su
     * valor anterior.
     * 
     * @param variable Nombre de la variable a guardar. Por ejemplo: 'q', 'r'.
     * @param valor    Valor actual de la variable true/false
     * @throws IllegalArgumentException Si el nombre de la variable no es válido
     *                                  (Fuera del rango [a-z])
     */
    public void guardar(char variable, boolean valor) throws IllegalArgumentException;

    /**
     * Este método permite consultar y obtener el valor de verdad asociado a una
     * variable.
     * 
     * @param variable Nombre de la variable a consultar. Por ejemplo: 'q', 'r'.
     * @throws IllegalArgumentException Si el nombre de la variable no es válido
     *                                  (Fuera del rango [a-z])
     * @throws IllegalStateException    Si la variable no fue guardada previamente
     *                                  en el estado
     */
    public boolean consultar(char variable) throws IllegalArgumentException, IllegalStateException;

}