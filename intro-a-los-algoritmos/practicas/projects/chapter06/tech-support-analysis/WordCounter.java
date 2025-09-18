import java.util.HashMap;
import java.util.HashSet;

/**
 * Keep a record of how many times each word was
 * entered by users.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 */
import java.util.Set;

public class WordCounter
{
    // Associate each word with a count.
    private HashMap<String, Integer> counts;
    private Responder response;

    /**
     * Create a WordCounter
     */
    public WordCounter()
    {
        counts = new HashMap<>();
        response = new Responder();
    }

    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }

    /**
     * Retorna counts, que es un HashMap que asocia una clave String a cuantas veces aparece, a un Integer.
     * @return Un HashMap con Strings asociadas a un contador.
     */
    public HashMap<String, Integer> getCounts(){
        return counts;
    }

    /**
     * Imprime solo las claves que no estan en el responseMap de Responder.
     */
    public void printCounts(){
        Set<String> responderKeys = response.getResponseMapKeys();
        Set<String> keys =  counts.keySet();

        for (String key : keys) {
            if (!responderKeys.contains(key)){
                int count = counts.get(key);
                System.out.println(key + ": " + count);
            }
        }
    }
}
