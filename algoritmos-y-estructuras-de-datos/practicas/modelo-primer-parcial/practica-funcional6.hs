-- =============================================================================
-- PARCIAL MODELO - PROGRAMACIÓN FUNCIONAL 
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo de las siguientes expresiones:

-- 1. (take 3 . cycle) [1,2]
-- Tipo: [Int]

-- 2. (sum . map snd) [(1,2), (3,4)]
-- Tipo: Int

-- 3. (filter (>0) . concat) [[1,-2], [3,4]]
-- Tipo: [Int]

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'ultimo' que devuelve el último elemento de una lista no vacía
-- Ej: ultimo [1,2,3] = 3
ultimo :: [a] -> a
ultimo [x] = x
ultimo (x:xs) = ultimo xs

-- (b) Implementar la función 'revertir' que invierte una lista
-- Ej: revertir [1,2,3] = [3,2,1]
revertir :: [a] -> [a]
revertir [] = []
revertir (x:xs) = revertir xs ++ [x]

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'agruparPares' que filtra solo los elementos en posiciones pares (0-based)
-- Ej: agruparPares [0,1,2,3,4] = [0,2,4]
agruparPares :: [a] -> [a]
agruparPares [] = []
agruparPares [x] = [x]
agruparPares (x:_:xs) = x : agruparPares xs

-- BONUS (2 puntos)
-- ¿Qué es la composición de funciones (.) y cómo se usa? Dé un ejemplo.
-- La composición de funciones viene directamente de su definicion matemática. En la que una primera funcion se puede componer con una segunda si el dominio de la primera es igual al codominio de la segunda.
-- El orden de composicion de funciones es de derecha a izquierda.
-- por ejemplo g.f (x) = g(f(x))
-- 
-- Un ejemplo en haskell seria:
-- tail . tail [1,2,3,4] = tail (tail [1,2,3,4]) = tail [2,3,4] = [3,4]
