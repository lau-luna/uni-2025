public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(5, "Hola");
        Pair<Integer, Integer> p2 = new Pair<>(5, 6);
        Pair<String, String> p3 = new Pair<>("Hola", "mundo");

        System.out.println("p1 fst: " + p1.getFst());
        System.out.println("p1 snd: " + p1.getSnd());
        
    } 
}
