{-  
 Orden Aplicativo: se reduce siempre la expresión más adentro y más a la izquierda (siempre
de izquierda a derecha).
• Orden Normal: se reduce siempre la expresión más afuera y más a la izquierda.
 -}

cuadrado :: Int ->Int
cuadrado x = x * x

hd :: [a] ->a
hd (x:xs) = x

-- Evaluar 2 * cuadrado (hd [2,4,5,6,7,8])
--  a) utilizando el orden de reducción aplicativo.
{- 
 2 * cuadrado (hd [2,4,5,6,7,8])
= def. hd
 2 * cuadrado (2)
= def. cuadrado
 2 * (2 * 2)
= aritmetica
 2 * 4
= aritmetica
 8
-}

-- • b) utilizando el orden de reducción normal.
{- 
 2 * cuadrado (hd [2,4,5,6,7,8])
= def. cuadrado
 2 * (hd [2,4,5,6,7,8]) * (hd [2,4,5,6,7,8])
= def. hd
 2 * 2 * (hd [2,4,5,6,7,8])
= def. *
 4 * (hd [2,4,5,6,7,8])
= def. hd
 4 * 2
= def. *
8
 -}



{-
22. Dada la definición: linf = 1 : linf. Resuelve los siguientes pasos para la expresión:
                hd linf

• a) Muestre los pasos de reducción utilizando el orden aplicativo.
  hd linf
= def. linf
  hd (1:linf)
= def. linf
  hd (1:(1:linf))
= def. linf
  hd (1:(1:(1:linf)))
...
nunca termina de evaluar con orden aplicativo

• b) Haga lo mismo pero siguiendo el orden de reducción normal.
  hd linf
= def. linf
  hd 1:linf
= def. hd
  1


-}


-- 23) Dada la siguiente definición:
f :: Int ->Int ->Int
f x 0 = x
f x (n+1) = cuadrado (f x n)

{- 
Resuelve los siguientes pasos para la expresión:
            f 2 3

• a) Muestra los pasos de reducción utilizando el orden aplicativo.
  f 2 3
= def. f
  cuadrado (f 2 2)
= def. f
  cuadrado (cuadrado (f 2 1))
= def. f
  cuadrado (cuadrado (cuadrado (f 2 0)))
= def. f
  cuadrado (cuadrado (cuadrado 2))
= def. cuadrado
  cuadrado (cuadrado (2*2))
= def. *
  cuadrado (cuadrado 4)
= def. cuadrado
  cuadrado (4 * 4)
= def. *
  cuadrado 16 
= def. cuadrado
  16 * 16
= def. *
  256


• b) Has lo mismo pero siguiendo el orden de reducción normal.
  f 2 3
= def. f
  cuadrado (f 2 2)
= def. cuadrado
  (f 2 2) * (f 2 2)
= def. f
  (cuadrado (f 2 1)) * (f 2 2)
= def. cuadrado
  ((f 2 1) * (f 2 1)) * (f 2 2)
= def. f 
  ((cuadrado (f 2 0)) * (f 2 1)) * (f 2 2)
= def. cuadrado
  (((f 2 0) * (f 2 0)) * (f 2 1)) * (f 2 2)
= def. f
  ((2 * (f 2 0)) * (f 2 1)) * (f 2 2)
= def. f
  ((2 * 2) * (f 2 1)) * (f 2 2)
= def. *
  (4 * (f 2 1)) * (f 2 2)
= def. f
  (4 * (cuadrado (f 2 0))) * (f 2 2)
= def. cuadrado
  (4 * ((f 2 0) * (f 2 0))) * (f 2 2)
= def. f
  (4 * (2 * (f 2 0))) * (f 2 2)
= def. f
  (4 * (2 * 2)) * (f 2 2)
= def. *
  (4 * 4) * (f 2 2)
= def. *
  16 * (f 2 2)
= def. f 
  16 * (cuadrado (f 2 1))
= def. cuadrado
  16 * ((f 2 1) * (f 2 1))
= def. f
  16 * ((cuadrado (f 2 0)) * (f 2 1))
= def. cuadrado
  16 * (((f 2 0) * (f 2 0)) * (f 2 1))
= def. f
  16 * ((2 * (f 2 0)) * (f 2 1))
= def. f
  16 * ((2 * 2) * (f 2 1))
= def. *
  16 * (4 * (f 2 1))
= def. f
  16 * (4 * (cuadrado (f 2 0)))
= def. cuadrado
  16 * (4 * ((f 2 0) * (f 2 0)))
= def. f
  16 * (4 * (2 * (f 2 0)))
= def. f
  16 * (4 * (2 * 2))
= def. *
  16 * (4 * 4)
= def. *
  16 * 16 
= def. *
  256
 -}


-- Considerando las siguientes definiciones para square e inf :
square :: Int ->Int
square x = x * x

inf :: Int
inf = inf + 1

{- 
Utilizando orden aplicativo y normal, evalua la siguiente expresión:
square inf


-- Aplicativo
  square inf
= def. inf
  square (inf + 1)
= def. inf
  square ((inf + 1) + 1)
= def. inf
  square (((inf + 1) + 1) + 1)
= def. inf
  square (((inf + 1) + 1) + 1)
...
No termina nunca con orden aplicativo


-- Normal
  square inf
= def. square
  inf * inf
= def. inf
  (inf + 1) * inf
= def. inf
  ((inf + 1) + 1) * inf
= def. inf
  (((inf + 1) + 1) + 1) * inf
= def. inf
  ((((inf + 1) + 1) + 1) + 1) * inf
...
Tampoco termina con Normal
-}

{- 
 25. (*) Resuelva el ejercicio 23 utilizando orden de reducción lazy
-- Evaluación Lazy
  f 2 3
= def. f
  cuadrado (f 2 2)
= def. cuadrado
  x * x
[| x =  f 2 2 |]
= def. f
  x * x
[| x =  cuadrado (f 2 1) |]
= def. cuadrado
  x * x
[| x = y * y, y = f 2 1 |]
= def. f
  x * x
[| x = y * y, y = cuadrado (f 2 0) |]
= def. cuadrado
  x * x
[| x = y * y, y = z * z, z = f 2 0 |]
= def. f
  x * x
[| x = y * y, y = z * z, z = 2 |]
= sustitucion
  x * x
[| x = y * y, y = 2 * 2 |]
= aritmetica
  x * x
[| x = y * y, y = 4 |]
= sustitucion
  x * x
[| x = 4 * 4 |]
= aritmetica
  x * x
[| x = 16 |]
= sustitucion
  16 * 16
= aritmetica
  256



 -}
