public abstract class Prueba {
    // Metodo auxiliar
    public static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            System.err.println(message + " Expected: " + expected + ", but got: " + actual);
            System.exit(1);
        }
    }

    // Metodo auxiliar
    public static void assertNull(Object object, String message) {
        if (object != null) {
            System.err.println(message);
            System.exit(1);
        }
    }

    // Metodo auxiliar
    public static void assertThrows(Class<? extends Throwable> expectedException, Runnable runnable, String message) {
        try {
            runnable.run();
            System.err.println(
                    message + " Expected exception: " + expectedException.getName() + ", but none was thrown.");
            System.exit(1);
        } catch (Throwable actualException) {
            if (!expectedException.isInstance(actualException)) {
                System.err.println(message + " Expected: " + expectedException.getName() + ", but got: "
                        + actualException.getClass().getName());
                System.exit(1);
            }
        }
    }
}
