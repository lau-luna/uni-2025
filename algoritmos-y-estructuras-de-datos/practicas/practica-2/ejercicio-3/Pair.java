public class Pair {
    private int fst;
    private int snd;

    /**
     * Constructor of the class
     **/
    public Pair() {
        fst = 0;
        snd = 0;
    }

    /**
     * Constructor of the class
     * 
     * @param x the first component
     * @param y the second component
     * @pre true
     * @post creates the new object
     **/
    public Pair(int fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }

    /**
     * Get the first coordinate
     * 
     * @return the first value of pair
     * @pre true
     * @post returns the first item
     **/
    public int getFst() {
        return this.fst;
    }

    /**
     * Get the second coordinate
     * 
     * @return the second value of pair
     * @pre true
     * @post returns the second item
     **/
    public int getSnd() {
        return this.snd;
    }
    
    /**
     * Change the first coordinate
     * 
     * @param x change the first value
     * @pre true
     * @post change x
     **/
    public void setFst(int fst) {
        this.fst = fst;
    }

    /**
     * Change the second coordinate
     * 
     * @param y change the second value
     * @pre true
     * @post change y
     **/
    public void setSnd(int snd) {
        this.snd = snd;
    }
}
