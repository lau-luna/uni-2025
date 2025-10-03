-- =============================================================================
-- PARCIAL MODELO 3 - PROGRAMACIÓN FUNCIONAL (Haskell)
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________
-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo de las siguientes expresiones:

-- 1. (foldr (:) [] . reverse) "Hola"
-- Tipo: [Char]

-- 2. (all even . takeWhile (>0)) [4,2,0,-1]
-- Tipo: Bool

-- 3. (fst . head . tail) [(1,"a"),(2,"b"),(3,"c")]
-- Tipo: Int

-- Pregunta 2 - Funciones recursivas (4 puntos)

-- (a) Implementar la función 'maximo' que encuentra el máximo elemento de una lista no vacía
-- Ej: maximo [3,1,4,2] = 4
maximo :: Ord a => [a] -> a
maximo [x] = x
maximo (x:y:xs) = if x > y then maximo (x:xs) else maximo (y:xs)

-- (b) Implementar la función 'prefijos' que genera todos los prefijos de una lista
-- Ej: prefijos [1,2,3] = [[],[1],[1,2],[1,2,3]]  o conjunto de partes
prefijos :: [a] -> [[a]]
prefijos [] = [[]]
prefijos xs = xs : tail (prefijos xs)

-- Pregunta 3 - Manejo de listas (3 puntos)

-- Implementar la función 'comprimir' que elimina elementos duplicados consecutivos
-- Ej: comprimir [1,2,2,3,3,3,1] = [1,2,3,1]
comprimir :: Eq a => [a] ->[a]
comprimir [] = []
comprimir [x] = [x]
comprimir (x:y:xs) = if x == y then comprimir (x:xs) else comprimir (y:xs)

-- BONUS (2 puntos)
-- ¿Qué ventajas tiene la inmutabilidad en programación funcional?
-- Inmutabilidad significa que no se puede alterar el estado, en funcional no hay estado por que no hay variables.
-- La ventaja que tiene esto es que nos asegura que un programa/función siempre devuelve la misma salida para la misma entrada.
--

curry' :: ((a,b) ->c) ->(a ->b ->c)
curry' f x y = f (x, y)

uncurry' :: (a ->b ->c) ->((a,b) ->c)
uncurry' f (x, y) = f x y

