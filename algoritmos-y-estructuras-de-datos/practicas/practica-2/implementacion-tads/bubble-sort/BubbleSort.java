import java.util.ArrayList;

public class BubbleSort{
  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
   int n = list.size();
   boolean swapped;
   int comparisons = 0;

   // bucle externo para las pasadas de ordenamiento
   for (int i = 0; i < n - 1; i++) {
     swapped = false;

     // Bucle interno para comparar y mover el elemento mas grande al final
     for (int j = 0; j < n - 1 - i; j++) {
       //compara elementos adyacentes
       if (list.get(j) > list.get(j+1)) {
         Integer aux = list.get(j);
         list.set(j, list.get(j+1));
         list.set(j+1, aux);
         swapped = true;
         comparisons ++;
       }
     }

     // La lista ya estaba ordenada, salir
     if (!swapped) {
       break;
     }
     
   }
   System.out.println("Comparisons: " + comparisons);
   return list;
  }
}
