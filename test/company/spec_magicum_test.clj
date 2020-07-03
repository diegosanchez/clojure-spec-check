(ns company.spec-magicum-test
  (:require [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

(require '[clojure.string :as str])
(require '[clojure.spec.alpha :as s])
(require '[clojure.spec.test.alpha :as stest])
(require '[clojure.spec.gen.alpha :as gen])


(defn laid-down [board hand]
  1)

(s/fdef laid-down
  :args (s/cat :board vector? :hand vector?)
  :ret int?)

(deftest test-dummy
  (is (= 0 0)))

