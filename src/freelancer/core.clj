(ns freelancer.core
  (:require [freelancer.console-helpers :as console]
            [freelancer.output-helper :as output-helper]))

(def initial-state {:days-remain 90
                      :available-money 90
                      :happiness 100
                      :hunger 100})

(defn handle-user-choice []
  (do
    (output-helper/print-input-prompt)
    (case (read-line)
      ("w" "work") :go-to-the-work
      ("c" "cafe") :go-to-the-cafe
      ("z" "zoo") :go-to-the-zoo
      :go-to-the-work)))

(defn generate-state-transition [user-choice]
  (case user-choice
    :go-to-the-work { :days-remain -1 :available-money 4  :happiness -3 :hunger -3 }
    :go-to-the-cafe { :days-remain -1 :available-money -3 :happiness -3 :hunger 4  }
    :go-to-the-zoo  { :days-remain -1 :available-money -3 :happiness 4  :hunger -3 }))

(defn apply-state-transition [state state-transition]
  (merge-with + state state-transition))

(defn update-state [state user-choice]
  (apply-state-transition state (generate-state-transition user-choice)))

(defn check-is-game-over [state]
  (cond
    (= (:days-remain state) 0) :you-are-win
    (<= (:available-money state) 0) :lost-all-money
    (<= (:happiness state) 0) :too-sad
    (<= (:hunger state) 0) :too-hungry
    :else :still-in-game))

(defn start-event-loop [state]
  (println "===================")
  (output-helper/print-state state)
  (let [new-state (update-state state (handle-user-choice))]
    (case (check-is-game-over new-state)
      :you-are-win (output-helper/print-you-win "You win! You are the best freelancer! You are got 1.000.000 $")
      :lost-all-money (output-helper/print-you-lose "You lost all money")
      :too-sad (output-helper/print-you-lose "You are too sad")
      :too-hungry (output-helper/print-you-lose "You are too hungry")
      :still-in-game (recur new-state))))

(defn -main [& args]
  (output-helper/print-logo)
  (start-event-loop initial-state))