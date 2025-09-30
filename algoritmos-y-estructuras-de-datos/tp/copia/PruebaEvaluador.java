public class PruebaEvaluador extends Prueba {

    private static Estado eTrues() {
        Estado e = new EstadoVariables();
        e.guardar('p', true);
        e.guardar('q', true);

        return e;
    }

    private static Estado eFalses() {
        Estado e = new EstadoVariables();
        e.guardar('p', false);
        e.guardar('q', false);

        return e;
    }

    private static Estado eMix1() {
        Estado e = new EstadoVariables();
        e.guardar('p', true);
        e.guardar('q', false);

        return e;
    }

    private static Estado eMix2() {
        Estado e = new EstadoVariables();
        e.guardar('p', false);
        e.guardar('q', true);

        return e;
    }

    private static void testNombreVarIncorrecto() {
        assertThrows(IllegalArgumentException.class, () -> {
            Evaluador eval = new EvaluadorPrefijo();
            eval.setEstado(eMix1());
            eval.evaluar("AND q 2");
        }, "Se esperaba IllegalArgumentException para (AND q 2).");
    }

    private static void testOperadorIncorrecto() {
        assertThrows(IllegalArgumentException.class, () -> {
            Evaluador eval = new EvaluadorPrefijo();
            eval.setEstado(eMix1());
            eval.evaluar("AND q ORR p q");
        }, "Se esperaba IllegalArgumentException para (AND q ORR p q).");
    }

    private static void testOperadoresTrueTrue() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eTrues());

        assertEquals(true, eval.evaluar("AND p q"), "Se espera true para (AND p q) con p=true y q=true");
        assertEquals(true, eval.evaluar("OR p q"), "Se espera true para (OR p q) con p=true y q=true");
        assertEquals(false, eval.evaluar("NOT p"), "Se espera false para (NOT p) con p=true y q=true");
    }

    private static void testOperadoresFalseFalse() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eFalses());

        assertEquals(false, eval.evaluar("AND p q"), "Se espera false para (AND p q) con p=false y q=false");
        assertEquals(false, eval.evaluar("OR p q"), "Se espera false para (OR p q) con p=false y q=false");
        assertEquals(true, eval.evaluar("NOT p"), "Se espera true para (NOT p) con p=false y q=false");
    }

    private static void testOperadoresTrueFalse() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix1());

        assertEquals(false, eval.evaluar("AND p q"), "Se espera false para (AND p q) con p=true y q=false");
        assertEquals(true, eval.evaluar("OR p q"), "Se espera true para (OR p q) con p=true y q=false");
        assertEquals(false, eval.evaluar("NOT p"), "Se espera false para (NOT p) con p=true y q=false");
    }

    private static void testOperadoresFalseTrue() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix2());

        assertEquals(false, eval.evaluar("AND p q"), "Se espera false para (AND p q) con p=false y q=true");
        assertEquals(true, eval.evaluar("OR p q"), "Se espera true para (OR p q) con p=false y q=true");
        assertEquals(true, eval.evaluar("NOT p"), "Se espera true para (NOT p) con p=false y q=true");
    }

    private static void testGeneral1() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix1());

        // Comprobamos: p and (q or p)
        // con el p=true, q=false, se espera: true

        assertEquals(true, eval.evaluar("AND p OR q p"), "Falló testGeneral1");
    }

    private static void testGeneral2() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix2()); // p=false, q=true

        // Expresión: (p ∧ q) ∨ (¬q)
        // Preorder: OR AND p q NOT q
        // Evaluación: (false ∧ true) ∨ (¬true) = false ∨ false = false

        assertEquals(false, eval.evaluar("OR AND p q NOT q"), "Falló testGeneral2");
    }

    private static void testGeneral3() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eTrues()); // p=true, q=true

        // Expresión: ¬(p ∨ q)
        // Preorder: NOT OR p q
        // Evaluación: ¬(true ∨ true) = ¬true = false

        assertEquals(false, eval.evaluar("NOT OR p q"), "Falló testGeneral3");
    }

    private static void testGeneral4() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eFalses()); // p=false, q=false

        // Expresión: (¬p) ∧ (q ∨ p)
        // Preorder: AND NOT p OR q p
        // Evaluación: (¬false) ∧ (false ∨ false) = true ∧ false = false

        assertEquals(false, eval.evaluar("AND NOT p OR q p"), "Falló testGeneral4");
    }

    private static void testGeneral5() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix1()); // p=true, q=false

        // Expresión: ¬((p ∧ q) ∨ (¬p))
        // Preorder: NOT OR AND p q NOT p
        // Evaluación: (true ∧ false) ∨ (¬true) = false ∨ false = false
        // Negación = true

        assertEquals(true, eval.evaluar("NOT OR AND p q NOT p"), "Falló testGeneral5");
    }

    private static void testGeneral6() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eTrues()); // p=true, q=true

        // Expresión: (p ∧ (¬q))
        // Preorder: AND p NOT q
        // Evaluación: true ∧ ¬true = true ∧ false = false

        assertEquals(false, eval.evaluar("AND p NOT q"), "Falló testGeneral6");
    }

    private static void testGeneral7() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eFalses()); // p=false, q=false

        // Expresión: (¬p) ∨ (¬q)
        // Preorder: OR NOT p NOT q
        // Evaluación: ¬false ∨ ¬false = true ∨ true = true

        assertEquals(true, eval.evaluar("OR NOT p NOT q"), "Falló testGeneral7");
    }

    private static void testGeneral8() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix1()); // p=true, q=false

        // Expresión: (p ∨ q) ∧ (¬q)
        // Preorder: AND OR p q NOT q
        // Evaluación: (true ∨ false) ∧ ¬false = true ∧ true = true

        assertEquals(true, eval.evaluar("AND OR p q NOT q"), "Falló testGeneral8");
    }

    private static void testGeneral9() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix2()); // p=false, q=true

        // Expresión: ¬(p ∧ (¬q))
        // Preorder: NOT AND p NOT q
        // Evaluación: ¬(false ∧ ¬true) = ¬(false ∧ false) = ¬false = true

        assertEquals(true, eval.evaluar("NOT AND p NOT q"), "Falló testGeneral9");
    }

    private static void testGeneral10() {
        Evaluador eval = new EvaluadorPrefijo();
        eval.setEstado(eMix1()); // p=true, q=false

        // Expresión: ( (p ∧ q) ∨ p )
        // Preorder: OR AND p q p
        // Evaluación: (true ∧ false) ∨ true = false ∨ true = true

        assertEquals(true, eval.evaluar("OR AND p q p"), "Falló testGeneral10");
    }

    public static void main(String[] args) {
        testNombreVarIncorrecto();
        testOperadorIncorrecto();

        // Tabla de Verdad
        testOperadoresTrueTrue();
        testOperadoresFalseFalse();
        testOperadoresTrueFalse();
        testOperadoresFalseTrue();

        // Comprobación de algunas expresiones lógicas
        testGeneral1();
        testGeneral2();
        testGeneral3();
        testGeneral4();
        testGeneral5();
        testGeneral6();
        testGeneral7();
        testGeneral8();
        testGeneral9();
        testGeneral10();
    }

}
