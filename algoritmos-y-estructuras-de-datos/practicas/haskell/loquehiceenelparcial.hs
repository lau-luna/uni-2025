sumaPotencias :: Int ->Int ->Int
sumaPotencias b n
  | n == 0 = 1
  | otherwise = (b^n) +  sumaPotencias b (n-1)
