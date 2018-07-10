--Retorna quanto dos 3 argumentos são iguais
quantosIguais :: Int -> Int -> Int -> Int
quantosIguais a b c
 | (a == b && b == c) = 2
 | a == b = 1
 | a == c = 1
 | b == c = 1
 | otherwise = 0

getMenor :: Int -> Int -> Int -> Int
getMenor a b c
 | (a < b && a < c) = a
 | (b < c && b < a) = b
 | (c < b && c < a) = c

getMaior :: Int -> Int -> Int -> Int
getMaior a b c
 | (a > b && a > c) = a
 | (b > c && b > a) = b
 | (c > b && c > a) = c

menorMaior :: Int -> Int -> Int -> (Int, Int)
menorMaior a b c = ( (getMenor a b c) , (getMaior a b c) )

getMeio :: Int -> Int -> Int -> Int
getMeio a b c 
 | (a > b && a < c) = a
 | (b > a && b < c) = b
 | (c > a && c < b) = c
 | (a < b && a > c) = a
 | (b < a && b > c) = b
 | (c < a && c > b) = c

ordenaTripla :: (Int,Int,Int) -> (Int,Int,Int)
ordenaTripla (a,b,c) = do
    let menor = getMenor a b c
    let meio = getMeio a b c
    let maior = getMaior a b c
    (menor, meio, maior)

--Retas

type Ponto = (Float, Float)
type Reta = (Ponto, Ponto)

getPontoX :: Ponto -> Float
getPontoX (a,_) = a

getPontoY :: Ponto -> Float
getPontoY (_,b) = b

isRetaVertical :: Ponto -> Ponto -> Bool
isRetaVertical (a,_) (b,_)
 | a == b = True
 | otherwise = False


--Lista

dobraListaR :: [Int] -> [Int]
dobraListaR [] = []
dobraListaR (x:xs) = (x*2):dobraListaR xs

dobraListaC :: [Int] -> [Int]
dobraListaC (x:xs) = [ x*2 | x <- (x:xs)]

membershipR :: [Int] -> Int -> Bool
membershipR [] _ = False
membershipR (x:xs) a
 | x == a = True
 | otherwise = membershipR xs a

membershipC :: [Int] -> Int -> Bool
membershipC (x:xs) a = (length [x | x <- (x:xs) , x == a ]) > 0

--apenas os numeros de uma string
filtragemR :: String -> String
filtragemR [] = []
filtragemR (x:xs)
 | (x >= '0' && x <= '9') = x:filtragemR xs
 | otherwise  =filtragemR xs

filtragemC :: String -> String
filtragemC (x:xs) = [x | x <- (x:xs) , (x >= '0' && x <= '9')]

sumPairsR :: [Int] -> [Int] -> [Int]
sumPairsR [] [] = []
sumPairsR [] a  = a
sumPairsR a []  = a
sumPairsR (x:xs) (y:ys) = (x+y):sumPairsR xs ys

--PERGUNTAR!!!
--sumPairsC :: [Int] -> [Int] -> [Int]
--sumPairsC (x:xs) (y:ys) = [ x+y | x <- (x:xs), y <- (y:ys) ]

takeR :: [Int] -> Int -> [Int]
takeR [] _ = []
takeR (x:xs) c
 | (c > 0)  = x:(takeR xs (c-1) )
 | otherwise = []

dropR :: [Int] -> Int -> [Int]
dropR [] _ = []
dropR (x:xs) c 
 | (c > 0) = dropR xs (c-1)
 | otherwise = x:(dropR xs c)

takeWhileR :: (a -> Bool) -> [a] -> [a]
takeWhileR _ [] = []
takeWhileR f (x:xs) 
 | f x == True = x:(takeWhileR f xs)
 | otherwise = []

dropWhileR :: (a -> Bool) -> [a] -> [a]
dropWhileR _ [] = []
dropWhileR f (x:xs)
 | f x == True = dropWhileR f xs
 | otherwise = x:dropWhileR f xs

type Pessoa = String
type Livro = String
type BancoDados = [(Pessoa,Livro)]

baseExemplo :: BancoDados
baseExemplo = [("Sergio","O Senhor dos Aneis"),("Andre","A Game of Thrones"),("Fernando","Jonathan Strange & Mr.Norrell"),("Fernando","A Game of Thrones")]

