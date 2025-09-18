public class Sum {
    public static void main(String args[]) {
        // Verificar cantidad de argumentos
        if (args.length < 2) {
            System.out.println("Por favor, ingrese exactamente 2 numeros.");
        } else {
            try {
                int num1 = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                int total = num1 + num2;
                System.out.println("El total de la suma es: " + total);
            } catch (NumberFormatException e) {
                System.out.println("Alguno de los parámentros no es un numero");
            }

            /*
             * Solucion sin try-catch
             * for (int i = 0; i < args[0].length(); i++) {
             * if (!Character.isDigit(args[0].charAt(i))) {
             * System.out.println("Ingrese números válidos");
             * return;
             * }
             * }
             * 
             * for (int i = 0; i < args[1].length(); i++) {
             * if (!Character.isDigit(args[1].charAt(i))) {
             * System.out.println("Ingrese números válidos");
             * return;
             * }
             * }
             */
        }

    }
}
