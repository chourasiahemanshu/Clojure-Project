(require '[clojure.string :as str])

(defn ReadFile []
      (with-open [rdr (clojure.java.io/reader "map.txt")]
                 (reduce conj [] (line-seq rdr)))
      )

(def a (vec (ReadFile)))

(def splitString
  (mapv #(str/split % #"") a))

(defn checkBoundaries
      [matrix x y]
      (if (and (>= x 0) (>= y 0))
        (do
          (def xBoundary (count matrix))
          (def yBoundary (count (matrix x)))
          (if (and (< x xBoundary) (< y yBoundary))
            (do
              true)
            (do
              false)
            )
          )
        (do
          false
          )
        )
      )

(def MapMatrix splitString)

(println "Initial Map ")
(let [s (str/join "\n" (map str/join MapMatrix))] (println s))
(println "***************************************************************************")

(defn RecursiveFunc
      [x y]
      (def my-atom (atom 0))
      (if (= ((MapMatrix x) y) "@")
        (do
          (println "Treasure Found")
          (let [s (str/join "\n" (map str/join MapMatrix))] (println s))
          true
          (System/exit 0)
          )
        (do
          (def MapMatrix (assoc-in MapMatrix [x y] "+"))
          ;(println MapMatrix)
          (if (checkBoundaries MapMatrix x (+ y 1))
            (if (or (= ((MapMatrix x) (+ y 1)) "-") (= ((MapMatrix x) (+ y 1)) "@"))
              (do
                (swap! my-atom inc)
                ;(println "moving right")
                (RecursiveFunc x (+ y 1))
                )
              )
            )
          (if (checkBoundaries MapMatrix (+ x 1) y)
            (if (or (= ((MapMatrix (+ x 1)) y) "-") (= ((MapMatrix (+ x 1)) y) "@"))
              (do
                (swap! my-atom inc)
                ;(println "moving bottom")
                (RecursiveFunc (+ x 1) y)
                )
              )
            )
          (if (checkBoundaries MapMatrix x (- y 1))
            (if (or (= ((MapMatrix x) (- y 1)) "-") (= ((MapMatrix x) (- y 1)) "@"))
              (do
                (swap! my-atom inc)
                ;(println "moving left")
                (RecursiveFunc x (- y 1))
                )
              )
            )
          (if (checkBoundaries MapMatrix (- x 1) y)
            (if (or (= ((MapMatrix (- x 1)) y) "-") (= ((MapMatrix (- x 1)) y) "@"))
              (do
                (swap! my-atom inc)
                ;(println "moving top")
                (RecursiveFunc (- x 1) y)
                )
              )
            )
          (if (= @my-atom 0)
            (do
              (reset! my-atom 0)
              (def MapMatrix (assoc-in MapMatrix [x y] "!"))
              )
            )
          )
        )
      )



(RecursiveFunc 0 0)

(println "Treasure not Found")
(let [s (str/join "\n" (map str/join MapMatrix))] (println s))

