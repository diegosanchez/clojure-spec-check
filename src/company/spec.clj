(ns company.spec
  (:require [clojure.string :as str]
            [clojure.spec.alpha :as s]
            [clojure.test :refer :all]))

(defn my-index-of
  [source search]
  (str/index-of source search))

(s/def ::index-of-args (s/cat :source string?
                              :search (s/alt :string string?
                                             :char char?)))

(s/fdef my-index-of
  :args ::index-of-args
  :ret nat-int?
  :fn #(<= (:ret %) (-> % :args :source count)))

