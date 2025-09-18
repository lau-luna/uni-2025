//import MedicionesTemperaturas;

public class MedicionesTemperaturasTest {
    public static void main(String args[]) {
        MedicionesTemperaturas o = new MedicionesTemperaturas(1, 2);

        o.agregarRegistro(-1);
        o.agregarRegistro(3);
        o.agregarRegistro(8);
        o.agregarRegistro(15);
        o.agregarRegistro(12);
        o.agregarRegistro(6);
        o.agregarRegistro(6);
        o.agregarRegistro(2);

        o.imprimirTemperaturas();

        // Chequeo de metodos
        System.out.println("");
        System.out.println("El promedio es: " + o.calcularPromedio() + "ºC");
        System.out.println("La temperatura máxima es: " + o.calcularMaximaTemperatura() + " ºC");
        System.out.println("La temperatura minima es: " + o.calcularMinimaTemperatura() + " ºC");
        System.out.println("La amplitud térmica es de: " + o.calcularAmplitudTermica() + " ºC");

    }
}
