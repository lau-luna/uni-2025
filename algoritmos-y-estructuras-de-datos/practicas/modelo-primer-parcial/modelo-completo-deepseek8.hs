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

-- 1. (take 2 . drop 1) "abcdef"
-- Tipo: [Char]

-- 2. (foldr (*) 1 . map (+1)) [1,2,3]
-- Tipo: Int

-- 3. (head . map snd . filter (odd . fst)) [(1,'a'), (2,'b'), (3,'c')]
-- Tipo: Char

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'longitud' que calcula la cantidad de elementos
-- Ej: longitud [1,2,3] = 3
longitud :: [a] -> Int
longitud [] = 0
longitud (x:xs) = 1 + longitud xs

-- (b) Implementar la función 'aplanar' que aplana una lista de listas
-- Ej: aplanar [[1,2],[3],[4,5]] = [1,2,3,4,5]
aplanar :: [[a]] -> [a]
aplanar [] = []
aplanar (x:xs) = x ++ aplanar xs

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'dividirEn' que divide una lista en la posición n
-- Ej: dividirEn 2 [1,2,3,4,5] = ([1,2],[3,4,5])
dividirEn :: Int -> [a] -> ([a], [a])
dividirEn n xs = ((take n xs), (drop n xs))

-- =============================================================================
-- PARTE 2 - PROGRAMACIÓN OO y TADS  
-- =============================================================================

-- Pregunta 4 - Colas Circulares con Arreglos (4 puntos)

-- Implementar una cola circular usando arreglos:

-- public class ColaCircular<T> {
--     private T[] elementos;
--     private int frente;
--     private int fin;
--     private int cantidad;
--     private static final int CAPACIDAD = 10;
--     
--     public ColaCircular() {
--         elementos = (T[]) new Object[CAPACIDAD];
--         frente = 0;
--         fin = 0;
--         cantidad = 0;
--     }
--     
--     // Encolar un elemento
--     public void encolar(T elemento) {
--         if (estaLlena()) {
--             throw new RuntimeException("Cola llena");
--         }
--         elementos[fin] = elemento;
--         fin = (fin+1) % CAPACIDAD;
--         cantidad++;
--     }
--     
--     // Desencolar un elemento
--     public T desencolar() {
--         if (esVacia()) {
--             throw new RuntimeException("Cola vacía");
--         }
--         T elemento = elementos[frente];
--         frente = (frente+1) % CAPACIDAD;
--         cantidad--;
--         return elemento;
--     }
--     
--     public boolean esVacia() {
--         return cantidad == 0;
--     }
--     
--     public boolean estaLlena() {
--         return cantidad == CAPACIDAD;
--     }
-- }

-- (b) ¿Por qué se llama "circular" esta implementación?
-- Esta implementación se llama circular porque usa aritmetica modular para calcular las posiciones de frente y fin en el arreglo. Cuando se suma 1 a la posición actual, se calcula el modulo con la capacidad: esto hace que si se llegó al fin del arreglo, el próximo elemento será colocado en la primera posición del arreglo. Esto provoca que el arreglo tenga una apariencia circular.
--
-- =============================================================================
-- Pregunta BONUS (2 puntos)
-- =============================================================================

-- ¿Qué es el principio de encapsulamiento en POO? Dé un ejemplo.
-- El principio de encapsulamiento en POO se refiere a la darle una visibilidad adecuada a los atributos y métodos de una clase. Esto para evitar que otras clases tengan control sobre cosas que no debería, evitando así muchos problemas.
-- FIN DEL PARCIAL
