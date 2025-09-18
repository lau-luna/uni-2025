import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Prestamo> prestamos;

    /**
     * Crea una biblioteca sin préstamos activos.
     */
    public Biblioteca() {
        prestamos = new ArrayList<>();

        if (!repOK())
            throw new IllegalStateException("Invaritante de clase incumplida");
    }

    /**
     * Registra un nuevo préstamo en la biblioteca. 
     * No se pueden prestar libros que ya están prestados.
     * @param p el préstamo a agregar.
     */
    public void agregarPrestamo(Prestamo p) {
        if (p == null)
            throw new IllegalArgumentException("p nulo");

        if (estaPrestado(p.obtenerLibro()))
            throw new IllegalArgumentException("El libro " + p.obtenerLibro() + " se encuentra prestado.");

        prestamos.add(p);

        if (!repOK())
            throw new IllegalStateException("Invaritante de clase incumplida");
    }

    /**
     * Devuelve true si hay al menos un préstamo activo con menos de X días para vencimiento.
     * @param dias límite inferior para vencimientos próximos.
     */
    public boolean vencimientosProximos(int dias) {
        for (Prestamo p : prestamos)
            if (p.obtenerDiasParaVencimiento() < dias)
                return true;

        return false;
    }

    /**
     * Imprime todos los préstamos activos.
     */
    public void imprimirPrestamos() {
        for (Prestamo p : prestamos)
            System.out.println(p.toString());
    }

    /**
     * Retorna true si el préstamo de un libro específico ya existe.
     * @param libro el nombre del libro.
     */
    public boolean estaPrestado(String libro) {
        for (Prestamo p : prestamos)
            if (p.obtenerLibro().equals(libro))
                return true;

        return false;
    }

    /**
     * Invariante de clase: la lista no es nula y todos los préstamos son válidos.
     */
    public boolean repOK() {
        if (prestamos == null)
            return false;

        for (Prestamo p : prestamos)
            if (!p.repOK())
                return false;

        return true;
    }
}
