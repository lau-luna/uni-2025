public class PruebaPila extends Prueba {

    public static void testPilaNuevaEstaVacia() {
        Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();

        assertEquals(true, p.esVacia(), "Una nueva pila debe estar vacia.");
    }

    public static void testPilaVaciaNoPuedeDesapilar() {
        assertThrows(IllegalStateException.class, () -> {
            Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();
            p.desapilar();
        }, "El método desapilar debería lanzar IllegalStateException en pilas vacias.");
    }

    public static void testPilaVaciaNoPuedeTope() {
        assertThrows(IllegalStateException.class, () -> {
            Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();
            p.tope();
        }, "El método tope debería lanzar IllegalStateException en pilas vacias.");
    }

    public static void testApilarTope() {
        Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();
        p.apilar(3);
        assertEquals(3, p.tope(), "Se espera en el tope el último elemento apilado");
        assertEquals(false, p.esVacia(), "Se espera pila no vacia luego de aplilar");

    }

    public static void testApilarDesapilar() {
        Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();
        p.apilar(3);
        p.desapilar();
        assertEquals(true, p.esVacia(), "Apilar y desapilar en pila vacia, mantiene la pila vacia.");
    }

    public static void testGeneral() {
        Pila<Integer> p = new PilaDoblementeEnlazada<Integer>();
        assertEquals(true, p.esVacia(), "Se espera que una nueva pila sea vacía");
        p.apilar(1);
        assertEquals(false, p.esVacia(), "Se espera pila no vacia luego de apilar");
        p.apilar(2);
        p.apilar(3);

        assertEquals(3, p.tope(), "Se esperaba el último 3 apilado");
        p.desapilar();
        assertEquals(2, p.tope(), "Se esperaba el 2 apilado");
        p.desapilar();
        assertEquals(1, p.tope(), "Se esperaba el 1 apilado");
        p.desapilar();
        assertEquals(true, p.esVacia(), "Se espera que la pila esté vacía luego de desapilar todo");
    }

    public static void main(String[] args) {
        testPilaNuevaEstaVacia();
        testPilaVaciaNoPuedeDesapilar();
        testPilaVaciaNoPuedeTope();
        testApilarTope();
        testApilarDesapilar();
        testGeneral();
    }

}
