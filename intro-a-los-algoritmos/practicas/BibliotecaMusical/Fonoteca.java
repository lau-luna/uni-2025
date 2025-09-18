
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa una fonoteca (repositorio de material musical) organizado
 * en albumes de estudio y en vivo. 
 */
public class Fonoteca
{
    // nombre de la fonoteca (repositorio de material musical)
    private String nombre;

    // albumes de estudio
    private ArrayList<Album> albumesDeEstudio;

    // albumes en vivo
    private ArrayList<Album> albumesEnVivo;

    /**
     * Constructor de la clase Fonoteca. Crea una nueva fonoteca con su nombre, y listas
     * vacías de albumes de estudio y en vivo.
     */
    public Fonoteca(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede ser null ni vacío");
        }
        this.nombre = nombre;
        this.albumesDeEstudio = new ArrayList<Album>();
        this.albumesEnVivo = new ArrayList<Album>();
    }

    /**
     * Agrega un nuevo album a la fonoteca.
     * @param album es el album a agregar.
     * Precondición: el album no debe ser null, ni deben existir albumes con el mismo título
     *              en la fonoteca.
     * Postcondición: se agrega el album a la fonoteca, a la lista de albumes correspondiente, de 
     *              acuerdo a si el album es en vivo o no. 
     */
    public void agregarAlbum(Album album) {
        if (album == null)
            throw new IllegalArgumentException("album nulo");

        if (tieneRepetido(album, albumesEnVivo) || tieneRepetido(album, albumesDeEstudio))
            throw new IllegalArgumentException(album.obtenerTitulo() + " ya esta en la fonoteca");

        if (album.esEnVivo()) {
            albumesEnVivo.add(album);
        } else {
            albumesDeEstudio.add(album);
        }
    }
    
    /**
     * Metodo auxiliar para chequear si un album ya esta en una lista
    */
    private boolean tieneRepetido(Album album, ArrayList<Album> lista){
        for (Album a : lista)
            if (album.obtenerTitulo().equals(a.obtenerTitulo()))
                return true;
        return false;
    }

    /**
     * Retorna el conjunto de títulos de albumes de un año dado. 
     * @param anho es el año para el cual se deben encontrar los albumes en la fonoteca.
     * @return el conjunto de todos los títulos de albumes en la fonoteca, cuyo año de edición es el dado.
     * Precondición: anho debe ser mayor o igual a 1900.
     */
    public HashSet<String> obtenerTitulosAlbumesAnho(int anho) {
        if (anho < 1900)
            throw new IllegalArgumentException("anho debe ser >= 1900");

        HashSet<String> titulos = new HashSet<>();

        for (int i = 0; i < albumesEnVivo.size(); i++) {
            Album currentAlbum = albumesEnVivo.get(i);

            if (currentAlbum.obtenerAnho() == anho)
                titulos.add(currentAlbum.obtenerTitulo());
        }

        for (int i = 0; i < albumesDeEstudio.size(); i++) {
            Album currentAlbum = albumesDeEstudio.get(i);

            if (currentAlbum.obtenerAnho() == anho)
                titulos.add(currentAlbum.obtenerTitulo());
        }

        for (String s : titulos)
            System.out.println(s);

        return titulos;
    }

    /**
     * Invariante de representacion de la clase. Un objeto de tipo Fonoteca es internamente consistente si:
     * - El nombre de la fonoteca debe ser no nulo y no vacio
     * - Las listas de albumes no deben tener elementos repetidos (albumes distintos con el mismo nombre)
     * - La lista de albumes en vivo solo contiene albumes en vivo
     * - la lista de albumes de estudio solo contiene albumes de estudio (no albumes en vivo)
     */
    public boolean repOK() {
        // Nombre nulo o vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        
        // Chequea que albumesEnVivo no tenga albumes de estudio, ni albumes repetidos en si misma
        for (int i = 0; i < albumesEnVivo.size(); i++) {
            // Si este album no es en vivo, retornar falso
            if (!albumesEnVivo.get(i).esEnVivo()) {
                return false;
            }
            
            /*
             * Chequeo de repetido en la misma lista
             * importante inicializar la variable como j + 1, asi no se compara el elemento del for de arriba
             */
            for (int j = i + 1; j < albumesEnVivo.size(); j++) {
                if (albumesEnVivo.get(i).obtenerTitulo().equals(albumesEnVivo.get(j).obtenerTitulo())) {
                    return false;
                }
            }
        }
        
        // Chequea que albumesDeEstudio no tenga albumes en vivo, ni albumes repetidos en si misma
        for (int i = 0; i < albumesDeEstudio.size(); i++) {
            // Si este album es en vivo, retornar falso
            if (albumesEnVivo.get(i).esEnVivo()) {
                return false;
            }
            
            /*
             * Chequeo de repetido en la misma lista
             * importante inicializar la variable como j + 1, asi no se compara el elemento del for de arriba
             */
            for (int j = i + 1; j < albumesDeEstudio.size(); j++) {
                if (albumesDeEstudio.get(i).obtenerTitulo().equals(albumesDeEstudio.get(j).obtenerTitulo())) {
                    return false;
                }
            }
        }
        
        // Chequeo de repetido en ambas listas
        for (Album album1 : albumesEnVivo)
            for (Album album2 : albumesDeEstudio)
                if (album1.obtenerTitulo().equals(album2.obtenerTitulo()))
                    return false;

        return true;
    }

    /*
     * Nota: el método agregarAlbum() verifica la unicidad de los títulos recorriendo ambas listas.
     * Sin embargo, el enunciado especifica una precondición que exige que no haya álbumes con el mismo título en toda la fonoteca,
     * lo cual afecta directamente al invariante de representación.
     * Si bien no se podía modificar la firma del método, se considera importante mencionar que esta verificación
     * es fundamental para mantener el invariante consistente.
     * Además, se recomienda documentar o reforzar esta restricción si se reutiliza el código en otro contexto.
     */
}
