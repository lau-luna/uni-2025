/**
 * Modela un préstamo de un libro a un lector, con fecha de vencimiento.
 */
public class Prestamo {
    private String lector;
    private String libro;
    private int diasParaVencimiento;

    /**
     * Crea un préstamo. El lector y libro no deben ser nulos ni vacíos,
     * y los días para vencimiento deben ser mayores a cero.
     * 
     *  @pre lector != null && !lector.isEmpty()
     *  @pre libro != null && !libro.isEmpty()
     *  @pre diasParaVencimiento > 0
     */
    public Prestamo(String lector, String libro, int diasParaVencimiento) {
        if (lector == null || lector.isEmpty())
            throw new IllegalArgumentException("lector nulo o vacio");
            
        if (libro == null || libro.isEmpty())
            throw new IllegalArgumentException("libro nulo o vacio");
            
        if (diasParaVencimiento <= 0)
            throw new IllegalArgumentException("diasParaVencimiento debe ser >= 0");
            
        this.lector = lector;
        this.libro = libro;
        this.diasParaVencimiento = diasParaVencimiento;
        
        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }

    public String obtenerLector() {
        return lector;
    }

    public String obtenerLibro() {
        return libro;
    }

    public int obtenerDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public String toString() {
        // TODO: retornar un String con formato "lector - libro (vencimiento en X días)"
        return lector + " - " + libro + " (vencimiento en " + diasParaVencimiento + " dias)";
    }

    public boolean repOK() {
        if (lector == null || lector.isEmpty())
            return false;
            
        if (libro == null || libro.isEmpty())
            return false;
            
        if (diasParaVencimiento <= 0)
            return false;
            
        return true;
    }
}
