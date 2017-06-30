(ns neural-nets-for-the-brave-and-true.neural-net
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println args))

(def e 2.7182818)

(defn dot-product [v1 v2]
  (reduce + (map (partial apply *) (map vector v1 v2))))

(defn sigmoid [z]
  (let [exponent (Math/pow e (- z))]
    (/ 1 (+ 1 exponent))))

(defn feed-layer [inputs layer]
  (map (fn [neuron]
         (sigmoid (dot-product neuron inputs)))
       layer))

(defn run-net [net inputs]
  (let [results1 (feed-layer inputs (first net))
        results2 (feed-layer results1 (second net))]
    results2))
