object ForExpressions {
    // multiple generators in a for comprehension will yield all possible combinations
    // can add conditionals as well... syntax is for (x <- list) yield whatever...
    // multiple generators under the hood uses flatMap & map
    // single generator is translated to a map operation
    // if boolean is used... then filter, flatMap, and map operations are used
    def main(args: Array[String]) = {
        println("Hello For Expressions")
        // for expressions can nest
        val xValues = 1 to 4
        val yValues = 1 to 2
        // creates vector of all possible combinations of x & y values
        // for comprehension
        val coords = for {
            x <- xValues
            y <- yValues 
        } yield (x, y)
        println(coords)

        // for comprehension can make code more readable

        val nums = List(List(1), List(2), List(3), List(4), List(5))
        val result = for {
            // map to list
            numList <- nums
            // map individual number 
            num <- numList
            // only if it's even 
            if (num % 2 == 0)
        } yield (num)

        println(result)

        // same as the following
        println(nums.flatMap(numList => numList).filter(_ % 2 == 0))
        println(nums.flatten.filter(_ % 2 == 0))
    }
}