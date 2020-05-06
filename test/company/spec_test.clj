(ns company.spec-test
  (:require [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))


(defn my-index-of
  [source search]
  (str/index-of source search))

(s/def ::index-of-args (s/cat :source string? :search string?))

(s/fdef my-index-of
  :args ::index-of-args
  :ret nat-int?
  :fn #(<= (:ret %) (-> % :args :source count)))

(deftest adding-numbers
  (is (= 4 (+ 2 2))))

(deftest conform-test-1
  (is (s/conform even? 100)))

(deftest my-index-of-test-1
  (is (= (my-index-of "foobar" "b") 3)))

(deftest my-index-of-test-2
  (is (= (apply my-index-of ["foobar" "b"]) 3)))

(deftest my-index-of-test-3
  (is (= (apply my-index-of ["foobar" "f"]) 0)))

(deftest index-of-args-test-1
  (is (s/valid? ::index-of-args ["foo" "f"])))

(deftest index-of-args-test-2
  (is (not (s/valid? ::index-of-args ["foo" 3]))))

(deftest index-of-args-test-conform-1
  (let [expected {:source "foo", :search "f"}]
    (is (= (s/conform ::index-of-args ["foo" "f"]) expected))))

