(ns leiningen.tag
  (:require [clojure.java.shell :refer [sh]]))

(defn snapshot? [version]
  (.endsWith version "-SNAPSHOT"))

(defn snapshot-timestamp [version]
  (if (snapshot? version)
    (let [time  (System/currentTimeMillis)
          ftime #(format (apply str (map (partial str "%1$t") %)) time)]
      (.replaceAll version "SNAPSHOT" (str (ftime "Ymd") "." (ftime "HMS"))))
    version))

(defn tag
  "Tag the current commit with the current version.

Creates an annotated git tag on HEAD for the current version
in project.clj."
  [project]
  (let [version (snapshot-timestamp (:version project))
        {:keys [out err]} (sh "git" "tag"
                              "-fa" version
                              "-m"  (format "version %s" version))]
    (print (cond (not (empty? out)) out
                 (not (empty? err)) err
                 :else "No output."))
    (flush)))