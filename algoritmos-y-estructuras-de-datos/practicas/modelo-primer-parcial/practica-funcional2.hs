-- =============================================================================
-- PARCIAL MODELO 2 - PROGRAMACIÓN FUNCIONAL (Haskell)
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo de las siguientes expresiones:

-- 1. (length . filter isDigit) "abc123def"
-- Tipo: Int

-- 2. (zipWith max [1,2,3] . repeat) 5
-- Tipo: ________

-- 3. (curry fst) (10, True)
-- Tipo: Int

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'contarOcurrencias' que cuenta cuántas veces aparece un elemento
-- Ej: contarOcurrencias 2 [1,2,3,2,1,2] = 3
contarOcurrencias :: Eq a => a -> [a] -> Int
contarOcurrencias _ [] = 0
contarOcurrencias x (y:ys) = if x == y then 1 + contarOcurrencias x ys else contarOcurrencias x ys

-- (b) Implementar la función 'reemplazar' que reemplaza todas las ocurrencias de un valor por otro
-- Ej: reemplazar 2 9 [1,2,3,2,1] = [1,9,3,9,1]
reemplazar :: Eq a => a -> a -> [a] -> [a]
reemplazar _ _ [] = []
reemplazar viejo nuevo (x:xs) = if x == viejo then nuevo: reemplazar viejo nuevo xs else x: reemplazar viejo nuevo xs

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'rotar' que rota una lista n posiciones a la izquierda
-- Ej: rotar 2 [1,2,3,4,5] = [3,4,5,1,2]
rotar :: Int -> [a] -> [a]
rotar n xs = drop n xs ++ take n xs

-- BONUS (2 puntos)
-- ¿Qué es una función de orden superior? Dé un ejemplo usando map o filter.
-- Una función de orden superior es una función que al menos uno de sus parámetros es una función. Puede devolver una función también.
-- Ejemplo: filter (>2) [1,2,3,4]     = [3,4]
-- Toma como primer parámetro una función y devuelve una lista con los elementos del segundo parámetros que hagan verdadera la condicion booleana
