(ns company.spec-magicum-test
  (:require [company.spec-magicum :refer :all]
            [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.test.alpha :as stest]))

(deftest test-check
  (is (=
       (stest/summarize-results (stest/check `laid-down))
       {:total 1, :check-passed 1})))
            

