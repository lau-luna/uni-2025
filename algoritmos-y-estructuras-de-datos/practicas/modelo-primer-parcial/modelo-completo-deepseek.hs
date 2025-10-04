-- =============================================================================
-- 1er PARCIAL - ALGORITMOS Y ESTRUCTURAS DE DATOS I (3378)
-- =============================================================================

-- Nombre y Apellido: _________________________
-- DNI: _______________
-- Comisión: __________

-- INSTRUCCIONES: Resolver de manera individual. Se tendrá en cuenta la claridad.

-- =============================================================================
-- PARTE 1 - PROGRAMACIÓN FUNCIONAL (Haskell)
-- =============================================================================

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo resultante de las siguientes expresiones:

-- 1. (take 2 . drop 1) [5,4,3,2,1]
-- Tipo: [Int]

-- 2. (foldr max 0 . map abs) [-3, 2, -5, 1]
-- Tipo: Int

-- 3. (snd . head . filter (odd . fst)) [(1,'a'), (2,'b'), (3,'c')]
-- Tipo: Char

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'sumaCuadrados' que suma los cuadrados de los elementos
-- Ej: sumaCuadrados [1,2,3] = 14
sumaCuadrados :: Num a => [a] -> a
sumaCuadrados [] = 0
sumaCuadrados (x:xs) = (x*x) + sumaCuadrados xs

-- (b) Implementar la función 'estaOrdenada' que verifica si una lista está ordenada ascendentemente
-- Ej: estaOrdenada [1,3,5] = True
-- Ej: estaOrdenada [1,5,3] = False
estaOrdenada :: Ord a => [a] -> Bool
estaOrdenada [] = True
estaOrdenada [x] = True
estaOrdenada (x:y:xs) = if x > y then False else estaOrdenada (y:xs) 

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'alternar' que alterna elementos de dos listas
-- Ej: alternar [1,2,3] [4,5,6] = [1,4,2,5,3,6]
-- Si una lista es más larga, agregar los elementos restantes al final
alternar :: [a] -> [a] -> [a]
alternar [] ys = ys
alternar xs [] = xs
alternar (x:xs) (y:ys) = x:y: alternar xs ys

{- 
alternar [1,2] [3,4,5,6]
def. alternar
1:(3: alternar [2] [4,5,6])
def. alternar
1:(3: (2: (4: (alternar [] [5,6]))))
def. alternar
1:(3: (2: (4: [5,6])))
[1,3,2,4,5,6]

alternar [1,2,3] [4]
def. alternar
1:(4: alternar [2,3] [])
def. alternar
1:(4: [2,3])
[1,4,2,3]
 -}


-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS
-- =============================================================================

-- Pregunta 4 - Listas Enlazadas (4 puntos)

-- Dada la siguiente clase Nodo:
-- public class Nodo<T> {
--     private T dato;
--     private Nodo<T> siguiente;
--     
--     public T getDato() { return dato; }
--     public Nodo<T> getSiguiente() { return siguiente; }
--     public void setSiguiente(Nodo<T> sig) { siguiente = sig; }
-- }

-- Y la clase ListaEnlazada:
-- public class ListaEnlazada<T> {
--     private Nodo<T> cabeza;
--     private int cantidad;
--     
--     public boolean esVacia() { return cantidad == 0; }
-- }

-- (a) Implementar el método 'agregarAlFinal' que agrega un elemento al final de la lista
-- public void agregarAlFinal(T elemento) {
--     if (this.esVacia()) {
--         cabeza = new Nodo<T>(elemento);
--     } else {
--         Nodo<T> aux = cabeza;
--         while (aux.getSiguiente() != null) {
--             aux = aux.getSiguiente();
--         }
--         aux.setSiguiente(new Nodo<T>(elemento));
--     }
--     cantidad++;
-- }

-- (b) Implementar el método 'contiene' que devuelve true si el elemento está en la lista
-- public boolean contiene(T elemento) {
--     Nodo<T> aux = cabeza;
--     while (aux != null) {
--         if (aux.getDato().equals(elemento)) {
--             return true;
--         }
--         aux = aux.getSiguiente();
--     }
--     return false;
-- }

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- ¿Qué ventajas tiene el uso de TADs (Tipos Abstractos de Datos) en programación?
-- El uso de TADs nos permite realizar operaciones más complejas que con las estructuras de datos brindadas por los lenguajes normalmente no podríamos. Por ejemplo, los arreglos tienen un tamaño fijo, pero con un TAD lista podemos crear listas dinámicas, incluso con arreglos. Y esto confluye en la posibilidad de relizar tareas de una manera mucho más simple. Además, los TADs generalmente se hacen genéricos, por lo tanto servirían para cualquier tipo y se ahorraría mucho código.

-- FIN DEL PARCIAL
