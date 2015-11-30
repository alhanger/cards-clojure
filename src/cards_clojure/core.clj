(ns cards-clojure.core
  (:gen-class))

(def suits [:club :spade :heart :diamond])
(def ranks (range 1 14))
;(def rank-names {1 :ace, 11 :jack, 12 :queen, 13 :king})

(defn create-deck []
  (set (for [suit suits
             rank ranks]
         {:suit suit
          :rank rank})))

(defn create-hands [deck]
  (set (for [c1 deck
             c2 (disj deck c1)
             c3 (disj deck c1 c2)
             c4 (disj deck c1 c2 c3)]
         #{c1 c2 c3 c4})))

(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))

(defn straight? [hand]
  (let [sorted (sort (map :rank hand))
        min-value (first sorted)]
    (= sorted
       (take 4
             (iterate inc min-value)))))

(defn straight-flush? [hand]
  (and (flush? hand)
       (straight? hand)))

(defn four-of-a-kind? [hand]
  (= 1 (count (set (map :rank hand)))))

(defn three-of-a-kind? [hand]
  (== (apply max (vals (frequencies (map :rank hand)))) 3))

(defn two-pair? [hand]
  (== (apply max (vals (frequencies (map :rank hand)))) 2))

(defn -main [& args]
  (time (let [deck (create-deck)
              hands (create-hands deck)
              hands (filter flush? hands)]
          (println (count hands)))))
