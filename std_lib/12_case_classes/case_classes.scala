import java.io.Serializable

object CaseClasses {

    // It only makes sense to define case classes if pattern matching is used to decompose data structures
    // case classes are a nice little wrapper on top of classes to be more productive in scala
    // structural vs. referential equality (easy with case class)
    // built in toString methods & other helpers
    // don't need to use 'new' keyword for each new object
    // automatic params

    def example() = {
        abstract class Term
        case class Var(name: String) extends Term
        case class Fun(arg: String, body: Term) extends Term
        case class App(f: Term, v: Term) extends Term
        println(Fun("x", Fun("y", App(Var("x"), Var("y")))))

        // constructor parameters are public attributes
        println(Var("x").name)

        // structural integrity
        val x1 = Var("x")
        val x2 = Var("x")
        val y1 = Var("y")
        // to string methods and structural equality
        // structural vs. referential equality (== vs. === in ts / js)
        println("" + x1 + " == " + x2 + " => " + (x1 == x2))
        println("" + x1 + " == " + y1 + " => " + (x1 == y1))
    }

    def personExample() = {
        case class Person(first: String, last: String)
        
        val p1 = new Person("Fred", "Jones")
        val p2 = new Person("Shaggy", "Rodgers")
        val p3 = new Person("Fred", "Jones")

        // structural
        println(p1 == p2)
        println(p1 == p3)

        // referential
        println(p1 eq p2)
        println(p1 eq p3)

        // case classes have automatic hash codes
        println(p1.hashCode() == p2.hashCode())
        println(p1.hashCode() == p3.hashCode())
    }

    def convenience() = {
        case class Dog(name: String, breed: String)

        // can be done with or without the new keyword
        val d1 = Dog("Scooby", "Doberman")
        val d2 = Dog("Rex", "Custom")
        val d3 = new Dog("Scooby", "Doberman")

        println(d1 == d3)
        println(d1 == d2)
        println(d2 == d3)

        // handy toString method in case clase
        println(d1.toString)

        // auto properties
        println(d1.name)
        println(d1.breed)
    }

    def mutableAttributes() = {
        // can change name later... but not breed
        case class Dog(var name: String, breed: String)
        val d1 = Dog("Scooby", "Doberman")
        println(d1.name)
        d1.name = "Scooby Doo"
        println(d1.name)
    }

    def saferAlternatives() = {
        case class Dog(name: String, breed: String)
        val d1 = Dog("Scooby", "Doberman")

        val d2 = d1.copy(name = "Scooby Doo")

        println(d1.name)
        println(d1.breed)

        println(d2.name)
        println(d1.breed)
    }

    def defaultAndNamedProperties() = {
        case class Person(first: String, last: String, age: Int = 0, ssn: String = "")
        val p1 = Person("Fred", "Jones", 23, "111-22-3333")
        val p2 = Person("Samantha", "Jones")
        val p3 = Person(
            last = "Jones",
            first = "Fred",
            ssn = "111-22-3333"
        ) 
        val p4 = p3.copy(age = 23)
        println(p1.first)
        println(p1.last)
        println(p1.age)
        println(p1.ssn)

        println(p2.first)
        println(p2.last)
        println(p2.age)
        println(p2.ssn)

        println(p3.first)
        println(p3.last)
        println(p3.age)
        println(p3.ssn)
                
    }

    def disassembleToTuple() = {
        case class Person(first: String, last: String, age: Int = 0, ssn: String = "")
        val p1 = Person("Fred", "Jones", 23, "111-22-3333")

        // unapply does not return a tuple of values in scala +2.10
        val parts = Person.unapply(p1)

        println(parts)
    }

    def serializableClasses() = {
        case class PersonCC(firstName: String, lastName: String)
        val indy = PersonCC("Indiana", "Jones")

        println(indy.isInstanceOf[Serializable])

        class Person(firstName: String, lastName: String)
        val junior = Person("Indiana", "Jones")
        println(junior.isInstanceOf[Serializable])

    }

    // case classes provide recursive decomposition
    // abstract vs. concrete class
    def main (args: Array[String]) = {
        println("Hello Case Classes")
        example()
        personExample()
        convenience()
        mutableAttributes()
        saferAlternatives()
        defaultAndNamedProperties()
        disassembleToTuple()
        serializableClasses()
    }
}