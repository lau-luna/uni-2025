-- =============================================================================
-- PARCIAL MODELO - PROGRAMACIÓN FUNCIONAL (Nivel Intermedio)
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________

-- Pregunta 1 - Tipado y evaluación (3 puntos)
-- Determinar el tipo y el resultado de las siguientes expresiones:

-- 1. (foldr (:) []) [1,2,3]
-- Tipo: [Int]
-- Resultado: [1,2,3]

-- 2. (map (+1) . filter even) [1,2,3,4]
-- Tipo: [Int]
-- Resultado: [3,5]

-- 3. (zipWith (*) [1,2,3] [4,5,6])
-- Tipo: [Int]
-- Resultado: [4,10,18]

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'insertarOrdenado' que inserta un elemento en una lista ordenada
-- Ej: insertarOrdenado 3 [1,2,4,5] = [1,2,3,4,5]
insertarOrdenado :: Ord a => a -> [a] -> [a]
insertarOrdenado x [] = [x]
insertarOrdenado x (y:ys) = if x > y then y: (insertarOrdenado x ys) else x: y : ys  

-- (b) Implementar la función 'aplanar' que aplana una lista de listas
-- Ej: aplanar [[1,2],[3],[4,5]] = [1,2,3,4,5]
aplanar :: [[a]] -> [a]
aplanar [] = []
aplanar (x:xs) = x ++ aplanar xs

-- Pregunta 3 - Funciones de orden superior (3 puntos)

-- Implementar la función 'mapearPropio' (versión propia de map)
-- Ej: mapearPropio (*2) [1,2,3] = [2,4,6]
mapearPropio :: (a -> b) -> [a] -> [b]
mapearPropio _ [] = []
mapearPropio f xs = [f (head xs)] ++ mapearPropio f (tail xs)

-- BONUS (2 puntos)
-- ¿Qué diferencia hay entre foldl y foldr? Dé un ejemplo donde se note la diferencia
-- foldl ascocia a la izquierda y follr asocia a la derecha. En donde más se puede notar la diferencia es en las funciones que no son conmutativas, por ejemplo con la resta.
-- foldl (-) 2 [4,5] = ((2 - 4) - 5) = (-2 - 5) = -7
-- foldr (-) 2 [4,5] = (4 - (5 - 2)) = (4 - 3) = 1
