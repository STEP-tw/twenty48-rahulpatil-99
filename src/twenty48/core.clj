(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial remove zero?))

(def partition-by-identity (partial partition-by identity))

(def partition-in-group-of-2 
  (comp
   (partial mapcat (partial partition-all 2))
   (partial partition-by-identity)))

(def add-similar-group (partial map (partial apply +)))

(def move-grid (comp 
                (partial take-last 4)
                (partial concat (repeat 4 0))
                (partial add-similar-group)
                (partial partition-in-group-of-2)
                (partial remove-zeros)))

(def convert-columns-to-rows (partial apply mapv vector))

(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move-grid))

(def move-grid-left
  "Moves an entire grid to the left"
  (comp
   (partial map reverse)
   (partial move-grid-right)
   (partial map reverse)))

(def move-grid-down
  "Moves an entire grid down"
  (comp
   (partial convert-columns-to-rows)
   (partial move-grid-right)
   (partial convert-columns-to-rows)))

(def move-grid-up
  "Moves an entire grid up"
  (comp 
   (partial convert-columns-to-rows)
   (partial move-grid-left)
   (partial convert-columns-to-rows)))
