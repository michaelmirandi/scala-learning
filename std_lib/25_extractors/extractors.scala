// extractor object
object Twice {
  def apply(x: Int): Int = x
  def unapply(z: Int): Option[String] =
    if (z % 2 == 0) Some("We have an even number!") else None
}

case class Employee(firstName: String, lastName: String)

class Car(
    val make: String,
    val model: String,
    val year: Short,
    val topSpeed: Short
) {
  def unapply(x: Car) = Some((x.make, x.model))
}

object ChopShop {
  def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
}

// classes typically have an accompaning object
// they can be named the same thing!!
class AnotherEmployee(
    val firstName: String,
    val middleName: Option[String],
    val lastName: String
)

object AnotherEmployee {
  def unapply(x: AnotherEmployee) = Some(
    (x.lastName, x.middleName, x.firstName)
  )
}

object Tokenizer {
  def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
  def unapply(x: AnotherEmployee) = Some((x.firstName, x.lastName))

}

object Extractors {
  // patterns can be defined independently of case classes
  // method named unapply is defined to yield an extractor
  // two conventions at work:
  // case Twice(n) will invoke Twice.unapply
  // unapply is used to match even numbers
  // whatever unapply returns if the arg has matched or not

  // apply is not necessary for pattern matching, only used to mimick a constructor
  def main(args: Array[String]) = {
    println("Hello Extractors")
    // same as Twice(21).apply
    val x = Twice(21)
    x match {
      case Twice(n) => println(n);
      case _        => println("Not an even number")
    }
    println(x)

    // the return type of unapply should be chosen as...
    // just a boolean
    // single sub-value of type T, (Option[T])
    // several sub-values (Option[(T1, ..., Tn)])

    // if the number of sub-values isn't fixed
    // use unapplySeq.. last sub-vlue type Tn has to be Seq[S]
    // used to match List cases

    // case classes can automatically be used with pattern matching... as they have an extractor
    val rob = new Employee("Robin", "Williams")

    val result = rob match {
      case Employee("Robin", _) => "Where's Batman?"
      case _                    => "No Batman Joke For You"
    }

    println(result)

    // an extractor in Scala is a method in any object called unapply
    // used to disassemble the object given by returning a tuple wrapped in an option
    // extractors can be used to assign values

    // very similar to tuple deconstruction in TS or unpacking in python...
    // more powerful than tuple deconstruction & unpacking because it's user defined!!!!
    val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)
    println(s"$a, $b, $c, $d")

    // u & v arent used so they can be replaced with _
    val yer = new Car("Chevy", "Camaro", 1978, 120) match {
      case ChopShop(s, t, u, v) => (s, t)
      case _                    => ("Ford", "Edsel")
    }

    println(s"$yer")

    val tokenResult =
      new AnotherEmployee("Kurt", None, "Vonnegut") match {
        case Tokenizer(c, d) => "c: %s, d: %s".format(c, d)
        case _               => "Not found"
      }

    println(tokenResult)

    // extractor can be any stable object...
    // including instantiated classes with an unapply method
    val camaro = new Car("Chevy", "Camaro", 1978, 122)
    val camaroResult = camaro match {
      case camaro(make, model) => "make: %s, model: %s".format(make, model)
      case _                   => "unknown"
    }

    println(camaroResult)

    // custom extractors are typically created in the companion object of the class
    // class
    val singri = new AnotherEmployee("Singri", None, "Keerthi")
    val AnotherEmployee(anotherX, y, z) = singri
    println(s"$anotherX, $y, $z")

    // use unapply for pattern matching employee objects
    val singriResult = singri match {
      // object
      case AnotherEmployee("Singri", None, x) =>
        "Yay, Singfri %s! with no middle name!".format(x)
      case AnotherEmployee("Singri", Some(x), _) =>
        "Yay, Singfri with a middle name of %s".format(x)
      case _ => "I don't care, going on break"
    }

    println(singriResult)
  }
}
