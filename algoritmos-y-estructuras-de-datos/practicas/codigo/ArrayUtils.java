import java.util.Arrays;

/**
 * Clase ArrayUtils: contiene implementaciones de rutinas fundamentales
 * sobre arreglos.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class ArrayUtils {

    /**
     * Comprueba si un elemento (entero) pertenece a un arreglo.
     */
    public boolean pertenece(int elem, int[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("Arreglo nulo");

        boolean found = false;
        int i = 0;

        while (i < arreglo.length && !found) {
            if (arreglo[i] == elem)
                found = true;
            i++;
        }

        return found;
    }

    /**
     * Calcula la suma de los elementos de un arreglo de enteros
     */
    public int suma(int[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("Arreglo nulo");

        int suma = 0;

        for (int i = 0; i < arreglo.length; i++)
            suma += arreglo[i];

        return suma;
    }

    /**
     * Calcula el valor mínimo de un arreglo de reales
     */
    public float minimo(float[] arreglo) {
        if (arreglo == null || arreglo.length == 0)
            throw new IllegalArgumentException("Arreglo nulo o vacío");

        float min = arreglo[0];

        for (int i = 0; i < arreglo.length; i++)
            if (arreglo[i] < min)
                min = arreglo[i];

        return min;
    }

    /**
     * Calcula el valor máximo de un arreglo de reales
     */
    public float maximo(float[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("Arreglo nulo");
        if (arreglo.length <= 0)
            throw new IllegalArgumentException("Arreglo vacío");

        float max = arreglo[0];

        for (int i = 0; i < arreglo.length; i++)
            if (arreglo[i] > max)
                max = arreglo[i];

        return max;
    }

    /**
     * Calcula el valor promedio de un arreglo de reales
     */
    public float promedio(float[] arreglo) {
        if (arreglo == null || arreglo.length <= 0)
            throw new IllegalArgumentException("Arreglo nulo");

        int suma = 0;

        for (int i = 0; i < arreglo.length; i++)
            suma += arreglo[i];

        return suma / arreglo.length;
    }

    /**
     * Retorna un arreglo con los primeros n números de Fibonacci
     */
    public static int[] fibSequence(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n debe ser 1 o mayor");

        int[] fib = new int[n];

        if (n >= 1)
            fib[0] = 0;

        if (n >= 2)
            fib[1] = 1;

        if (n >= 3)
            for (int i = 2; i < fib.length; i++)
                fib[i] = fib[i - 1] + fib[i - 2];

        return fib;
    }

    /**
     * Calcula la mediana de un arreglo de reales
     */
    public float mediana(float[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("Arreglo nulo");

        Arrays.sort(arreglo);

        int size = arreglo.length;

        if (size % 2 == 0)
            return (arreglo[(size / 2) - 1] + arreglo[(size / 2)]) / 2;

        return (arreglo[size / 2]);
    }

    /**
     * Comprueba si dos arreglos de enteros son iguales
     */
    public boolean iguales(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new IllegalArgumentException("Uno o ambos arreglos son nulos");

        return Arrays.equals(arr1, arr2);
    }

    /**
     * Comprueba si un arreglo tiene valores repetidos
     */
    public boolean tieneRepetidos(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0)
            throw new IllegalArgumentException("El arreglo es nulo o está vacío.");

        for (int i = 0; i < arreglo.length; i++)
            for (int j = i + 1; j < arreglo.length; j++)
                if (arreglo[i] == arreglo[j])
                    return true;

        return false;
    }

    /**
     * Comprueba si un arreglo tiene dos valores cuya suma dé cero.
     */
    public boolean tieneOpuestos(float[] arreglo) {
        if (arreglo == null || arreglo.length == 0)
            throw new IllegalArgumentException("El arreglo es nulo o está vacío.");

        for (int i = 0; i < arreglo.length; i++)
            for (int j = i + 1; j < arreglo.length; j++)
                if (arreglo[i] + arreglo[j] == 0)
                    return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayUtils o = new ArrayUtils();

        System.out.println(o.pertenece(1, new int[] { 0, 1, 2, 3 }) ? "Pertenece" : "No pertenece");
        System.out.println("La suma de [1, 2, 3] es: " + o.suma(new int[] { 1, 2, 3 }));
        System.out.println("El mínimo en [3, 1, 2] es: " + o.minimo(new float[] { 3, 1, 2 }));
        System.out.println("El máximo en [3, 1, 2] es: " + o.maximo(new float[] { 3, 1, 2 }));
        System.out.println("El promedio en [3, 1, 2] es: " + o.promedio(new float[] { 3, 1, 2 }));
        System.out.println("Arreglo con los primeros 10 numeros en fibonacci: " + Arrays.toString(fibSequence(10)));
        System.out.println("La mediana en [10, 2, 8] es: " + o.mediana(new float[] { 10, 2, 8 }));
        System.out.println("[10, 2, 8] " + (o.iguales(new int[] {10, 2, 8}, new int[] {1, 2, 3}) ? "es igual" : "no es igual") + " a [1, 2, 3]");
        System.out.println("[1, 2, 3] " + (o.tieneRepetidos(new int[] {1, 2, 3}) ? "tiene" : "no tiene") + " repetidos");
        System.out.println("[1, -1] " + (o.tieneOpuestos(new float[] {1, -1}) ? "tiene" : "no tiene") + " opuestos");

    }

}
