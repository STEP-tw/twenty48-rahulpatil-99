(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial remove zero?))

(def partition-by-identity (partial partition-by identity))

(def partition-in-group-of-2 
  (comp
   (partial mapcat (partial partition-all 2))
   (partial partition-by-identity)))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  grid)

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)
