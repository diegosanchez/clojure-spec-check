(ns company.spec-artist-test
  (:require [clojure.repl :refer :all]
            [clojure.string :as str]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

(s/def ::neither-nil-nor-blank-nor-empty
  (s/and (complement nil?) (complement empty?) (complement str/blank?)))

(deftest neither-nil-nor-black-nor-empty-test-1
  (is (s/valid? ::neither-nil-nor-blank-nor-empty "1")))

(deftest neither-nil-nor-black-nor-empty-test-2
  (is (comp not s/valid? ::neither-nil-nor-blank-nor-empty nil)))

(deftest neither-nil-nor-black-nor-empty-test-3
  (is (comp not s/valid? ::neither-nil-nor-blank-nor-empty "")))

