(ns neural-nets-for-the-brave-and-true.neural-net
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println args))

(def e 2.7182818)

(defn activation-fn [x]
  (/ 1 (+ 1 (Math/pow e (- x)))))

(defn d-activation-fn [x]
  (* x (- 1 (activation-fn x))))

(defn dot-product [v1 v2]
  (reduce + (map (partial apply *) (map vector v1 v2))))

(defn feed-forward-layer [inputs layer]
  (map (fn [neuron]
         (activation-fn (dot-product neuron inputs)))
       layer))

(defn delta-output-layer [target output]
  (* (d-activation-fn output) 
     (- target output)))

(defn delta-hidden-layer [output-delta neuron-values weights]
  (mapv * (map d-activation-fn neuron-values) 
          (map (partial * output-delta) weights)))

(defn run-net [net inputs]
  (let [hidden-output (feed-forward-layer inputs (first net))
        output-output (feed-forward-layer hidden-output (second net))]
    output-output))
