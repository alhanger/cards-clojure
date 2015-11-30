(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def hand-1 #{{:suit :club
               :rank 2}
              {:suit :club
               :rank 3}
              {:suit :club
               :rank :queen}
              {:suit :club
               :rank :king}})

(def hand-2 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 3}
              {:suit :club
               :rank :queen}
              {:suit :club
               :rank :king}})

(deftest flush?-test
  (testing "flush? returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))
