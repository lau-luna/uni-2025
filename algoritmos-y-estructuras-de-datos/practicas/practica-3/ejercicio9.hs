-- producto escalar de (a,b) * (c,d) = ac + bd
prodEscalar :: Num a => (a,a) ->(a,a) ->a
prodEscalar (a,b) (c,d) = a * c + b * d

prodEscalar2 :: Num a => (a,a) ->(a,a) ->a
prodEscalar2 t1 t2 = (fst (t1) * fst (t2)) + (snd (t1) * snd (t2))


-- Ejericio 10. 
abs' :: Int ->Int
abs' n 
  | n >= 0 = n
  | n < 0 = -n


-- Ejercicio 11.
sumaListaNumeros :: [Int] ->Int
sumaListaNumeros [] = 0
sumaListaNumeros l = head l + (sumaListaNumeros (tail l))


-- Ejericicio 12.
{-
 Escriba una función currificada que dado dos números x e y , calcule x^y . Escriba el perfil de la
función. 
-}
potencia :: Int ->Int ->Int
potencia _ 0 = 1
potencia 0 1 = 1
potencia x 1 = x
potencia x y = x * potencia x (y - 1)


-- Ejercicio 13.
{- 
 13. Defina una función que calcule la potencia de 2 usando la función currificada definida en 12. Es
decir dado el número x, la función debe calcular 2^x .
 -}
pot2 :: Int -> Int
pot2 x = potencia 2 x


-- Ejercicio 14.
{- 
 14. Escriba, usando currificación, una función que sume tres números. Escriba el perfil de la función.
 -}
sumaTriple :: Int ->Int ->Int ->Int
sumaTriple a b c = a + b + c


-- Ejercicio 15
{- 
Defina una función que suma 4 a otros dos números, utilizando la función definida en 14 . Luego
aplique la función a los siguientes valores y analice la salida.
> addFour 5 8
 -}

addFour :: Int ->Int ->Int
addFour a b = sumaTriple a b 4


-- Ejercicio 16
{- 
 16. Analice el siguiente programa que dado un arreglo y la cantidad de elementos a explorar, retorna
True si todos los elementos del mismo son 0, Falso en caso contrario.
zeros a 0 = True
zeros a n = zeros a (n -1) && ( a !!( n -1) == 0)
¿Qué resultado arrojará dicho programa si lo ejecutamos con las siguientes entradas?:
(a) > zeros [0,2,0] 3
(b) > zeros [0,0,3] 2
(c) > zeros [0,0,0,0] 4
 -}

{-
(a) > zeros [0,2,0] 3
        -- Evaluacion aplicativa
  = def. zeros
zeros [0,2,0] (3-1) && ([0,2,0]!!(3-1) == 0)
  = aritmetica
zeros [0,2,0] 2 && ([0,2,0]!!(3-1) == 0)
  = aritmetica
zeros [0,2,0] 2 && ([0,2,0]!!2 == 0)
  = def. !!
zeros [0,2,0] 2 && (0 == 0)
  = def. ==
zeros [0,2,0] 2 && True
  = def. zeros
zeros [0,2,0] (2-1) && ([0,2,0]!!(2-1) == 0) && True
  = aritmetica dos veces
zeros [0,2,0] 1 && ([0,2,0]!!1 == 0) && True
  = def. !!
zeros [0,2,0] 1 && (2 == 0) && True
  = def. ==
zeros [0,2,0] 1 && False && True
  = def. zeros
zeros [0,2,0] (1-1) && ([0,2,0]!!(1-1) == 0) && False && True
  = aritmetica dos veces
zeros [0,2,0] 0 && ([0,2,0]!!0 == 0) && False && True
  = def. !!
zeros [0,2,0] 0 && (0 == 0) && False && True
  = def. ==
zeros [0,2,0] 0 && True && False && True
  = def. zeros
True && True && False && True
  = def. &&
True && False && True
  = def. &&
False && True
  = def. &&
False
-}


{-
(b) > zeros [0,0,3] 2
      -- Evaluacion normal
  = def. zeros
zeros [0,0,3] (2-1) && ([0,0,3]!!(2-1) == 0)
  = aritmetica x2
zeros [0,0,3] 1 && ([0,0,3]!!1 == 0)
  = def. (!!)
zeros [0,0,3] 1 && (0 == 0)
  = def. ==
zeros [0,0,3] 1 && True
  = def. zeros
zeros [0,0,3] (1-1) && ([0,0,3]!!(1-1) == 0) && True
  = aritmetica x2
zeros [0,0,3] 0 && ([0,0,3]!!0 == 0) && True
  = def. (!!)
zeros [0,0,3] 0 && (0 == 0) && True
  = def. (==)
zeros [0,0,3] 0 && True && True
  = def. zeros
True && True && True
  = def. (&&)
True && True
  = def. (&&)
True

Claramente evalua desde la posición 0 hasta n-1 de la lista. Si le pasamos el valor incorrecto de n, se evalua incorrectamente.
-}


{-
(b) > zeros [0,0,0,0] 4
      -- Evaluacion normal
  = def. zeros
zeros [0,0,0,0] (4-1) && ([0,0,0,0]!!(4-1) == 0)
  = aritmetica x2
zeros [0,0,0,0] 3 && ([0,0,0,0]!!3 == 0)
  = def. (!!)
zeros [0,0,0,0] 3 && (0 == 0)
  = def. ==
zeros [0,0,0,0] 3 && True
  = def. zeros
zeros [0,0,0,0] (3-1) && ([0,0,0,0]!!(3-1) == 0) && True
  = aritmetica x2
zeros [0,0,0,0] 2 && ([0,0,0,0]!!2 == 0) && True
  = def. (!!)
zeros [0,0,0,0] 2 && (0 == 0) && True
  = def. (==)
zeros [0,0,0,0] 2 && True && True
  = def. zeros
zeros [0,0,0,0] (2-1) && ([0,0,0,0]!!(2-1) == 0) && True && True
  = aritmetica x2
zeros [0,0,0,0] 1 && ([0,0,0,0]!!1 == 0) && True && True
  = def. (!!)
zeros [0,0,0,0] 1 && (0 == 0) && True && True
  = def. (==)
zeros [0,0,0,0] 1 && True && True && True
  = def. zeros
zeros [0,0,0,0] (1-1) && ([0,0,0,0]!!(1-1) == 0) && True && True && True
  = aritmetica x2
zeros [0,0,0,0] 0 && ([0,0,0,0]!!0 == 0) && True && True && True
  = def. (!!)
zeros [0,0,0,0] 0 && (0 == 0) && True && True && True
  = def. (==)
zeros [0,0,0,0] 0 && True && True && True && True
  = def. zeros
True && True && True && True && True
  = def. (&&)
True && True && True && True
  = def. (&&)
True && True && True
  = def. (&&)
True && True
  = def. (&&)
True 
-}


zeros :: [Int] ->Int ->Bool
zeros a 0 = True
zeros a n = zeros a (n -1) && ( a !!( n -1) == 0)

zeroes :: [Int] ->Bool
zeroes [] = True
zeroes (a:as) = zeroes as && (a == 0)
-- La diferencia es que zeroes no toma el tamaño de la lista, sino que toma sólo la lista como parámetro.




-- Ejercicio 18.
belongs :: a ->[a] ->Bool
belongs e [] = False
belongs e (a:as) = belongs e as || (a == e)
