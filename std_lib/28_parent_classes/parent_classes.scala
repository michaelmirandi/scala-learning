abstract class Soldier(val firstName: String, val lastName: String) {
    // abstract classes in Java cannot be instantiated and only inherited.
    // just like in Java, classes can be placed inside an abstract class
    class Catch(val number: Long) {
        println("Catch here! %s".format(number))
    }
}
class Pilot(override val firstName: String, override val lastName: String, val squadron: Long)
    extends Soldier(firstName, lastName)

object ParentClasses {
    def main(args: Array[String]) = {
        println("Hello Parent Classes")
        // all values in Scala are objects (opposite of Java)
        // Scala is class-based, and all values are instances of a class
        // Class hierarchy is linear, a class can only extend from one parent
        // NO MULTI-INHERITANCE!
        val pilot = new Pilot("John", "Yossarian", 256)
        println(pilot.firstName)
        println(pilot.lastName)

        // a class that extends from a parent is polymorphic
        val soldier: Soldier = pilot
        println(soldier.firstName)
        println(soldier.lastName)

        val catchNo = new pilot.Catch(22)
        println(catchNo.number)

    }
}