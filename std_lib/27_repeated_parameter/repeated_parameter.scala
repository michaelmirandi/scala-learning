object RepeatedParameters {

    // repeated parameter must be the last & you can add as many as you want
    // similar to kwargs in python
    def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
        "%d %ss can give you %s".format(x, y, z.mkString(", "))
    }

    def main(args: Array[String]) = {
        println("Hello Repeated Parameters")
        println(
            repeatedParameterMethod(
                3,
                "egg",
                "a delicious sandwich", 
                "protein",
                "high cholesterol"
            )
        )

        // can accept a collection as the last parameter, 
        // but will be considered a single object
        println(
            repeatedParameterMethod(
                3,
                "egg",
                List("a delicious sandwich", "protein", "high cholesterol")
            )
        )

        // if you want the expression expanded... then add :_* 
        println(
            repeatedParameterMethod(
                3,
                "egg",
                List("a delicious sandwich", "protein", "high cholesterol"): _*
            )
        )
    }
}