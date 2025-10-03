-- =============================================================================
-- PARCIAL MODELO - PROGRAMACIÓN FUNCIONAL (Nivel Inicial)
-- =============================================================================

-- Nombre: ___________________________________
-- DNI: ______________________________________

-- Pregunta 1 - Tipado (3 puntos)
-- Determinar el tipo de las siguientes expresiones:

-- 1. (head . tail) [1,2,3]
-- Tipo: Int

-- 2. (fst . head) [(1,2), (3,4)]
-- Tipo: Int

-- 3. (not . even) 5
-- Tipo: Bool

-- Pregunta 2 - Funciones básicas (4 puntos)

-- (a) Implementar la función 'longitud' que calcula la cantidad de elementos de una lista
-- Ej: longitud [1,2,3] = 3
longitud :: [a] -> Int
longitud [] = 0
longitud (x:xs) = 1 + longitud xs

-- (b) Implementar la función 'pertenece' que verifica si un elemento está en una lista
-- Ej: pertenece 3 [1,2,3] = True
pertenece :: Eq a => a -> [a] -> Bool
pertenece _ [] = False
pertenece x (y:ys) = x == y || pertenece x ys

-- Pregunta 3 - Recursión con listas (3 puntos)

-- Implementar la función 'duplicar' que duplica cada elemento de una lista
-- Ej: duplicar [1,2,3] = [1,1,2,2,3,3]
duplicar :: [a] -> [a]
duplicar [] = []
duplicar (x:xs) = [x,x]++(duplicar xs)

-- BONUS (2 puntos)
-- ¿Qué es la recursión y por qué es importante en programación funcional?
-- La recursión es cuando un método se llama a sí mismo, es decir, un método es recursivo si en su declaración aparece al menos una vez una llamada a él mismo.
-- Es importante en programación funcional ya que es la unica manera de recorrer listas o implementar funcionalidades como contadores y acumuladores.
