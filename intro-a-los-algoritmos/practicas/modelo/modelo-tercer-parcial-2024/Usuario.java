import java.util.ArrayList;

/**
 * Write a description of class Usuario here.
 *
 * @author (Lautaro Luna)
 * @version (ver 1.0)
 */
public class Usuario
{
    private String nombre; // nombre del usuario
    private ArrayList<Libro> libros; // lista con los libros que tiene el usuario
    
    /**
     * Constructor de Usuario
     * 
     * @param nombre del usuario
     * @pre nombre != null && !nombre.isEmpty()
     */
    public Usuario(String nombre){
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("nombre nulo o vacio");
        
        this.nombre = nombre;
        libros = new ArrayList<Libro>();
        
        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    /**
     * Pide prestado un ejemplar de un libro
     * 
     * @throws IllegalStateException si el usuario ya tiene el libro.
     * @throws IllegalStateException si se cumple la invariante de clase.
     */
    public void pedirPrestado(Libro libro) {
        for (Libro l : libros)
            if (l.equals(libro))
                throw new IllegalStateException("El usuario ya tiene este libro.");
                
        libro.prestar();
        libros.add(libro);
        
        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    /**
     * Devuelve un ejemplar de un libro prestado al usuario.
     * 
     * @throws IllegalStateException si se intenta devolver un libro que el usuario no tiene.
     * @throws IllegalStateException si se cumple la invariante de clase.
     */
    public void devolverLibro(Libro libro) {
        boolean loTiene = false;
        for (Libro l : libros)
            if (l.equals(libro))
                loTiene = true;
        
        if (!loTiene)
            throw new IllegalStateException("El usuario no tiene este libro");
        
        libro.devolver();
        libros.remove(libro);
        
        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    /**
     * Imprime la informacion de todos los libros del usuario
     */
    public void imprimirLibros(){
        if (libros.isEmpty()) {
            System.out.println("El usuario no tiene libros.");
            return;
        }
        
        for (Libro l : libros)
            System.out.println(l.toString());
    }
    
    /**
     * Chequeo de invariante de clase
     */
    public boolean repOK(){
        if (nombre == null || nombre.isEmpty())
            return false;
        
        for (Libro l : libros)
            if (!l.repOK())
                return false;
        
        return true;
    }
}
