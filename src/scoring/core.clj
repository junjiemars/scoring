(ns scoring.core
  (:gen-class))

(defn tf
  "Returns the term's frequency defined as the number of times term t appears in
   the currently scored document d, tf(t in d). Documents that have more 
   occurrences of a given term receive a higer score."
  [term-frequency]
  (Math/sqrt term-frequency))

(defn idf
  "Returns the inverse document frequency, it correlates to the inverse of the 
   number of documents in which the term appears. This means rarer terms give
   higher contribution to the total score."
  [number-of-documents document-frequency]
  (inc (Math/log (/ number-of-documents (inc document-frequency)))))

(defn coord
  "Returns the factor based on how many of the query terms are found in the 
   specified document which be computed at search time. A document that contains 
   more of the query's terms will receive a higher score than another document 
   with fewer query terms."
  [number-terms-of-query number-terms-in-document ]
  (/ number-terms-in-document number-terms-of-query))

(defn length-norm
  "Returns the length norm of a field which measures the importance of a term 
   according to the total number of terms in the field. A term matched in fields 
   with less terms have a higher score."
  [number-of-terms-in-field]
  (/ 1 (Math/sqrt number-of-terms-in-field)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
