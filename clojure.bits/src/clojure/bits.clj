(ns clojure.bits)

;4clojure #26
;Fibonacci with tail recursion
(fn fib
  ([n] (fib n [1 1]))
  ([n c]
   (if (= (count c) n)
     c
     (fib n (conj c (+ (last (drop-last c)) (last c)))))))
