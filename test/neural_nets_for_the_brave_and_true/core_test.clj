(ns neural-nets-for-the-brave-and-true.core-test
  (:require [clojure.test :refer :all]
            [neural-nets-for-the-brave-and-true.neural-net :refer :all]))

(def neuron1 [0.5 0.5])
(def neuron2 [0.5 0.5])
(def neuron3 [0.5 0.5])
(def neuron4 [0.5 0.5 0.5])

(def layer1 [neuron1 neuron2 neuron3])
(def layer2 [neuron4])

(def trained-xor [layer1 layer2])

(defn train-net [net data labels]
  net)

(deftest train-single-neuron-net
  (testing
    (is (= (train-net [[[0.5 0.7]]] [1 0.5] [1])
           [[[0.4 0.4]]]))))

(deftest dot-product-works
  (testing "[0.5 1.0] . [0.2 0.3] == 0.4"
    (is (= (dot-product [0.5 1.0] [0.2 0.3]) 0.4))))

(deftest trained-zero-zero-is-zero
  (testing "0 ^ 0 == 0"
    (is (= (run-net trained-xor [0 0]) 0))))

(deftest trained-zero-one-is-one
  (testing "0 ^ 1 == 0"
    (is (= (run-net trained-xor [0 1]) 1))))

(deftest trained-one-zero-is-one
  (testing "1 ^ 0 == 0"
    (is (= (run-net trained-xor [1 0]) 1))))

(deftest trained-one-one-is-zero
  (testing "1 ^ 1 == 0"
    (is (= (run-net trained-xor [1 1]) 0))))
