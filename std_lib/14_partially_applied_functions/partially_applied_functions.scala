object PartiallyAppliedFunctions {

    def currying() = {
        // function with multiple parameters into multiple functions that each take a single parameter
        def multiply(x: Int, y: Int) = x * y
        println((multiply _).isInstanceOf[Function2[_, _, _]])

        val multiplyCurried = (multiply _).curried

        println(multiply(4, 5))
        println(multiplyCurried(3)(3))

        val multiplyCurriedFour = multiplyCurried(4)
        
        println(multiplyCurriedFour(2))
        println(multiplyCurriedFour(4))

        // currying allows you to create special versions of generalized functions...

        def customFilter(f: Int => Boolean)(xs: List[Int]) = xs filter f

        def onlyEven(x: Int) = x % 2 == 0

        val tempList = List(12, 11, 5, 20, 3, 13, 2)

        println(customFilter(onlyEven)(tempList))

        val onlyEvenFilter = customFilter(onlyEven)

        println(onlyEvenFilter(tempList))

    }

    def replacingAnyNumberOfArguments() = {
        def sum(a: Int, b: Int, c: Int) = a + b + c 
        val sumC = sum(1, 10, _: Int)
        println(sumC(4))
        println(sum(4, 5, 6))
    }

    // a partially applied function is one where you don't call or use any params, this creates another function
    // creating new function of an existing one, that has parameters partially called
    def main(args: Array[String]) = {
        println("Hello Partially Applied Functions")
        def sum(a: Int, b: Int, c: Int) = a + b + c;
        val sum3 = sum _

        println(sum3(1, 9, 7))
        println(sum3(4, 5, 6))

        replacingAnyNumberOfArguments()
        currying()
    }
}