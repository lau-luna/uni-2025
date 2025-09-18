import java.util.ArrayList;

/**
 * Registros de temperaturas diarios de una estacion meteorológica
 */
public class MedicionesTemperaturas {
    /**
     * Contiene las mediciones de temperaturas.
     */
    private ArrayList<Integer> registros;

    /**
     * Dia del registro
     */
    private int dia;

    /**
     * Mes del registro
     */
    private int mes;

    /**
     * Constructor de la clase. Inicializa dia y mes con los parámetros respectivos,
     * y la lista de registros se inicializa vacía (sin mediciones).
     * Precondición:
     * 
     * @pre dia debe ser un día válido (entre 1 y 31)
     * @pre mes debe ser un mes válido (entre 1 y 12)
     */
    public MedicionesTemperaturas(int dia, int mes) {
        assert dia >= 1 && dia <= 31;
        assert mes >= 1 && mes <= 12;
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
    }

    /**
     * Agrega una temperatura al registro de temperaturas
     */
    public void agregarRegistro(int nuevaTemperatura) {
        registros.add(nuevaTemperatura);
    }

    /**
     * Muestra todas las temperaturas registradas en
     * la pantalla.
     */
    public void imprimirTemperaturas() {
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura : registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
    }

    /**
     * Calcula el promedio de las temperaturas registradas
     */
    public float calcularPromedio() {
        if (this.registros.size() <= 0) {
            throw new IllegalStateException("No hay temperaturas registradas.");
        }

        float suma = 0;
        for (Integer temp : this.registros) {
            suma += temp;
        }

        return suma / this.registros.size();
    }

    /**
     * Calcula la maxima temperatra registrada
     */
    public int calcularMaximaTemperatura() {
        if (this.registros.size() <= 0)
            throw new IllegalStateException("No hay temperaturas registradas.");

        int maxTemp = this.registros.get(0);

        for (int t : this.registros) {
            if (t > maxTemp) {
                maxTemp = t;
            }
        }

        return maxTemp;
    }

    /**
     * Calcula la minima temperatra registrada
     */
    public int calcularMinimaTemperatura() {
        if (this.registros.size() <= 0)
            throw new IllegalStateException("No hay temperaturas registradas.");

        int minTemp = this.registros.get(0);

        for (int t : this.registros) {
            if (t < minTemp) {
                minTemp = t;
            }
        }

        return minTemp;
    }

    /**
     * Calcula la diferencia entre la minima y la maxima temperatura registrada
     */
    public int calcularAmplitudTermica() {
        if (this.registros.size() <= 0)
            throw new IllegalStateException("No hay temperaturas registradas.");

        int amplitud = Math.abs(calcularMaximaTemperatura() - calcularMinimaTemperatura());

        return amplitud;
    }
}
