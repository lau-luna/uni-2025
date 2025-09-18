/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> responseMap;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        responseMap = new HashMap<String, String>();
        fillResponseMap();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        for(String word : words) {
            String response = responseMap.get(word);
            if (response != null) {
                return response;
            }
        }
        return pickDefaultResponse();
    }
    
    private void fillResponseMap(){
        responseMap.put("slow", "I think this has to do with your hardware.");
        responseMap.put("expensive", "The cost of the product is quite competitive.");
        responseMap.put("bug", "All software has some bugs");
        responseMap.put("borda", "Yes, agustin borda is a chad.");
    }
    
    private String pickDefaultResponse(){
        return "Default response, lol";
    }
}
