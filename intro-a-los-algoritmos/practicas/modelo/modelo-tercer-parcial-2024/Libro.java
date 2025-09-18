
/**
 * Un libro que tiene un titulo, una cantidad de ejemplares totales en la biblioteca, y una cantidad de
 *
 * @author (Lautaro Luna)
 * @version (ver 1.0)
 */
public class Libro
{
    private String titulo; // titulo del libro
    private int ejemplaresTotales;
    private int ejemplaresPrestados;
    
    /**
     * Contructor de libro
     * @param titulo es el titulo del libro
     * @param ejemplaresTotales son los ejemplares que se encuentran en la biblioteca
     * 
     * @pre titulo != null && !titulo.isEmpty()
     * @pre ejemplaresTotales > 0
     */
    
    public Libro(String titulo, int ejemplaresTotales){
        if (titulo == null || titulo.isEmpty())
            throw new IllegalArgumentException("titulo nulo o vacio");
            
        if (ejemplaresTotales <= 0)
            throw new IllegalArgumentException("ejemplares totales debe ser > 0");
            
        this.titulo = titulo;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresPrestados = 0;
        
        if (!repOK()) 
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    
    /**
     * Presta un ejemplar del libro ssi hay ejemplares disponibles.
     * @pre ejemplaresPrestados < ejemplaresTotales
     * @throws IllegalStateException si se intenta prestar un libro y no hay mas ejemplares disponibles para prestar.
     */
    public void prestar(){
        if (ejemplaresPrestados >= ejemplaresTotales)
            throw new IllegalStateException("No hay mas ejemplares disponibles para prestar");
        
        ejemplaresPrestados++;
        
        if (!repOK()) 
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    /**
     * Devuelve un ejemplar del libro ssi hay ejemplares prestados.
     * @pre ejemplaresPrestados > 0
     * @throws IllegalStateException si se intenta devolver un libro y no hay ejemplares de ese libro prestado.
     */
    public void devolver(){
        if (ejemplaresPrestados <= 0)
            throw new IllegalStateException("No hay ejemplares de este libro prestados");
        
        ejemplaresPrestados--;
        
        if (!repOK()) 
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    /**
     * @returns Un String con la informacion del libro.
     */
    public String toString() {
        return String.format("%s - %d totales - %d prestados", titulo, ejemplaresTotales, ejemplaresPrestados);
    }
    
    /**
     * Chequeo de invariante de clase
     */
    public boolean repOK(){
        if (titulo == null || titulo.isEmpty())
            return false;
            
        if (ejemplaresTotales <= 0)
            return false;
            
        if (ejemplaresPrestados < 0)
            return false;
        
        if (ejemplaresPrestados > ejemplaresTotales) 
            return false;
        
        return true;
    }
}
