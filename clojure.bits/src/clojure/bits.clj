(ns clojure.bits
  (:require [clojure.core.matrix.operators :as M])
  (:use clojure.core.matrix))

;4clojure #35, find odd numbers
;for test over sequence using :when
#(for [x %
     :when (odd? x)]
      x)


;4clojure #22, count element without (count)
;run a count across a sequence with reduce
#(reduce (fn [c _] (inc c)) 0 %)


;4clojure #26, Fibonacci
;tail recursion and multiple arity
(fn fib
  ([n] (fib n [1 1]))
  ([n c]
   (if (= (count c) n)
     c
     (fib n (conj c (+ (last (drop-last c)) (last c))))
)))

