(ns company.spec-test
  (:require [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.test.alpha :as test]))


(defn foo-gen
  []
  (->> (s/gen (s/int-in 1 100))
       (gen/fmap #(str "FOO-" ))))

(s/def ::id
  (s/spec (s/and string?
                 #(str/starts-with? % "FOO-"))
          :gen foo-gen))

(s/def ::lookup (s/map-of keyword? string? :min-count 1))

(s/def ::lookup-finding-k (s/and (s/cat :lookup ::lookup
                                        :k keyword?)
                                 (fn [{ :keys [lookup k]}]
                                   (contains? lookup k))))


;; https://youtu.be/WoFkhE92fqc?list=PLZdCLR02grLrju9ntDh3RGPpWSWBvjwXg&t=307
