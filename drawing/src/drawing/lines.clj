(ns drawing.lines
  (:require [quil.core :as q]))

  (defn pos-to-color
    [position]
    (max (min (/ position 2) 255) 0))

  (defn setup []
    (q/frame-rate 30)
    (q/color-mode :rgb)
    (q/stroke 255 0 0))

  (defn draw []
    (q/stroke (pos-to-color (q/mouse-x)) 0 (pos-to-color (q/mouse-y)))
    (q/line 0 0 (q/mouse-x) (q/mouse-y))
    (q/line 499 0 (q/mouse-x) (q/mouse-y))
    (q/line 0 499 (q/mouse-x) (q/mouse-y))
    (q/line 499 499 (q/mouse-x) (q/mouse-y)))

  (q/defsketch hello-lines
    :title "I changed the title"
    :size [500 500]
    :setup setup
    :draw draw )
