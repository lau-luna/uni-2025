
/**
 *
 * A class that counts how many words are in a sentence that start with A's
 * @author (Lautaro Luna)
 * @version (a version number or a date)
 */
public class Counter
{
    // instance variabl}
    public int countWords(String phrase){
        int i = 0;
        int quantity = 0;
        char actualCharacter = ' ';
        char prevCharacter = ' ';
        while(i < phrase.length()){
            actualCharacter = phrase.charAt(i);
            if(i == 0){
                if(actualCharacter == 'A' || actualCharacter == 'a'){
                    quantity++;
                }
            }else{
                prevCharacter = phrase.charAt(i-1);
                if ((actualCharacter == 'A' || actualCharacter == 'a') &&  prevCharacter == ' ') {
                    quantity++;
                }
            }
            i++;
        }
        return quantity;
    }
}
