(ns freelancer.output-helper
  (:require [freelancer.console-helpers :as console]
            [freelancer.ascii-arts :as arts]))

(defn print-input-prompt []
  (println "⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺")
  (println (console/attributed-string "What are you going do?" :blue :normal))
  (println (console/attributed-string "Go to the (w)ork" :bold :white))
  (println (console/attributed-string "Go to the (c)afe" :bold :white))
  (println (console/attributed-string "Go to the (z)oo" :bold :white))
  (print (console/attributed-string "▶︎ Your choice: " :normal :white))
  (flush))

(defn print-logo []
  (println (console/attributed-string arts/logo :blue))
  (println (console/attributed-string "version 1.0" :white)))

(defn print-you-lose [reason]
  (println (console/attributed-string arts/you-lose :red))
  (println (console/attributed-string (str "reason: " reason) :white)))

(defn print-you-win [congratulations]
  (println (console/attributed-string arts/you-win :green))
  (println (console/attributed-string congratulations :white)))

(defn- calculate-color
  "Calculate a color of the text based on the given value"
  [value]
  (cond
    (>= value 70) :green
    (>= value 30) :yellow
    (>= value 0) :red))

(defn- print-days-remain [count]
  (println
    (str (console/attributed-string "Days remain : " :bold :blue)
         (console/attributed-string count :normal))))

(defn- print-available-money [count]
  (let [color (calculate-color count)]
    (println
      (console/attributed-string "Available money : " :bold color)
      (console/attributed-string count :normal color))))

(defn- print-hunger [count]
  (let [color (calculate-color count)]
    (println
      (console/attributed-string "Hunger : " :bold color)
      (console/attributed-string count :normal color))))

(defn- print-happiness [count]
  (let [color (calculate-color count)]
    (println
      (console/attributed-string "Happiness : " :bold color)
      (console/attributed-string count :normal color))))

(defn print-state [state]
  (print-days-remain (:days-remain state))
  (print-available-money (:available-money state))
  (print-hunger (:hunger state))
  (print-happiness (:happiness state)))