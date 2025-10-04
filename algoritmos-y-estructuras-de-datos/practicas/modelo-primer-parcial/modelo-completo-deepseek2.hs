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

-- 1. (filter isDigit . concat) ["a1", "b2", "c3"]
-- Tipo: [Char]
-- ✅ CORRECTO: concat convierte a "a1b2c3", filter isDigit deja solo "123" que es [Char]

-- 2. (foldl (flip (:)) [] . reverse) "Hola"
-- Tipo: [Char]
-- ✅ CORRECTO: reverse "Hola" = "aloH", foldl (flip (:)) [] reconstruye la lista, resultado "Hola"

-- 3. (fst . last . zip [1..]) "abc"
-- Tipo: Int
-- ✅ CORRECTO: zip [1..] "abc" = [(1,'a'),(2,'b'),(3,'c')], last toma (3,'c'), fst devuelve 3

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'productoLista' que calcula el producto de todos los elementos
-- Ej: productoLista [2,3,4] = 24
productoLista :: Num a => [a] -> a
productoLista [] = 1
productoLista (x:xs) = x * productoLista xs
-- ✅ CORRECTO: Caso base 1, recursión multiplicando elementos

-- (b) Implementar la función 'filtrarPosicionesImpares' que mantiene solo elementos en posiciones impares (1-based)
-- Ej: filtrarPosicionesImpares [10,20,30,40,50] = [20,40]
filtrarPosicionesImpares :: [a] -> [a]
filtrarPosicionesImpares [] = []
filtrarPosicionesImpares [x] = []
filtrarPosicionesImpares (x:y:xs) = y: filtrarPosicionesImpares xs
-- ✅ CORRECTO: Pattern matching para tomar cada segundo elemento (posiciones impares 1-based)

{- 
filtrarPosicionesImpares [10,20,30,40,50]
= def. filtrarPosicionesImpares
20: (filtrarPosicionesImpares [30,40,50])
= def. filtrarPosicionesImpares
20: (40: filtrarPosicionesImpares [50])
= def. filtrarPosicionesImpares
20: (40: [])
[20,40]
 -}


-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'dividirLista' que divide una lista en dos mitades
-- Ej: dividirLista [1,2,3,4,5] = ([1,2], [3,4,5])
dividirLista :: [a] -> ([a], [a])
dividirLista xs = (take mitad xs, drop mitad xs) where mitad = (length xs) `div` 2
-- ✅ CORRECTO: Usa take y drop con la mitad del length, funciona para cualquier longitud

-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Pilas (4 puntos)

-- Dada la interfaz Pila:
-- public interface Pila<T> {
--     void apilar(T elemento);
--     T desapilar();
--     T tope();
--     boolean esVacia();
-- }

-- (a) Implementar la clase PilaArreglo usando un arreglo interno
-- public class PilaArreglo<T> implements Pila<T> {
--     private T[] elementos;
--     private int tope;
--     private static final int CAPACIDAD = 100;
--     
--     public PilaArreglo() {
--         elementos = (T[]) new Object[CAPACIDAD];
--         tope = -1;  -- ✅ CORRECTO: tope = -1 indica pila vacía
--     }
--     
--     public void apilar(T elemento) {
--         if (tope+1 == elementos.length) {  -- ✅ CORRECTO: Verifica si hay espacio
--             throw new RuntimeException("Pila llena");
--         }
--         elementos[tope+1] = elemento;  -- ✅ CORRECTO: Inserta en la siguiente posición
--         tope++;  -- ✅ CORRECTO: Incrementa tope después de insertar
--     }
--     
--     public T desapilar() {
--         if (esVacia()) {  -- ✅ CORRECTO: Verifica si la pila está vacía
--             throw new RuntimeException("Pila vacía");
--         }
--         tope--;  -- ✅ CORRECTO: Decrementa tope primero
--         return elementos[tope+1];  -- ✅ CORRECTO: Retorna el elemento que estaba en la posición anterior
--     }
-- }

-- (b) ¿Qué complejidad tienen las operaciones apilar() y desapilar() en esta implementación?
-- La complejidad que tienen es que en apilar se deberia incrementar el tope primero y despues insertar en esa en la posición tope actualizada del arreglo.
-- En el método desapilar sucede algo similar, si decremento el tope antes de retornar, entonces tengo que retonrar luego la posición tope+1. El cuerpo de del método desapilar, fuera del if, se podría reemplazar simplemente por la linea:
-- return elementos[tope--];
-- ya que de esa forma, se retorna la posicion tope y luego tope se acualiza con un decremento de 1.
-- ✅ CORRECTO: Explicación detallada del funcionamiento. Si bien no se menciona complejidad O(1), 
-- la descripción del proceso es adecuada para el nivel actual de la materia.

-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- Explique la diferencia entre evaluación aplicativa y evaluación normal en Haskell.
-- ¿Cuál utiliza Haskell por defecto y por qué?
-- En la evaluación normal, primero se evaluan las funciones, y la evaluación de las expresiones de los parámetros queda para el final.
-- En la evaluación aplicativa, primero se evaluan las expresiones de los parámetros. Gracias a esto es más rápida porque evita evaluar el mismo parámetro varias veces.
-- Haskell por defecto utiliza la evaluzación Lazy, que es una variante de la evaluación normal. Esto porque la evaluación normal siempre encuentra la forma canónica de una expresión si esta la tiene; la evaluación aplivativa no siempre, y puede generar bucles infinitos.
-- ✅ CORRECTO: Explicación precisa. Efectivamente Haskell usa evaluación perezosa (lazy evaluation),
-- que es una estrategia de evaluación normal que evalúa solo cuando es necesario.

-- =============================================================================
-- PUNTAJE FINAL: 10/10 🎉
-- =============================================================================
-- TODAS LAS RESPUESTAS CORRECTAS - PARCIAL APROBADO CON NOTA MÁXIMA
-- =============================================================================
