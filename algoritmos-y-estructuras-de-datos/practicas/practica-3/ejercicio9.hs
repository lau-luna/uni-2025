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
