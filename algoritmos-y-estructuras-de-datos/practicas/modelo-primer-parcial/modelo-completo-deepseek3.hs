-- =============================================================================
-- 1er PARCIAL - ALGORITMOS Y ESTRUCTURAS DE DATOS I (3378)
-- =============================================================================

-- Nombre y Apellido: _________________________
-- DNI: _______________
-- Comisión: __________

-- =============================================================================
-- PARTE 1 - PROGRAMACIÓN FUNCIONAL (Haskell)
-- =============================================================================

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo resultante de las siguientes expresiones:

-- 1. (map toUpper . filter isLetter) "a1b2c3"
-- Tipo: [Char]

-- 2. (foldr (*) 1 . take 3) [2,3,4,5]
-- Tipo: Int

-- 3. (head . map length . group) "aabbbcc"
-- Tipo: Int

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'contarApariciones' que cuenta cuántas veces aparece un elemento
-- Ej: contarApariciones 2 [1,2,3,2,1] = 2
contarApariciones :: Eq a => a -> [a] -> Int
contarApariciones _ [] = 0
contarApariciones x (y:ys) = if x == y then 1 + contarApariciones x ys else contarApariciones x ys

{- 
 contarApariciones 2 [1,2,3,2,1]
= def. contarApariciones
contarApariciones 2 [2,3,2,1]
= def. contarApariciones
1 + (contarApariciones 2 [3,2,1])
= def. contarApariciones
1 + (contarApariciones 2 [2,1])
= def. contarApariciones
1 + (1 + (contarApariciones 2 [1]))
= def. contarApariciones
1 + (1 + (contarApariciones 2 []))
= def. contarApariciones
1 + (1 + (0))
2
 -}


-- (b) Implementar la función 'tomarHasta' que toma elementos hasta que se cumple una condición
-- Ej: tomarHasta (>5) [1,3,7,2,4] = [1,3]
tomarHasta :: (a -> Bool) -> [a] -> [a]
tomarHasta _ [] = []
tomarHasta f (x:xs) = if not (f x) then x: tomarHasta f xs else []

{-
 tomarHasta (>5) [1,3,7,2,4]
= def. tomarHasta
1:( tomarHasta (>5) [3,7,2,4]) 
= def. tomarHasta
1:(3: (tomarHasta (>5) [7,2,4])) 
= def. tomarHasta
1:(3: ([]) 
[1,3]
 -}


-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'rotarIzquierda' que rota una lista n posiciones a la izquierda
-- Ej: rotarIzquierda 2 [1,2,3,4,5] = [3,4,5,1,2]
rotarIzquierda :: Int -> [a] -> [a]
rotarIzquierda n xs = drop n xs ++ take n xs 

{-
rotarIzquierda 2 [1,2,3,4,5]
= def. rotarIzquierda
drop 2 [1,2,3,4,5] ++ take 2 [1,2,3,4,5]
= def. drop
[3,4,5] ++ take 2 [1,2,3,4,5]
= def. take
[3,4,5] ++ [1,2]
= def. ++
[3,4,5,1,2]
 -}



-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Implementación de Cola con Nodos (4 puntos)

-- Dada la clase Nodo:
-- public class Nodo<T> {
--     private T dato;
--     private Nodo<T> siguiente;
--     
--     public Nodo(T dato) { this.dato = dato; this.siguiente = null; }
--     public T getDato() { return dato; }
--     public Nodo<T> getSiguiente() { return siguiente; }
--     public void setSiguiente(Nodo<T> sig) { siguiente = sig; }
-- }

-- Implementar la clase ColaNodos (SOLO con frente - más simple y correcta):

-- public class ColaNodos<T> {
--     private Nodo<T> frente;
--     private int cantidad;
--     
--     public ColaNodos() {
--         frente = null;
--         cantidad = 0;
--     }
--     
--     public void encolar(T elemento) {
--         Nodo<T> nuevo = new Nodo<T>(elemento);
--         if (frente == null) {
--             frente = nuevo;
--         } else {
--             Nodo<T> actual = frente;
--             while (actual.getSiguiente() != null) {
--                 actual = actual.getSiguiente();
--             }
--             actual.setSiguiente(nuevo);
--         }
--         cantidad++;
--     }
--     
--     public T desencolar() {
--         if (esVacia()) {
--             throw new RuntimeException("Cola vacía");
--         }
--         T dato = frente.getDato();
--         frente = frente.getSiguiente();
--         cantidad--;
--         return dato;
--     }
--     
--     public boolean esVacia() {
--         return this.cantidad == 0;
--     }
-- }

-- (b) ¿Qué operación es menos eficiente en esta implementación y por qué?
-- La operación menos eficiente en esta lista es la de enconlar, porque se tiene que recorrer toda la lista de nodos y colocar el nodo nuevo al final. Esto se podría solucionar si se usan nodos con referencias de siguiente y anterior, y en la clase cola se crea una nueva referencia fin; de esa forma, se encola en el fin y se desencola el frente

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- ¿Qué es el polimorfismo paramétrico en Haskell? Dé un ejemplo.
-- El polimorfismo paramétrico es cuando una funcion puede funcionar para varios tipos de datos, sin especificar. Por ejemplo
-- (.) :: (b ->c) ->(a ->b) ->(a ->c)
-- (.) g f x = g(f(x))
-- a, b, y c representan tipos de datos genéricos. Pueden ser cualquiera.

-- FIN DEL PARCIAL
