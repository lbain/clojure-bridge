;; DATA STRUCTURES 2

;;-----------------------------------------------------------------------------

;; question 1

;; directions
(comment
  EXERCISE 1: Modeling Yourself

  Make a map representing yourself. Make sure it contains your first name and
  last name. Then, add your hometown to the map using assoc or merge.)

;; code
(def me {:first "Lucy" :last "Bain"})
(def me (merge me {:hometown "Sydney"}))

;;-----------------------------------------------------------------------------

;; question 2

;; directions
(comment
  EXERCISE 2: Get the names of people

  Create a function called get-names that takes a vector of maps of people
  and returns a vector of their names.

  Here is an example of how it should work:

  (get-names [{:first "Margaret" :last "Atwood"}
              {:first "Doris" :last "Lessing"}
              {:first "Ursula" :last "Le Guin"}
              {:first "Alice" :last "Munro"}])

  ;=> ["Margaret Atwood" "Doris Lessing" "Ursula Le Guin" "Alice Munro"]
  Hint: First, create a function that returns the name when given a single
  person's map. Consider using the function Map (covered on Functions to
  apply that function to each element in your list of maps. )

;; code
(defn get-first-name
  [person]
  (get person :first))


(defn get-names
  [people]
  (map get-first-name people))

(get-names [{:first "Margaret" :last "Atwood"}
            {:first "Doris" :last "Lessing"}
            {:first "Ursula" :last "Le Guin"}
            {:first "Alice" :last "Munro"}])

;;-----------------------------------------------------------------------------

;; question 3

;; directions
(comment
  EXERCISE 3: Modeling your classmates

  First, take the map you made about yourself.

  Then, create a vector of maps containing the first name, last name and hometown
  of two or three other classmates around you.

  Lastly, add your map to their information using conj.

  Use the get-names function from Exercise 2 to output a list of the names.)

;; code
(def person1 {:first "Alice" :last "Fake" :hometown "Pairs"})
(def person2 {:first "Bob" :last "Fake" :hometown "Beijing"})

(def people (conj [person1 person2] me))