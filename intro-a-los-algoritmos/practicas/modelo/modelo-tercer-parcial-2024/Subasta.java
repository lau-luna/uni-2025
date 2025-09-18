 

import java.util.ArrayList;

/**
 * Clase que mantiene los detalles de una subasta.
 * Una subasta consta de ofertas, y un monto mínimo.
 * Todas las ofertas deben ser por montos mayores o iguales
 * que el monto mínimo.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class Subasta
{
    /**
     * Lista que almacena las ofertas
     */
    private ArrayList<Oferta> ofertas;
    
    /**
     * Monto mínimo
     */
    private int montoMinimo;
    
    /**
     * Crea una subasta vacía, con un monto mínimo inicial
     */
    public Subasta(int montoMinimo)
    {
        //TODO: implementar funcionalidad de este método
        // incluyendo chequeo de precondición.
        assert montoMinimo > 0 : "El monto minimo debe ser mayor a 0.";
        
        ofertas = new ArrayList<>();
        this.montoMinimo = montoMinimo;
        
        assert repOK() : "Invariante de clase incumplida";
    }
    
    /**
     * Agrega una oferta a la subasta. Debe cumplir con la restricción
     * de monto mínimo
     * @param oferta es la oferta a agregar a la subasta.
     */
    public void agregarOferta(Oferta oferta)
    {
        if (oferta == null) {
            throw new IllegalArgumentException("oferta nula");
        }
        if (oferta.obtenerMonto() < this.montoMinimo) {
            throw new IllegalArgumentException("oferta inválida");
        }
        
        ofertas.add(oferta);
        
        if (!ofertas.get(ofertas.size()-1).equals(oferta))
            throw new IllegalStateException("El campo de la clase no es igual al parametro del metodo");
        
        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }
    
    
    /**
     * Retorna la cantidad de ofertas de la subasta
     * @return número de ofertas en la subasta
     */
    public int cantidadOfertas()
    {
        return ofertas.size();
    }
    
    /**
     * Retorna los montos de las ofertas
     * @return un arreglo conteniendo los montos de las ofertas
     */
    public int[] obtenerMontosOfertas()
    {
        //TODO: implementar funcionalidad de este método
        int[] montosOfertas = new int[ofertas.size()];
        
        for (int i = 0; i < montosOfertas.length; i++)
            montosOfertas[i] = ofertas.get(i).obtenerMonto();
            
        return montosOfertas;
    }
    
    /**
     * Imprime las ofertas de la subasta
     */
    public void imprimirOfertas()
    {
        for (Oferta p: ofertas) {
            System.out.println(p.toString());
        }
    }
    
    /**
     * Comprueba si existen ofertas superiores a cierto monto
     * en la subasta
     * @param monto es el monto a utilizar en la búsqueda
     * @return true ssi existe una oferta en la subasta con valor mayor
     * al monto pasado como parámetro
     */
    public boolean ofertasMayores(int monto)
    {
        //método no implementado (no requerido)
        int[] montosOfertas;
        montosOfertas = obtenerMontosOfertas();
        
        for (int i = 0; i < montosOfertas.length; i++)
            if (montosOfertas[i] > monto)
                return true;
        
        return false;
    }
    
    /**
     * Calcula la oferta ganadora hasta el momento.
     * La oferta ganadora es la oferta de mayor monto. 
     * Si hay varias ofertas con igual máximo monto, retorna la
     * primera. 
     * Debe haber al menos una oferta para poder calcular oferta
     * ganadora
     * @return oferta ganadora, máxima oferta en la subasta.
     */
    public Oferta ofertaGanadora()
    {
        //método no implementado (no requerido)
        if (ofertas.isEmpty())
            throw new IllegalArgumentException("No hay ofertas realizadas");
        
        Oferta ofertaMaxima = ofertas.get(0);    
        for (Oferta o : ofertas)
            if (o.obtenerMonto() > ofertaMaxima.obtenerMonto())
                ofertaMaxima = o;
            
        return ofertaMaxima;
    }
    
    /**
     * Invariante de clase para Subasta. Chequea que la colección de ofertas no
     * es nula, el monto mínimo es positivo, cada oferta satisface su repOK, 
     * y todos los montos de ofertas son mayores o iguales al monto mínimo.
     */
    public boolean repOK() {
        if (ofertas == null)
            return false;
        
        if (montoMinimo <= 0)
            return false;
            
        for (Oferta o : ofertas)
            if (!o.repOK() || o.obtenerMonto() < montoMinimo)
                return false;
                        
        return true;
    }
}
