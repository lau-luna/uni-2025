public class PruebaEstado extends Prueba {

    public static void testNoSePuedeConsultarEnEstadoVacio() {
        assertThrows(IllegalStateException.class, () -> {
            Estado e = new EstadoVariables();
            e.consultar('p');
        }, "El método consultar debería lanzar IllegalStateException en variables no definidas.");
    }

    public static void testNoSePuedeConsultarVariablesNoValidas() {
        assertThrows(IllegalArgumentException.class, () -> {
            Estado e = new EstadoVariables();
            e.consultar('!');
        }, "El método consultar debería lanzar IllegalArgumentException en nombres de variables no válidos.");
    }

    public static void testNoSePuedeGuardarVariablesNoValidas() {
        assertThrows(IllegalArgumentException.class, () -> {
            Estado e = new EstadoVariables();
            e.guardar('0', true);
        }, "El método guardar debería lanzar IllegalArgumentException en nombres de variables no válidos.");
    }

    public static void testGuardarConsultar() {
        Estado e = new EstadoVariables();
        e.guardar('p', true);

        assertEquals(true, e.consultar('p'), "Se espera true para la variable p.");
    }

    public static void testGuardarYGuardar() {
        Estado e = new EstadoVariables();
        e.guardar('p', true);
        assertEquals(true, e.consultar('p'), "Se espera true para la variable p.");

        e.guardar('p', false);
        assertEquals(false, e.consultar('p'), "Se espera false para la variable p.");
    }

    public static void testGeneral() {
        Estado e = new EstadoVariables();

        boolean value = true;
        for (char c = 'a'; c <= 'z'; c++) {
            e.guardar(c, value);
            value = !value;
        }

        value = !value;
        for (char c = 'z'; c >= 'a'; c--) {
            assertEquals(value, e.consultar(c), "Valor incorrecto");
            value = !value;
        }
    }

    public static void main(String[] args) {
        testNoSePuedeConsultarEnEstadoVacio();
        testNoSePuedeConsultarVariablesNoValidas();
        testNoSePuedeGuardarVariablesNoValidas();
        testGuardarConsultar();
        testGuardarYGuardar();
        testGeneral();
    }
}
