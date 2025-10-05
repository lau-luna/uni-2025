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

-- 1. (take 3 . cycle) "ab"
-- Tipo: [Char]

-- 2. (sum . map snd) [(1,2), (3,4), (5,6)]
-- Tipo: Int

-- 3. (head . tails) "abc"    -- tails?
-- Tipo: [Char]

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'revertir' que invierte una lista
-- Ej: revertir [1,2,3] = [3,2,1]
revertir :: [a] -> [a]
revertir [] = []
revertir (x:xs) = revertir xs ++ [x]

-- (b) Implementar la función 'existe' que verifica si algún elemento cumple una condición
-- Ej: existe even [1,3,5,2] = True
existe :: (a -> Bool) -> [a] -> Bool
existe _ [] = False
existe f (x:xs) = if not (f x) then existe f xs else True

{-  
 existe even [1,3,5,2]
= def. existe
existe f [3,5,2]
= def. existe
existe f [5,2]
= def. existe
existe f [2]
= def. existe
True
 -}


-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'agruparPares' que toma elementos en posiciones pares (0-based)
-- Ej: agruparPares [0,1,2,3,4] = [0,2,4]
agruparPares :: [a] -> [a]
agruparPares [] = []
agruparPares [x] = [x]
agruparPares (x:_:xs) = x: agruparPares xs

-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Listas Enlazadas Simples (4 puntos)

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

-- Implementar la clase ListaSimple:

-- public class ListaSimple<T> {
--     private Nodo<T> cabeza;
--     private int cantidad;
--     
--     public ListaSimple() {
--         cabeza = null;
--         cantidad = 0;
--     }
--     
--     // Insertar al inicio de la lista
--     public void insertarInicio(T elemento) {
--         Nodo<T> nuevo = new Nodo<T>(elemento);
--         nuevo.setSiguiente(cabeza);
--         cabeza = nuevo;
--         cantidad++;
--     }
--     
--     // Buscar un elemento y devolver su posición (0-based) o -1 si no existe
--     public int buscar(T elemento) {
--         Nodo<T> actual = cabeza;
--         int posicion = 0;
--         while (actual != null) {
--             if (elemento.equals(actual.getDato())) {
--                 return posicion;
--             }
--             actual = actual.getSiguiente();
--             posicion++;
--         }
--         return -1;
--     }
----     
--     // Eliminar el primer elemento
--     public void eliminarPrimero() {
--         if (cantidad > 0) {
--             cabeza = cabeza.getSiguiente();
--             cantidad--;
--         }
--     }
-- }

-- (b) ¿Qué complejidad tienen estas operaciones?
-- Eu igual acá te dije que no vi complejidad en la materia chee
-- Igual voy a intentar, pero no me lo tendrias que contar a esto
-- insertarInicio: O(1)
-- buscar: O(n)  
-- eliminarPrimero: O(1)

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- ¿Qué es el currying en Haskell? Dé un ejemplo práctico.
-- El currying en Haskell es el proceso de tomar una funcion que toma dos parámetros juntos (par ordenado) y transformarla a una funcion que toma un sólo parámetro a la vez. Por ejemplo, tengo una función:
-- sumaParOrdenado :: (Int,Int) ->Int
-- sumaParOrdenado par = fst par + snd par
--
-- si la currifico:
-- el perfil se transformaria a
-- :t curry sumaParOrdenado = Int ->Int ->Int
-- y se podria usar asi:
-- curry sumaParOrdenado 1 1 = 2

-- FIN DEL PARCIAL
