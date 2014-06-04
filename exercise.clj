(defn return-expression
	[keywd coll]
	(let [tmp (if (= keywd :then) :else :then)]
	(if (= keywd (first coll))
		 (filter #(not= keywd %)(take-while #(not= % tmp ) coll))	
		 (filter #(not= keywd %)(drop-while #(not= % keywd) coll))))


(defmacro key-if
	[test & coll]
	`(cond
		~test (do ~@(return-expression :then coll))
		:else (do ~@(return-expression :else coll))))
