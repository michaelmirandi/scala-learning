object InfixTypes {
    def main(args: Array[String]) = {
        println("Hello Infix Types")
        // infix operators
        // T1 op T2 -> op[T1, T2]
        // op may be an arbitrary identifier execept for *
        // * is reserved as a postfix modifier
        // infix is when an operator is used between its arguments
        // you can make an infix type, meaning the type can be displayed in complement between two types
        // enables readable declaration

        case class Person(name: String) {
            def loves(person: Person) = new Loves(this, person)
        }
        class Loves[A, B](val a : A, val b: B)

        def announceCouple(couple: Person Loves Person) = 
            couple.a.name + " is in love with " + couple.b.name

        val romeo = new Person("Romeo")
        val juliet = new Person("Juliet")
        println(announceCouple(new Loves(romeo, juliet)))

        // this can be made more elegant by creating an infix operator method to use with the infix type
        println(announceCouple(romeo loves juliet))
    }
}