object EmptyValues {
    def main(args: Array[String]) = {
        println("Hello Empty Values")
        /*
            null is the same as in java
            Any reference type can be null
            Value types like Int's can't be null

            Null is a trait whose only instance is null
            Reference types can be assigned null, and value types can't

            Nothing is a trait that is guaranteed to have zero instances
            Purpose is for methods that never return normally (exceptions)
            And to provide a type for Nil

            Unit in scala is the equivalent of void in Java,
            used as a function's signature when the function doesn't return a value

            Nil is just an empty list
            List[Nothing]
        */

        println(List() == Nil)

        // None is the counterpart to Some, used when you're using Scala's Option class to help avoid null references
        println(None == None)

        // None should be identical to None
        println(None eq None)

        // conversion to string
        println(None.toString)

        // conversion to empty list
        println(None.toList == Nil)

        println(None.isEmpty)

        // two key variable types (reference types & value types)
        println(None.asInstanceOf[Any] == None)
        println(None.asInstanceOf[AnyRef] == None)
        println(None.asInstanceOf[AnyVal])

        // None can be used with Option instead of null references
        val optional: Option[String] = None
        println(optional.isEmpty)
        println(optional)

        // Some is the opposite of None for Option Types
        val anotherOption: Option[String] = Some("Some Value")
        println(anotherOption == None)
        println(anotherOption.isEmpty)

        // Option.getOrElse can be used to provide a default
        val yetAnotherOption: Option[String] = Some("Some Value")
        val yetAnotherOptionAgain: Option[String] = None

        println(yetAnotherOption.getOrElse("No Value"))
        println(yetAnotherOptionAgain.getOrElse("No Value"))

        /*
            Value types:
                Basic data types that represent simple values (int, double, char, boolean)
                Stored on the stack & passed by value
                When you pass a value type to a function, you're passing a copy of that value
                Don't support methods and fields in the traditional OOP sense

            Reference types:
                Represent objects
                All custom, user-defined types, like classes, traits, and objects are reference types
                Stored on the heap
                Passing a reference type to a function passes the pointer, not a copy of the object
                String, List, Array, and all user-defined class and object instances

            Value classes can provide a middle ground by allowing more efficient user-defined
            types in certain scenarios 

            
        */
    }
}