{- 
 Se quiere hacer una función recursiva sinDups que elimine repetidos consecutivos de una lista. Por ejemplo:
> sinDups [1, 2, 2, 3, 10, 10, 5]
[1 ,2 ,3 ,10 ,5]
Completar el siguiente código (reemplazar undefined por el código correspondiente):
 -}

sinDups :: (Eq a) => [a] -> [a] -- completar el perfil
sinDups [] = []
sinDups [x] = [x]
sinDups (x:(y:ys)) = if x == y then sinDups (x:ys) else x : sinDups (y:ys)

{- 
 Si x == y entonces sinDups (x:ys) // saltea el y que está repetido
 Sino x : sinDups(y:ys) // se concatena al inicio x, y se ejecuta el metodo desde el segundo elemento con la cola de la lista


 -- Evaluacion 
sinDups [1, 2, 2, 3, 10, 10, 5]
  = def. sinDups - 1 != 2
1 : sinDups [2, 2, 3, 10, 10, 5]
  = def. sinDups -  2 == 2
1 : sinDups [2, 3, 10, 10, 5]
  = def. sinDups -  2 != 3
1 : (2: sinDups [3, 10, 10, 5])
  = def. sinDups -  3 != 10
1 : (2: (3: sinDups [10, 10, 5]))
  = def. sinDups -  10 == 10
1 : (2: (3: sinDups [10, 5]))
  = def. sinDups -  10 != 5
1 : (2: (3: (10: sinDups [5])))
  = def. sinDups [x]
1 : (2: (3: (10: [5])))
1 : (2: (3: [10, 5]))
1 : (2: [3, 10, 5])
1 : [2, 3, 10, 5]
[1, 2, 3, 10, 5]
 -}


 -- PRACTICA EJERCICIOS DE DEEPSEEEEKKK

-- Concatena todas las sublistas
-- Ej: aplanar [[1,2],[3],[4,5]] = [1,2,3,4,5]
aplanar :: [[a]] -> [a]
aplanar [] = []
aplanar (x:xs) = x ++ aplanar xs
-- bien

-- Devuelve (positivos, negativos)
-- Ej: dividirSignos [1,-2,3,-4,0] = ([1,3],[-2,-4])
dividirSignos :: [Int] -> ([Int], [Int])
dividirSignos [] = ([], [])
dividirSignos (x:xs) 
  | x > 0 = (x: fst resultado, snd resultado)
  | x < 0 = (fst resultado, x: snd resultado)
  | otherwise = resultado 
  where resultado = dividirSignos xs
-- bien


-- Devuelve (pares, impares)
-- Ej: separarParImpar [1,2,3,4,5] = ([2,4],[1,3,5])
separarParImpar :: [Int] -> ([Int], [Int])
separarParImpar [] = ([], [])
separarParImpar (x:xs)
  | mod x 2 == 0 = (x: even, odd)
  | otherwise = (even, x: odd)
  where (even, odd) = separarParImpar xs
-- bien

-- Devuelve (menores, mayores) que n
-- Ej: dividirPorValor 5 [3,8,1,6] = ([3,1],[8,6])
dividirPorValor :: Int -> [Int] -> ([Int], [Int])
dividirPorValor n [] = ([], [])
dividirPorValor n (x:xs)
 | x <= n = (x: l, g)
 | otherwise = (l, x: g)
 where (l, g) = dividirPorValor n xs

-- Devuelve (palabras cortas, palabras largas) 
-- donde cortas son <= n caracteres
-- Ej: separarPorLongitud 3 ["hi", "hello", "a", "test"] = (["hi","a"],["hello","test"])
separarPorLongitud :: Int -> [String] -> ([String], [String])
separarPorLongitud n [] = ([], [])
separarPorLongitud n (x:xs)
  | length x <= n = (x: l, g)
  | otherwise = (l, x: g)
  where (l, g) = separarPorLongitud n xs


-- Devuelve (múltiplos de n, no múltiplos de n)
-- Ej: dividirMultiplos 3 [1,3,5,6,9] = ([3,6,9],[1,5])
dividirMultiplos :: Int -> [Int] -> ([Int], [Int])
dividirMultiplos n [] = ([], [])
dividirMultiplos n (x:xs)
  | mod x n == 0 = (x: m, o)
  | otherwise = (m, x: o)
  where (m, o) = dividirMultiplos n xs



-- Invertir una lista
-- Ej: invertir [1,2,3] = [3,2,1]
invertir :: [a] -> [a]
invertir [] = []
invertir (x:xs) = invertir xs ++ [x]

-- Contar elementos que cumplen condición
-- Ej: contar even [1,2,3,4] = 2
contar :: (a ->Bool) -> [a] -> Int
contar _ [] = 0
contar f (x:xs) = if f x then 1 + contar f xs else contar f xs

-- Contar elementos que cumplen condición con acumulador
-- Ej: contar even [1,2,3,4] = 2
contar' :: (a ->Bool) -> [a] -> Int
contar' f xs = aux 0 xs
  where aux acc [] = acc
        aux acc (x:xs) = 
          if f x 
          then aux (acc + 1) xs 
          else aux acc xs


-- Aplicar función a cada elemento
-- Ej: mapear (*2) [1,2,3] = [2,4,6]
mapear :: (a ->b) -> [a] ->[b]
mapear _ [] = []
mapear f (x:xs) = f x : mapear f xs



-- Encuentra el máximo elemento (lista no vacía)
-- Ej: maximo [3,1,4,2] = 4
maximo :: Ord a => [a] -> a
maximo [x] = x
maximo (x:xs) = if x > maxTail then x else maxTail
  where maxTail = maximo xs

-- Filtra elementos que cumplen condición
-- Ej: filtrar (>2) [1,3,2,4] = [3,4]
filtrar :: (a -> Bool) -> [a] -> [a]
filtrar _ [] = []
filtrar f (x:xs) = if f x then x : filterTail else filterTail
  where filterTail = filtrar f xs

-- Replica cada elemento n veces
-- Ej: replicarN 3 [1,2] = [1,1,1,2,2,2]
replicarN :: Int -> [a] -> [a]
replicarN n xs = undefined
-- no se como hacerlo en una linea


-- Toma los primeros n elementos
-- Ej: tomar 3 [1,2,3,4,5] = [1,2,3]
tomar :: Int -> [a] -> [a]
tomar 0 _ = []
tomar _ [] = []
tomar n (x:xs) = x: (tomar (n-1) xs)

-- Suma todos los elementos
-- Ej: sumarLista [1,2,3,4] = 10
sumarLista :: Num a => [a] -> a
sumarLista [] = 0
sumarLista (x:xs) = x + sumTail
  where sumTail = sumarLista xs


-- lol
(++.) :: [a] ->[a] ->[a]
xs ++. [] = xs
[] ++. ys = ys
(x:xs) ++. ys = x: xs ++. ys 


s :: Num a => (a, a) ->a
s (x,y) = x + y

s' :: Num a => a ->a ->a
s' x y = x + y

si :: Num a => a ->a ->a
si x y = (s' . s' ) x y
