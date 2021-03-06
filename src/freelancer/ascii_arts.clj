(ns freelancer.ascii-arts
  (:require [clojure.string :as string]))

(def logo
  (string/join
    "\n"
    ["███████╗██████╗ ███████╗███████╗██╗      █████╗ ███╗   ██╗ ██████╗███████╗██████╗ ",
     "██╔════╝██╔══██╗██╔════╝██╔════╝██║     ██╔══██╗████╗  ██║██╔════╝██╔════╝██╔══██╗",
     "█████╗  ██████╔╝█████╗  █████╗  ██║     ███████║██╔██╗ ██║██║     █████╗  ██████╔╝",
     "██╔══╝  ██╔══██╗██╔══╝  ██╔══╝  ██║     ██╔══██║██║╚██╗██║██║     ██╔══╝  ██╔══██╗",
     "██║     ██║  ██║███████╗███████╗███████╗██║  ██║██║ ╚████║╚██████╗███████╗██║  ██║",
     "╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝╚══════╝╚═╝  ╚═╝"
     ]))

(def you-lose
  (string/join
    "\n"
    ["__   __            _                ",
     "\\ \\ / /           | |               ",
     " \\ V /___  _   _  | | ___  ___  ___ ",
     "  \\ // _ \\| | | | | |/ _ \\/ __|/ _ \\",
     "  | | (_) | |_| | | | (_) \\__ \\  __/",
     "  \\_/\\___/ \\__,_| |_|\\___/|___/\\___|",
     "                                    "
     ]))

(def you-win
  (string/join
    "\n"
    ["__   __                     _         _ ",
     "\\ \\ / /                    (_)       | |",
     " \\ V /___  _   _  __      ___ _ __   | |",
     "  \\ // _ \\| | | | \\ \\ /\\ / / | '_ \\  | |",
     "  | | (_) | |_| |  \\ V  V /| | | | | |_|",
     "  \\_/\\___/ \\__,_|   \\_/\\_/ |_|_| |_| (_)",
     "                                        "
     ]))