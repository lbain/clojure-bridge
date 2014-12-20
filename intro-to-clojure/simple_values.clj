;; SIMPLE VALUES

;;-----------------------------------------------------------------------------

;; question 1: assign your home town

;; directions
(comment
  EXERCISE: Store the name of your hometown

  Write the name of your hometown as a string, and then assign that string
  to the name my-hometown.)

;; code
(def my-hometown "Kitchener")

my-hometown; => "Kitchener"

;;-----------------------------------------------------------------------------

;; question 1: format names

;; directions
(comment
  EXERCISE: Make a function to format names

  The str function can take any number of arguments, and it concatenates
  them together to make a string. Write a function called format-name that
  takes two arguments, first-name and last-name.
  This function should output the name like so: Last, First.)

;; code
(defn format-name
  [first-name last-name]
  (str last-name ", " first-name))

(format-name "Lucy" "Bain"); => "Bain, Lucy"