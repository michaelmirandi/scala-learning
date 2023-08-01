object PigLatinizer { 
    def apply(x: => String) = x.tail + x.head + "ay"
}

// either is intuitive...
// throwable is a superclass of all the errors used for exception handling
// Unit indicates a type that has no meaniful value if being returned
// Unit is synonomous with None, Undefined, and Void
object BynameParameter {
    def calc(x: () => Int): Either[Throwable, Int] = {
        try Right(x())
        catch {
            case b: Throwable => Left(b)
        }
    }

    def anotherCalc(x: => Int): Either[Throwable, Int] = {
        try Right(x)
        catch {
            case b: Throwable => Left(b)
        }
    }

    def main(args: Array[String]) = {
        println("Hello byname parameter")
        // () => Int is a Function type that takes a Unit type
        // Unit is known as void to a Java programmer
        val y = calc{() => 14 + 15 }

        println(y)

        // by-name param does the same thing,
        // but no need to explicitly handle the Unit or ()
        val anotherY = anotherCalc {
            println("Here we go!!!")
            val z = List(1, 2, 3, 4)
            49 + 20
        }

        println(anotherY)

        val result = PigLatinizer {
            val x = "pret"
            val z = "zel"
            x ++ z
        }

        println(result)
    }
}