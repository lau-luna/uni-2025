import java.util.Random;
import java.util.ArrayList;

public class RandomTester {

    private Random rand;

    public RandomTester() {
        rand = new Random();
    }

    public void printOneRandom() {
        int randomNumber = rand.nextInt();
        System.out.println(randomNumber);
    }

    public void printMultiRandom(int howMany) {
        for (int i = 0; i < howMany; i++) {
            int randomNumber = rand.nextInt();
            System.out.println(i + 1 + ": " + randomNumber);
        }
    }

    public void throwDice() {
        int randomNumber = rand.nextInt(1, 7);
        System.out.println("Salió: " + randomNumber);
    }

    /**
     * This method returns a random String.
     */

    public String getResponse() {
        ArrayList<String> responses = new ArrayList<>();
        responses.add("yes");
        responses.add("no");
        responses.add("maybe");
        int randomNumber = rand.nextInt(responses.size());
        return responses.get(randomNumber);
    }

    /**
     * This method generates a random number from 1 to max (included).
     * 
     * @pre max > 0.
     */
    public int randomMax(int max) {
        if (max < 1)
            throw new IllegalArgumentException("max must be greater than 0");
        int randomNumber = rand.nextInt(max + 1);
        return randomNumber;
    }

    /*
     *  This method generates a random int from min to max (both included)
     *  
     *@pre min < max 
     */

    public int randomNumber(int min, int max) {
        if (min > max)
            throw new IllegalArgumentException("min must be lesser or equal than max");
        int randomNumber = rand.nextInt(min, max+1);
        return randomNumber;
    }
}