livrosR :: BancoDados -> Pessoa -> [Livro]
livrosR [] _ = []
livrosR ((bP,bL):xs) p
 | bP == p = bL:livrosR xs p
 | otherwise = livrosR xs p

livrosC :: BancoDados -> Pessoa -> [Livro]
livrosC ((bP,bL):xs) p = [ bL | (bP,bL) <-((bP,bL):xs), bP == p ]

emprestimosR :: BancoDados -> Livro -> [Pessoa]
emprestimosR [] _ = []
emprestimosR ((bP,bL):xs) l
 | bL == l = bP:emprestimosR xs l
 | otherwise = emprestimosR xs l
 
emprestimosC :: BancoDados -> Livro -> [Pessoa]
emprestimosC ((bP,bL):xs) l = [ bP | (bP,bL) <- ((bP,bL):xs), bL == l ]

emprestadoR1 :: BancoDados -> Livro -> Bool
emprestadoR1 [] _ = False
emprestadoR1 ((bP,bL):xs) l 
 | bL == l   = True
 | otherwise = emprestadoR1 xs l

emprestadoR2 :: BancoDados -> Livro -> Bool
emprestadoR2 b l = length (emprestimosC b l) > 0 

emprestadoC :: BancoDados -> Livro -> Bool
emprestadoC b l = length (emprestimosC b l) > 0

qtdEmprestimos :: BancoDados -> Pessoa -> Int
qtdEmprestimos ((bP,bL):xs) p = length (livrosC ((bP,bL):xs) p)

devolverR :: BancoDados -> Pessoa -> Livro -> BancoDados
devolverR [] _ _ = []
devolverR (x:xs) p l
 | x == (p,l) = devolverR xs p l
 | otherwise = x:devolverR xs p l

devolverC :: BancoDados -> Pessoa -> Livro -> BancoDados
devolverC (x:xs) p l = [ x | x <- (x:xs), x /= (p,l)]

--listaHaskell_lab.pdf

--1a
f :: [Int] -> [Int]
f [] = []
f [x,y] 
 | x == y = [y]
 | otherwise = []
f (x:y:xs)
 | x == y = y:f (y:xs)
 | otherwise = f (y:xs)

--2a
-- funcao map : dada uma lista e uma funcao, retorna uma lista em que cada elemento da lista de entrada tem a funcao aplicada em si
-- ex: map (*2) [1..5] = [2,4,6,8,10]

--funcao filter : A funcao ira remover qualquer elemento que com a funcao aplicada retorne falso 
--Em outras palavras, funciona exatamente como a condiçao numa compreensao de lista.

g :: [Int] -> Bool
g list = foldr (+) 0 (map (`mod` 2)(filter (<=100)(filter (>= 10) list))) == 0


-------------------------------
-- Slide 3 - polimorfismo

--Ordena lista
ordena :: (Ord a) => (a -> a -> Bool) -> [a] -> [a]
ordena f [x] = [x]
ordena f (x:y:xs)
 | (f x y == True ) = x:ordena f (y:xs)
 | otherwise = y:ordena f (x:xs)

bubble :: (Ord t) => (t -> t -> Bool) -> [t] -> Int -> [t]
bubble f l i
 | i == length l = l
 | otherwise = bubble f (ordena f l) (i+1)

bubbleSort :: (Ord t) => (t -> t -> Bool) -> [t] -> [t]
bubbleSort f l = bubble f l 0

----- Exercicio Agrupar
--dxa pra casa



--Slide 3 - Tipos algébricos

data Shape = Circle Float | Rectangle Float Float

--Circle 4.9 :: Shape
--Rectangle 4.2 2.0 :: Shape

isRound :: Shape -> Bool
isRound (Circle _) = True
isRound (Rectangle _ _) = False

area :: Shape -> Float
area (Circle c) = 2*3.14*c
area (Rectangle a b) = a*b

data DiaSemana = Segunda | Terça | Quarta | Quinta | Sexta | Sabado | Domingo deriving(Eq)

isWeekend :: DiaSemana -> Bool
isWeekend d
 | (d == Sabado || d == Domingo) = True
 | otherwise = False

temPLC :: DiaSemana -> Bool
temPLC d 
 | (d == Terça || d == Quinta) = True
 | otherwise = False

instance Show DiaSemana where
    show day
     | (day == Segunda || day == Domingo || day == Sabado ) = "Nao ha aula"
     | otherwise = "4 horas de aula"
