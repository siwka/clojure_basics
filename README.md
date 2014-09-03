Define the macro key-ifto have the form

    (key-if test

        :then exp1 exp2...

        :else exp3 exp4...)

This does about the same thing as:

    (cond test (do exp exp)

        :else (do else-exp else-exp))

Almost everything is optional in key-ifexcept the test. Here are some legal forms and their

results:

    user=> (key-if (> 3 1) )

    nil

    user=> (key-if (> 3 1) :then 'ok)

    ok

    user=> (key-if (< 5 3) :else 'ok)

    ok

    user=> (key-if (> 3 1) :else 'oops)

    nil

    user=> (key-if (> 3 1) :then)

    nil

    user=> (key-if (> 3 1) :else 'oops :then 'ok)

    ok

    user=> (key-if (> 3 1) :else 'oops :then (println 'hi) 'ok)

    hi

    ok

Note that a macro is required in order to only evaluate the relevant section. For example,

defining key­ifas a function would cause launching­missilesto be printed, as follows:

    user=>(key-if (>39) :then (println 'launching-missiles)
                        :else 'ok)

    launching-missiles

    ok

This is not the desired behavior.
