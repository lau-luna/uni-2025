public class Main {
    public static void main(String[] args) {
        PilaArray<Integer> pilaEnteros = new PilaArray<>();
        pilaEnteros.push(1);
        pilaEnteros.push(2);
        pilaEnteros.push(3);


        System.out.println("Cant elementos: " + pilaEnteros.size());

        System.out.println("Tope: " + pilaEnteros.peek());

        pilaEnteros.pop();
        pilaEnteros.pop();

        System.out.println("Tope: " + pilaEnteros.peek());

        //It's working dude
    }
}
