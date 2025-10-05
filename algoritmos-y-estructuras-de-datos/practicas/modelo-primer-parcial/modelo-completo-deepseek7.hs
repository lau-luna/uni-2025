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

-- 1. (map toLower . filter isAlpha) "A1b2C3"
-- Tipo: [Char]

-- 2. (foldl (flip (:)) [] . reverse) [1,2,3]
-- Tipo: [Int]

-- 3. (fst . head . drop 1) [(1,'a'), (2,'b'), (3,'c')]
-- Tipo: Int

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'productoPositivos' que multiplica solo los números positivos
-- Ej: productoPositivos [2, -1, 3, -4] = 6
productoPositivos :: [Int] -> Int
productoPositivos [] = 1
productoPositivos (x:xs) = if x > 0 then x * productoPositivos xs else productoPositivos xs 

-- (b) Implementar la función 'repetirLista' que repite cada elemento n veces
-- Ej: repetirLista 2 [1,2,3] = [1,1,2,2,3,3]
repetirLista :: Int -> [a] -> [a]
repetirLista _ [] = []
repetirLista n (x:xs) = take n (repeat x) ++ repetirLista n xs

{-
2 [1,2,3]
=def. repetirLista
take 2 (repeat [1]) ++ repetirLista 2 [2,3]
=def. take y repeat
[1,1] ++ repetirLista 2 [2,3]
=def. repetirLista
[1,1] ++ take 2 (repeat [2]) ++ repetirLista 2 [3]
=def. take y repeat
[1,1] ++ [2,2] ++ repetirLista 2 [3]
=def. repetirLista
[1,1] ++ [2,2] ++ take 2 (repeat [3]) ++ repetirLista 2 []
=def. take y repeat
[1,1] ++ [2,2] ++ [3,3] ++ repetirLista 2 []
=def. repetirLista
[1,1] ++ [2,2] ++ [3,3] ++ []
[1,1,2,2,3,3]
-
 -}

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'rotarDerecha' que rota una lista n posiciones a la derecha
-- Ej: rotarDerecha 2 [1,2,3,4,5] = [4,5,1,2,3]
rotarDerecha :: Int -> [a] -> [a]
rotarDerecha n xs = drop (length xs - n) xs ++ take (length xs - n) xs 

{- 
 rotarDerecha 2 [1,2,3,4,5]
=def. rotarDerecha
drop (2+1) [1,2,3,4,5] ++ take (2+1) [1,2,3,4,5]
= artimetica
drop 3 [1,2,3,4,5] ++ take 3 [1,2,3,4,5]
= def. drop
[4,5] ++ [1,2,3]
= def. ++
[4,5,1,2,3]
 -}


-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Listas Doblemente Enlazadas (4 puntos)

-- Dada la clase NodoDoble:
-- public class NodoDoble<T> {
--     private T dato;
--     private NodoDoble<T> anterior;
--     private NodoDoble<T> siguiente;
--     
--     public NodoDoble(T dato) { 
--         this.dato = dato; 
--         this.anterior = null;
--         this.siguiente = null;
--     }
--     public T getDato() { return dato; }
--     public NodoDoble<T> getAnterior() { return anterior; }
--     public NodoDoble<T> getSiguiente() { return siguiente; }
--     public void setAnterior(NodoDoble<T> ant) { anterior = ant; }
--     public void setSiguiente(NodoDoble<T> sig) { siguiente = sig; }
-- }

-- Implementar la clase ListaDoble:

-- public class ListaDoble<T> {
--     private NodoDoble<T> cabeza;
--     private NodoDoble<T> cola;
--     private int cantidad;
--     
--     public ListaDoble() {
--         cabeza = null;
--         cola = null;
--         cantidad = 0;
--     }
--     
--     // Insertar al final
--     public void insertarFin(T elemento) {
--         NodoDoble<T> nuevo = new NodoDoble<T>(elemento);
--         if (esVacia()) {
--             cabeza = nuevo;
--             cola = nuevo;
--         } else {
--             nuevo.setAnterior(cola);
--             cola.setSiguiente(nuevo);
--             cola = nuevo;
--         }
--         cantidad++;
--     }
--     
--     // Eliminar el último elemento
--     public void eliminarUltimo() {
--         if (!esVacia()) {
--             if (cantidad == 1) {  // Solo un elemento
--                 cabeza = null;
--                 cola = null;
--             } else {
--                 cola.getAnterior().setSiguiente(null);
--                 cola = cola.getAnterior();
--             }
--             cantidad--;
--         }
--     }
--     
--     public boolean esVacia() {
--         return cantidad == 0;
--     }
-- }

-- (b) ¿Qué ventaja tiene una lista doblemente enlazada sobre una simple?
-- La ventaja que tiene es que se puede acceder fácilmente y modificar los nodos anteriores, permitiendo poder avanzar en ambas direcciones en la lista, esto simplifica mucho las operaciones en el código.

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- ¿Qué es la evaluación perezosa (lazy evaluation) en Haskell y qué ventajas tiene?
-- La Lazy evaluation en Haskell es una variante de la evaluación normal, que sólo evalúa una expresión cuando la necesita. La ventaja que tiene es que siempre encuentra la forma canónica de la expresión si ésta existe, y además al utilizar definiciones locales, evita tener que calcular/evaluar la misma expresión dos veces.

-- FIN DEL PARCIAL
