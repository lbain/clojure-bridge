;; FLOW CONTROL

;;-----------------------------------------------------------------------------

;; question 1: names

;; directions
(comment
  EXERCISE: Even more name formatting
  Write a function format-name that takes a map representing a user, with keys
  :first, :last, and possibly :middle. It should return their name as a string.

  BONUS: Flexible name formatting
  Change format-name to take a second argument, order. If order equals :last,
  then the format should be "Last, First Middle"; otherwise, it should be
  "First Middle Last.")

;; code
;; Get basic names
(defn first-name
  [person]
  (get person :first))

(defn last-name
  [person]
  (get person :last))

(defn middle-name
  [person]
  (get person :middle))

;; last name first formated names
(defn last-first-name
  [person]
  (str (last-name person) ", " (first-name person)))

(defn last-first-middle-name
  [person]
  (str (last-name person) ", " (first-name person) " " (middle-name person)))

;; first name first formated names
(defn first-last-name
  [person]
  (str (first-name person) " " (last-name person)))

(defn first-middle-last-name
  [person]
  (str (first-name person) " " (middle-name person) " " (last-name person)))

;; Full last name first formated name
(defn format-name-last
  [person]
  (if (get person :middle)
    (last-first-middle-name person)
    (last-first-name person)))

;; Full first name first formated name
(defn format-name-first
  [person]
  (if (get person :middle)
    (first-middle-last-name person)
    (first-last-name person)))

;; Main method
(defn format-name
  [person, order]
  (if (= order :first)
    (format-name-first person)
    (format-name-last person)))

;; Test data
(format-name {:first "Ursula" :last "Le Guin" :middle "K."}, :first)
(format-name {:first "Margaret" :last "Atwood"}, :first)

(format-name {:first "Ursula" :last "Le Guin" :middle "K."}, :last)
(format-name {:first "Margaret" :last "Atwood"}, :last)

;;-----------------------------------------------------------------------------

;; question 2: ordinal numbers

;; directions
(comment
  BONUS: Ordinal numbers

  Given a number (positive integer), return the string representing the ordinal
  number. For many numbers, this is done by adding "th" to the end. As part
  one, let us make an exception for numbers ending in a 1, 2, or 3, by adding
  "st", "nd", or "rd" respectively. You will need the rem function, which takes
  2 integers and returns the remainder from dividing the first by the second.
  You will also find that nesting if forms (putting one inside another) to
  be useful.)

;; code
;; sad way
(defn ordinal
  [num]
  (let [remainder (mod num 10)]
    (if (> remainder 3)
      (str num "th")
      (if (= remainder 1)
        (str num "st")
        (if(= remainder 2)
          (str num "nd")
          (if(= remainder 3)
            (str num "rd")))))))

;; happy way
(defn ordinal
  [num]
  (let [remainder (mod num 10)]
    (cond
      (= remainder 1) (str num "st")
      (and(>= num 10)
          (<= num 13))(str num "th")
      (= remainder 2) (str num "nd")
      (= remainder 3) (str num "rd")

      :else (str num "th"))))

;; Test data
(ordinal 1)  ;=> "1st"
(ordinal 2)  ;=> "2nd"
(ordinal 3)  ;=> "3rd"
(ordinal 4)  ;=> "4th"
(ordinal 5)  ;=> "5th"
(ordinal 10) ;=> "10th"
(ordinal 11) ;=> "11th"
(ordinal 12) ;=> "12th"
(ordinal 13) ;=> "13th"
(ordinal 14) ;=> "14th"
(ordinal 21) ;=> "21st"
(ordinal 22) ;=> "22nd"