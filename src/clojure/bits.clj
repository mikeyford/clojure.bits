(ns clojure.bits
  (:require [clojure.core.matrix.operators :as M]
            [kixi.stats.random :as ran])
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


;4clojure #38, max without (max) and variable args not as vector
;use of [& args] for multiple arguments
(fn [& args]
  (last (sort args)))


;define list of symbols
;using kixi.stats to assign random samples from normal distribution
(defn sample_norm [list]
  (doseq [x list]
    (intern *ns* (symbol x) (ran/draw (ran/normal {:mu 0, :sd 1})))
    ))