public class Main {
  public static void main(String[] args) {
      Pair var1 = new Pair(5, 6);

      System.out.println("p Fst: " + var1.getFst());
      System.out.println("p Snd: " + var1.getSnd());

      MemoryPair var2 = new MemoryPair(3, 4);

      var2.setFst(10);
      var2.setSnd(10);

      System.out.println("mp Fst: " + var2.getFst());
      System.out.println("mp Snd: " + var2.getSnd());

      var2.recover();

      System.out.println("mp Fst: " + var2.getFst());
      System.out.println("mp Snd: " + var2.getSnd());
   }
}
