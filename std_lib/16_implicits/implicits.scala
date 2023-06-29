import java.math.BigInteger
import scala.language.implicitConversions

abstract class SemiGroup[A] {
    def add(x: A, y: A): A
}
// this type of syntax is similar to typescript with dynamic types
abstract class Monoid[A] extends SemiGroup[A] {
    def unit: A
}

// implicits cannot be top level, must be members of a template
// they wrap around existing classes to provide extra functionality
// meta-programming in TypeScript and monkey patching in Ruby

// implicits allow the compiler to automatically convert or supply values when needed
// three common cases for implicits
// conversions: converting one type to another to enable easy operations between types
// parameters: specify a function that can accept parameters implicitly from the scope where its called
// class: add methods to existing types.. pimping or enriching a class.. extension methods
object Implicits {
    def main(args: Array[String]) = {
        println("Hello Implicits")
        implicit object StringMonoid extends Monoid[String] {
            def add(x: String, y: String): String = x concat y
            def unit: String = ""
        }

        implicit object IntMonoid extends Monoid[Int] {
            def add(x: Int, y: Int): Int = x + y
            def unit: Int = 0
        }

        def sum[A](xs: List[A])(implicit m: Monoid[A]): A = 
            if xs.isEmpty then m.unit else m.add(xs.head, sum(xs.tail))

        println(sum(List(1, 2, 3)))
        println(sum(List("a", "b", "c")))

        class KoanIntWrapper(val original: Int) {
            def isOdd = original % 2 != 0 
        }

        given Conversion[Int, KoanIntWrapper] with {
            def apply(value: Int) = new KoanIntWrapper(value)
        }

        println(19.isOdd)
        println(20.isOdd)

        object MyPredef {
            class KoanIntWrapper(val original: Int) {
                def isOdd = original % 2 != 0 
            }

            given Conversion[Int, KoanIntWrapper] with {
                def apply(value: Int) = new KoanIntWrapper(value)
            }
        }

        // implicit rules can be imported into scope
        import MyPredef._
        println(19.isOdd)
        println(20.isOdd)

        implicit def Int2BigIntegerConvert(value: Int): BigInteger = new BigInteger(value.toString())
        
        def add(a: BigInteger, b: BigInteger) = a.add(b)

        println(add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9))

        // TYPES MATTER IN SCALA!!!!
        println(add(3, 6) == 9)

        println(add(3, 6) == Int2BigIntegerConvert(9))

        println(add(3, 6) == (9: BigInteger))

        println(add(3, 6).intValue == 9)

        // implicits can be used to declare a value to be provided as a default as long
        // as an implicit value is set with in the scope...
        // Implicit Function Parameters...

        def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) = 
            dollarsPerHour * hours

        implicit val hourlyRate = BigDecimal(34)

        println(howMuchCanIMake_?(30))

        def howMuchCanIMake__?(hours: Int)(implicit amount: BigDecimal, currencyName: String) = 
            (amount * hours).toString() + " " + currencyName

        implicit val currencyName = "Dollars"

        println(howMuchCanIMake__?(30))

        // default arguments are preferred to implicit function params
        def howMuchCanIMake___?(
            hours: Int, 
            amount: BigDecimal = 34, 
            currencyName: String = "Dollars"
        ) = (amount * hours).toString() + " " + currencyName

        println(howMuchCanIMake___?(30))
        println(howMuchCanIMake___?(30, 95))
    }
}