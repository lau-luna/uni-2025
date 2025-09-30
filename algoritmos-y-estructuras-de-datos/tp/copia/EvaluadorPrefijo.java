public class EvaluadorPrefijo implements Evaluador {

    private Estado estado;

    public EvaluadorPrefijo() {
        this.estado = new EstadoVariables();
    }

    /**
     * Método auxiliar que debe dividir la expresión general en los tokens más
     * pequeños. un token es cada unidad mínima significativa que compone la
     * expresión. (Usar espacio como separador, en caso de múltiples espacios
     * seguidos deben ignorarse)
     *
     * Ejemplo de uso:
     * tokenizarExpresion("AND p q") = ["AND", "p", "q"]
     * tokenizarExpresion("AND p OR q b") = ["AND", "p", "OR", "q", "b"]
     * tokenizarExpresion(" AND p q ") = ["AND", "p", "q"]
     * 
     * @param expresion Expresión a tokenizar
     * @return Arreglo de string que representan cada token de la expresión
     */
    private String[] tokenizarExpresion(String expresion) {
        // TODO Implementar este método y borrar la linea siguiente
        throw new UnsupportedOperationException("Unimplemented method 'tokenizarExpresion'");
    }

    /**
     * Valida si una secuencia de tokens es válida.
     * Solo se deben permitir los siguientes tokens:
     * AND, OR, NOT, nombres de variables en el rango [a-z]
     * 
     * @param tokens Listado de tokens a validar
     * @return true si la secuencia es válida, false si la secuencia tiene al menos
     *         un token no permitido
     */
    private boolean validarTokens(String[] tokens) {
        // TODO Implementar este método y borrar la linea siguiente
        throw new UnsupportedOperationException("Unimplemented method 'validarTokens'");
    }

    @Override
    public void setEstado(Estado variables) {
        this.estado = variables;
    }

    @Override
    public boolean evaluar(String expresionEnPrefija) throws IllegalArgumentException, IllegalStateException {
        String[] tokens = tokenizarExpresion(expresionEnPrefija);
        if (!validarTokens(tokens)) {
            throw new IllegalArgumentException("La expresión a evaluar no es válida.");
        }

        // TODO continuar con la implementación y borrar la línea siguiente
        throw new UnsupportedOperationException("Unimplemented method 'evaluar'");
    }

}
