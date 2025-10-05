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

-- 1. (filter isUpper . concat) ["Ab", "Cd", "Ef"]
-- Tipo: [Char]

-- 2. (foldr max 0 . map abs) [-3, 2, -5]
-- Tipo: Int

-- 3. (snd . last . filter (even . fst)) [(1,'a'), (2,'b'), (3,'c')]
-- Tipo: Char

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'contarVerdaderos' que cuenta cuántos elementos son True
-- Ej: contarVerdaderos [True, False, True] = 2
contarVerdaderos :: [Bool] -> Int
contarVerdaderos [] = 0
contarVerdaderos (x:xs) = if x == True then 1 + contarVerdaderos xs else contarVerdaderos xs

-- (b) Implementar la función 'tomarMientras' que toma elementos mientras cumplan una condición
-- Ej: tomarMientras (<5) [1,3,7,2,4] = [1,3]
tomarMientras :: (a -> Bool) -> [a] -> [a]
tomarMientras _ [] = []
tomarMientras f (x:xs) = if f x then x : tomarMientras f xs else []

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'eliminarCadaN' que elimina cada n-ésimo elemento (0-based)
-- Ej: eliminarCadaN 2 [0,1,2,3,4,5] = [0,1,3,4]  (elimina posiciones 2 y 5)
eliminarCadaN :: Int -> [a] -> [a]
eliminarCadaN n xs = take (n) xs ++ (if length (drop (n+1) xs) == 0 then [] else eliminarCadaN n (drop (n+1) xs))

{- 
 eliminarCadaN 2 [0,1,2,3,4,5]
= def. eliminarCadaN
take 2 [0,1,2,3,4,5] ++ eliminarCadaN 2 (drop 2+1 [0,1,2,3,4,5])
= def. take
[0,1] ++ eliminarCadaN 2 (drop 3 [0,1,2,3,4,5])
= aritmetica
[0,1] ++ eliminarCadaN 2 (drop 3 [0,1,2,3,4,5])
= def. drop
[0,1] ++ eliminarCadaN 2 [3,4,5]
= def. eliminarCadaN
[0,1] ++ (take 2 [3,4,5] ++ eliminarCadaN 2 (drop 2+1 [3,4,5]))
= def. take
[0,1] ++ ([3,4] ++ eliminarCadaN 2 (drop 2+1 [3,4,5]))
= aritmetica
[0,1] ++ ([3,4] ++ eliminarCadaN 2 (drop 3 [3,4,5]))
= def. drop
[0,1] ++ ([3,4] ++ eliminarCadaN 2 [])
= def. eliminarCadaN
[0,1] ++ ([3,4] ++ [])
[0,1,3,4]
 -}


-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Listas Enlazadas con Ficticio (4 puntos)

-- Dada la clase Nodo:
-- public class Nodo<T> {
--     private T dato;
--     private Nodo<T> siguiente;
--     
--     public Nodo(T dato) { 
--         this.dato = dato; 
--         this.siguiente = null; 
--     }
--     public T getDato() { return dato; }
--     public Nodo<T> getSiguiente() { return siguiente; }
--     public void setSiguiente(Nodo<T> sig) { siguiente = sig; }
-- }

-- Implementar la clase ListaConFicticio:

-- public class ListaConFicticio<T> {
--     private Nodo<T> ficticio;
--     private int cantidad;
--     
--     public ListaConFicticio() {
--         ficticio = new Nodo<T>(null);  // Nodo ficticio
--         cantidad = 0;
--     }
--     
--     // Insertar al inicio (después del ficticio)
--     public void insertarInicio(T elemento) {
--         Nodo<T> nuevo = new Nodo<T>(elemento);
--         nuevo.setSiguiente(ficticio.getSiguiente());
--         ficticio.setSiguiente(nuevo);
--         cantidad++;
--     }
--     
--     // Buscar un elemento
--     public boolean contiene(T elemento) {
--         Nodo<T> actual = ficticio.getSiguiente();
--         while (actual != null) {
--             if (elemento.equals(actual.getDato())) {
--                 return true;
--             }
--             actual = actual.getSiguiente();
--         }
--         return false;
--     }
--     
--     // Eliminar el primer elemento (después del ficticio)
--     public void eliminarPrimero() {
--         if (!esVacia()) {
--             ficticio.setSiguiente(ficticio.getSiguiente().getSiguiente());
--             cantidad--;
--         }
--     }
--     
--     public boolean esVacia() {
--         return ficticio.getSiguiente == null;
--     }
-- }

-- (b) ¿Qué ventaja tiene usar un nodo ficticio?
-- Simplifica muchas operaciones, al usar sólamente setSiguiente y getSiguiente y no tener que ver tanto las referencias de punteros como cabeza.

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- Explique qué son las funciones de orden superior y dé un ejemplo en Haskell.
-- Las funciones de orden superior son funciones que tomal al menos una funcion como parámentro, también pueden devolver otras funciones.
-- Un ejemplo en Haskell sería la función curry, que toma una funcion sin currificar como parámetro, y devuelve esa misma función, pero curryficada.

-- FIN DEL PARCIAL
