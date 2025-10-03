-- =============================================================================
-- PARCIAL MODELO - PROGRAMACIÓN FUNCIONAL (Haskell)   -- hecho por deepseek
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo de las siguientes expresiones:

-- 1. (map (+1) . filter even) [1,2,3,4]
-- Tipo: [Int]

-- 2. (foldr (+) 0 . take 5) [1..10]
-- Tipo: Int

-- 3. (head . map snd) [(1,'a'), (2,'b')]
-- Tipo: Char

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'sumaPares' que suma todos los números pares de una lista
-- Ej: sumaPares [1,2,3,4,5] = 6
sumaPares :: [Int] -> Int
sumaPares [] = 0
sumaPares (x:xs) = if even x then x + sumaPares xs else sumaPares xs

-- (b) Implementar la función 'tomarMientras' que toma elementos mientras cumplan una condición
-- Ej: tomarMientras (<5) [1,3,7,2,4,6] = [1,3]
tomarMientras :: (a -> Bool) -> [a] -> [a]
tomarMientras _ [] = []
tomarMientras f (x:xs) = if f x then x : tomarMientras f xs else []

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'intercalar' que intercala dos listas
-- Ej: intercalar [1,3,5] [2,4,6] = [1,2,3,4,5,6]
intercalar :: [a] -> [a] -> [a]
intercalar [] ys = ys
intercalar xs [] = xs
intercalar (x:xs) (y:ys) = x: y: intercalar xs ys

-- BONUS (2 puntos)
-- Explicar qué es la EVALUACIÓN DIFERIDA (lazy evaluation) en Haskell y dar un ejemplo.
-- La Lazy Evaluation es la forma que utiliza haskell para evaluar expresiones y llegar a su forma canónica
-- Es muy similar a la evaluación local, pero utiliza definiciones locales para evaluar la misma expresion sólo una vez
-- Un ejemplo sería
-- pow 2 2 * pow 2 2
-- = def. *
-- x * x
-- where x = pow 2 2
-- = def. pow
-- x * x
-- where x = 2 * 2
-- = aritmetica
-- x * x
-- where x = 4
-- = reemplazo def. local
-- 4 * 4
-- = aritmetica
-- 16
--
--
-- BONUS (2 puntos)
-- Explicación: ❌ Esto describe "evaluación perezosa con sharing", no lazy evaluation general
-- La evaluación diferida (lazy evaluation) significa que las expresiones solo se evalúan cuando se necesitan
-- Ejemplo correcto: 
-- take 3 [1..]  -- Esto funciona aunque [1..] es infinita, porque solo evalúa lo necesario
