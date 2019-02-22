(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest moving-grid-right
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 0 2 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat more than 2 times"
    (is (= '((0 0 0 4)
             (0 2 4 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (2 2 2 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-left
  (testing "rows with numbers that repeat"
    (is (= '((4 0 0 0)
             (2 4 0 0)
             (4 0 0 0)
             (8 0 0 0))
           (move-grid-left
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-up
  (testing "rows with numbers that repeat"
    (is (= '((2 2 4 2)
             (0 4 4 4)
             (0 0 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-down
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 2 4 2)
             (2 4 4 4))
           (move-grid-down
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest removing-zero
  (testing "remove zero from given grid"
    (is (= '(2 2 4)
           (remove-zeros
            '(0 2 2 0 0 4))))))

(deftest partitioning-by-identity
  (testing "group elemnt having same identity"
    (is (= '((0) (2 2) (8) (4 4))
           (partition-by-identity
            '(0 2 2 8 4 4))))))

(deftest partitioning-by-identity-in-group-of-2
  (testing "group elemnt having same identity in group of 2"
    (is (= '((2 2) (2) (4 4) (8))
           (partition-in-group-of-2
            '(2 2 2 4 4 8))))))

(deftest adding-similar-group-element
  (testing "add same element from grid"
    (is (= '(4 2 8 8)
           (add-similar-group
            '((2 2) (2) (4 4) (8)))))))

(deftest moving-a-single-grid-to-right
  (testing "move grid elements towards right and sum up with same identity"
    (is (= '(0 2 4 4)
           (move-a-grid-to-right
            '(2 2 2 4))))))

(deftest converting-columns-into-rows
  (testing "convert given columns into rows"
    (is (= '((1 4 7) (2 5 8) (3 6 9))
           (convert-columns-to-rows
            '((1 2 3) (4 5 6) (7 8 9)))))))