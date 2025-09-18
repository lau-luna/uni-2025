public class MemoryPair extends Pair {
    private int previousFst;
    private int previousSnd;

    public MemoryPair(){
        super(); // it calls to the super constructor
        previousFst = 0;
        previousSnd = 0;
    }

    // Another constructor that takes 2 parameters
    public MemoryPair(int fst, int snd) {
        super(fst, snd);
        previousFst = 0;
        previousSnd = 0;
    }

    @Override
    public void setFst(int v) {
        previousFst = getFst();
        super.setFst(v);
    }

    @Override
    public void setSnd(int v) {
        previousSnd = getSnd();
        super.setSnd(v);
    }

    public void recover() {
        setFst(previousFst);
        setSnd(previousSnd);
    }
}
