object PartialFunctions {

    def partialFunctionsWithCase() = {
        // fast & easy way to make parital function
        // isDefinedAt & apply are both implemented in a single line with the case statement
        // almost like ternary operators in python & ts
        val doubleEvens: PartialFunction[Int, Int] = {
            case x if (x % 2) == 0 => x * 2
        }

        val tripleOdds: PartialFunction[Int, Int] = {
            case x if (x % 2) != 0 => x * 3
        }

        val whatToDo = doubleEvens orElse tripleOdds

        println(whatToDo(3))
        println(whatToDo(4))

        // result of a partial function can have an `anThen` statement chained to the end
        val addFive = (x: Int) => x + 5

        val andThenChaining = whatToDo andThen addFive

        println(andThenChaining(3))
        println(andThenChaining(4))

        // `andThen` can be used to chain to a different piece of logic
        val printEven: PartialFunction[Int, String] = {
            case x if (x % 2) == 0 => "Even"
        }

        // second type in the partial function definition is the output type
        // first is the input type
        val printOdd: PartialFunction[Int, String] = {
            case x if (x % 2 != 0) => "Odd"
        }

        val superChaining = doubleEvens orElse tripleOdds andThen (printEven orElse printOdd)

        println(superChaining(3))
        println(superChaining(4))
    }

    // partial functions are a trait that build the basis for determining a solution
    // two methods must be applied, isDefinedAt and apply
    // is defined at helps when chaining functions
    def main(args: Array[String]) = {
        println("Hello Partial Functions")

        val doubleEvens: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
            def isDefinedAt(x: Int) = x % 2 == 0
            def apply(v1: Int) = v1 * 2
        }

        val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
            def isDefinedAt(x: Int) = x % 2 != 0
            def apply(v1: Int) = v1 * 3
        }

        // chainging two partial functions
        val whatToDo = doubleEvens orElse tripleOdds

        println(whatToDo(3))
        println(whatToDo(4))

        partialFunctionsWithCase()
    }
}