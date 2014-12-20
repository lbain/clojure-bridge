(ns drawing.snow-flake
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(def flake (ref nil))
(def background (ref nil))

(defn setup []
  (dosync
   (ref-set flake (q/load-image "images/white_flake.png"))
   (ref-set background (q/load-image "images/blue_background.png")))
  (q/smooth)
  (q/frame-rate 60)
  [{:x 100 :swing 1 :y 10 :speed 1 :width 50 :height 50}
   {:x 100 :swing 1 :y 210 :speed 3 :width 75 :height 75}
   {:x 400 :swing 1 :y 300 :speed 5 :width 200 :height 200}])

(defn draw
  [state]
  (q/background-image @background)
  (dotimes [n 3]
    (let [snowflake (nth state n)]
      (q/image @flake (:x snowflake) (:y snowflake) (:width snowflake) (:height snowflake))))
  )

(defn update-x
  [x swing]
  (let [start (- x swing)
        end (+ x swing)
        new-x (+ start (rand-int (- end start)))]
    (cond
     (> 0 new-x) (q/width)
     (< (q/width) new-x) 0
     :else new-x )))

(defn update-y
  [y speed]
  (if (>= y (q/height))
    0
    (+ y speed)))

(defn update [state]
  (for [p state]
    (merge p {:x (update-x (:x p) (:swing p))
              :y (update-y (:y p) (:speed p))})))

(q/defsketch snow-flake
  :title "Happy Christmas"
  :size [1000 1000]
  :setup setup
  :update update
  :draw draw
  :middleware [m/fun-mode]
  )
