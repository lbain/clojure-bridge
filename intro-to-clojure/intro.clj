;; INTRO

;; directions
(comment
  EXERCISE: Basic arithmetic

  Take your height in feet and inches and convert it to inches using arithmetic in Clojure.
  (For those of you that grew up metric-only, there are 12 inches in a foot).

  Then convert that to centimeters. There are 2.54 centimeters in an inch.

  Lastly, ask two people near you for their height in centimeters. Find the average of your heights.

  Bonus: Convert that average back to feet and inches. The feet and the inches will be separate numbers.
  (quot x y) will give you the whole number part when dividing two numbers.
  (mod x y) will give you the remainder when dividing two numbers.)

;; code
;; my height in cm
(def feet 5)
(def inches 4)
(def height-in-inches (+ ( * feet 12) inches))
(def cm-in-inch 2.54)
(def height-in-centemeters ( * height-in-inches cm-in-inch ))


;; average height for 3 people in centemeters
(def height1 height-in-centemeters)
(def height2 165)
(def height3 165)
(def avg-height (/ (+ height1 height2 height3) 3))

;; average height for 3 people in feet and inches
(def avg-height-inches (/ avg-height cm-in-inch))
(def avg-feet (quot avg-height-inches 12))
(def avg-inches ( - avg-height-inches (* avg-feet 12)))
