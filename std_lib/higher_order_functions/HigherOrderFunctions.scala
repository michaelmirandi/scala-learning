object HigherOrderFunctions {
  def main(args: Array[String]) = {
    // lambda provides a lightweight syntax for defining anonymous functions
    // aka function literals. At runtime they are instantiated into objects called function values
    // first class functions, just like js/ts :P
    intro()
    closure()
    higherOrder()
    instanceOf()
    closing()
  }

  def intro() = {
    def lambda = {x: Int => x + 1}
    def lambda2 = (x: Int) => x + 2
    def lambda3 = (x: Int) => x + 3

    val lambda4 = new Function1[Int, Int] {
        def apply (v1: Int): Int = v1 - 1
    }

    def lambda5(x: Int) = x + 1
    val result = lambda(3)
    val result1andhalf = lambda.apply(3)

    val result2 = lambda2(3)
    val result3 = lambda3(3)
    val result4 = lambda4(3)
    val result5 = lambda5(3)

    println(result)
    println(result1andhalf)
    println(result2)
    println(result3)
    println(result4)
    println(result5)

    val multiplier = (i: Int) => i * 10
    println(multiplier(10))
  }

  def closure() = {
    // closure is a function which maintains a reference to one or more variables outside of the function scope
    // var is mutable while val is immutable
    var incrementer = 1
    // stores a pointer to incrementer, so if you change it, the lambda function also updates
    def closure = {x: Int => x + incrementer}

    val result1 = closure(10)
    println(result1)

    incrementer = 2

    val result2 = closure(10)
    println(result2)
  }

  def higherOrder() = {
    // Higher order functions are functions that take functions as args and or return functions

    // y is a function and the summation function returns the y function parameter called with the x arg
    def summation(x: Int, y: Int => Int) = y(x)

    var incrementer = 3

    def closure = (x: Int) => x + incrementer

    val result = summation(10, closure)
    println(result)

    incrementer = 4

    val result2 = summation(10, closure)
    println(result2)


    // no syntatic sugar
    // function returns a function
    def addWithoutSyntaxSugar(x: Int): Function[Int, Int] = {
        new Function[Int, Int]() {
            def apply(y: Int): Int = x + y
        }
    }
    println(addWithoutSyntaxSugar(1).isInstanceOf[Function[Int, Int]])

    println(addWithoutSyntaxSugar(2)(3))

    def fiveAdder: Function[Int, Int] = addWithoutSyntaxSugar(5)
    println(fiveAdder(5))
  }

  def instanceOf() = {
    def addWithSyntaxSugar(x: Int) = (y: Int) => x + y
    // isInstanceOf is the same as Java's instanceof, except the parameter types can be blanked out, since they are unknown at run time...
    println(addWithSyntaxSugar(1).isInstanceOf[Function[_, _]])
  }

  def closing() = {
    // having functions as arguments can help in composing functions (think of the map function)
    def makeUpper(xs: List[String]) = xs map {
        _.toUpperCase()
    }
    def makeWhateverYouLike(xs: List[String], sideEffect: String => String) = xs map sideEffect

    println(makeUpper(List("abc", "xyz", "123")))
    println(makeWhateverYouLike(List("ABC", "XYZ", "123"), x => x.toLowerCase()))

    // string formatting... niceeee
    val myName = (name: String) => s"My name is $name"
    println(makeWhateverYouLike(List("John", "Mark"), myName))

    println(List("Scala", "Erlang", "Clojure") map (_.length))
  }
}
