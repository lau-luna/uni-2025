
/**
 * Write a description of class SortingTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingTest
{
    public static int[] insertionSort(int[] arr){
        if (arr == null)
            throw new IllegalArgumentException("Arreglo nulo");

        for(int i = 1; i < arr.length; i++) {
            int j = i;
            
            while(j > 0 && arr[j-1] > arr[j]){
                // swap arr[j] and arr[j-1]
                int auxJ = arr[j];
                
                arr[j] = arr[j-1];
                arr[j-1] = auxJ;
                j--;
            }
        }
        return arr;   
    }
}
