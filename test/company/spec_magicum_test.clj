(ns company.spec-magicum-test
  (:require [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

;; (require '[clojure.string :as str])
;; (require '[clojure.spec.alpha :as s])
;; (require '[clojure.spec.test.alpha :as stest])
;; (require '[clojure.spec.gen.alpha :as gen])

(s/def ::board (s/coll-of int?))
(s/def ::hand (s/coll-of int?))
(s/def ::game (s/keys :req [::board ::hand]))


(defn laid-down [board hand]
  {::board board, ::hand hand})

(s/fdef laid-down
  :args (s/cat :board ::board :hand ::hand)
  :ret ::game)

(deftest test-dummy
  (is (= 0 0)))

