;; DATA STRUCTURES

;; directions
(comment
  EXERCISE: Make a vector

  Make a vector of the high temperatures for the next 7 days in the town where you live.
  Then use the nth function to get the high temperature for next Tuesday.)

;; code
(def high-temps (vector 23 27 28 27 29 29 26 25))
(nth high-temps 4)
