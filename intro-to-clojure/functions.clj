;; FUNCTIONS 1

;; directions
(comment
  EXERCISE: Find the average

  Create a function called average that takes a vector of bill amounts and
  returns the average of those amounts.

  Hint: You will need to use reduce and count.)

;; code
(defn total-with-tip
  "Given subtotal, return total after tax and tip."
  [subtotal tip-pct]
  (* 1.10 subtotal (+ 1 tip-pct)))

(total-with-tip 10 0.5)

(defn share-per-person
  [subtotal tip-pct num-ppl]
  (/ (total-with-tip subtotal tip-pct) num-ppl))

(share-per-person 10 0.5 3)

(defn average
  [bill-amounts]
  (/ (reduce + bill-amounts) (count bill-amounts)))

(average [ 1 2 3 4 5])