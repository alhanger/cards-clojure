(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def hand-1 #{{:suit :club
               :rank 2}
              {:suit :club
               :rank 3}
              {:suit :club
               :rank 12}
              {:suit :club
               :rank 13}})

(def hand-2 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 3}
              {:suit :club
               :rank 12}
              {:suit :club
               :rank 13}})

(def hand-3 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 2}
              {:suit :diamond
               :rank 2}
              {:suit :heart
               :rank 2}})

(def hand-4 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 2}
              {:suit :diamond
               :rank 2}
              {:suit :heart
               :rank 3}})

(def hand-5 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 2}
              {:suit :diamond
               :rank 3}
              {:suit :heart
               :rank 3}})

(def hand-6 #{{:suit :spade
               :rank 2}
              {:suit :club
               :rank 3}
              {:suit :diamond
               :rank 4}
              {:suit :heart
               :rank 5}})

(def hand-7 #{{:suit :spade
               :rank 2}
              {:suit :spade
               :rank 3}
              {:suit :spade
               :rank 4}
              {:suit :spade
               :rank 5}})

(deftest flush?-test
  (testing "flush? returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))

(deftest four-of-a-kind?-test
  (testing "four-of-a-kind? returns true if the hand has four cards with the same rank"
    (is (= true (four-of-a-kind? hand-3)))
    (is (= false (four-of-a-kind? hand-2)))))

(deftest three-of-a-kind?-test
  (testing "three-of-a-kind? returns true if the hand has three cards with the same rank"
    (is (= true (three-of-a-kind? hand-4)))
    (is (= false (three-of-a-kind? hand-3)))
    (is (= false (three-of-a-kind? hand-2)))))

(deftest two-pair?-test
  (testing "two-pair? returns true if the hand has two pairs with the same rank"
    (is (= true (two-pair? hand-5)))
    (is (= false (two-pair? hand-4)))))

(deftest straight?-test
  (testing "straight? returns true if the rank of the cards are in sequential order"
    (is (= true (straight? hand-6)))
    (is (= false (straight? hand-5)))))

(deftest straight-flush?-test
  (testing "straight-flush? returns true if the suit of all the cards is the same and the ranks are in sequential order"
    (is (= true (straight-flush? hand-7)))
    (is (= false (straight-flush? hand-6)))))