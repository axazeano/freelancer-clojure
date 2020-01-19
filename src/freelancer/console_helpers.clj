(ns freelancer.console-helpers
  (:require [clojure.string :as string]))

(defn convert-attribute [attribute]
  (case attribute
    ;; Colors
    :red "\u001b[31m"
    :green "\u001b[32m"
    :yellow "\u001b[33m"
    :white "\u001b[37m"
    :blue "\u001b[34m"
    ;; Format
    :bold "\u001b[1m"
    :normal "\u001B[0m"))

(defn attributed-string [s & attributes]
  (str (string/join (map convert-attribute attributes)) s))