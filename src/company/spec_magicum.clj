(ns company.spec-magicum
  (:require [clojure.repl :refer :all]
            [clojure.spec.alpha :as s]))

(s/def ::board (s/coll-of int?))
(s/def ::hand (s/coll-of int? :gen-max 5))
(s/def ::game (s/keys :req [::board ::hand]))

(defn filter-nil [vector]
  (filter (comp not nil?) vector))

(defn hand-take-last [hand]
  (filter-nil (vector (peek hand))))

(defn hand-but-last [hand]
  (into [] (butlast hand)))

(defn hand-empty? [hand]
  (empty? hand))

(defn game-board [game]
  (::board game))

(defn laid-down [board hand]
  {::board (into [] (concat board (hand-take-last hand))),
   ::hand (hand-but-last hand)})

(defn in? [coll e]
  (some #(= e %) coll))

(s/fdef laid-down
  :args (s/cat :board ::board :hand ::hand)
  :ret ::game
  :fn (fn [f]
        (let [board-ret (game-board (:ret f))
              board-arg (-> f :args :board)
              hand-arg (-> f :args :hand)]
          (if (hand-empty? hand-arg)
            (= board-ret board-arg)
            (in? board-ret (last hand-arg))))))

