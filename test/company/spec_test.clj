(ns company.spec-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))



(deftest adding-numbers
  (is (= 4 (+ 2 2))))

(deftest conform-test-1
  (is (s/conform even? 100)))


