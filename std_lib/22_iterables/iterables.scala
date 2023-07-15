object Iterables {

    // yield collection elements one by one
    // implementation below
    // def foreach[U](f: Elem => U): Unit = {
    //     val it = iterator
    //     while (it.hasNext) f(it.next())
    // }
    // subclasses of Iterables override the standard implementation
    // more efficient implementation
    // foreach is the basis of the implementation of all operations in Traversable
    // common iterables: set, list, vector, stack, and stream
    // two important methods: hasNext & next

    def main(args: Array[String]) = {
        println("Hello Iterables")

        val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
        val it = list.iterator
        if (it.hasNext) 
            println(it.next)

        // grouped will return fixed-size Iterable chunks of an Iterable
        val anotherIt = list grouped 3
        println(anotherIt.next())
        println(anotherIt.next())
        println(anotherIt.next())

        // sliding will return an Iterable that shows a sliding window (thing lag / lead)
        val slidingIt = list sliding 3
        println(slidingIt.next())
        println(slidingIt.next())
        println(slidingIt.next())

        // sliding can take the size of the window... along with the step
        // default step is 1
        val slidingThreeIt = list sliding (3, 3)
        println(slidingThreeIt.next())
        println(slidingThreeIt.next())
        println(slidingThreeIt.next())

        // takeRight is the opposite of 'take' in Traversable
        // retrieves the last elements of an Iteralbne
        println(list takeRight 3)

        // drop right will drop a specified number of elements from the right
        // returns the new list
        println(list dropRight 3)

        // zip stiches two iterables into an iterable of pairs of corresponding elements from both iterables
        val xs = List(3, 5, 9)
        val ys = List("Bob", "Ann", "Stella")

        println(xs zip ys)

        // only zips the pairs that work
        val anotherYs = ys dropRight 1
        println(xs zip anotherYs)

        // zipAll can provide fillers for what it couldn't find a compliment for
        println(xs zipAll (anotherYs, -1, "?"))
        val xt = xs dropRight 1
        println(xt zipAll (ys, -1, "?"))

        // zipWithIndex will zip an Iterable with its integer index
        val anotherXs = List("Manny", "Moe", "Jack")
        println(xs.zipWithIndex)
        
        // sameElements will return true if the two Iterables
        // produce the same elements in the same order

        val compXs = List("Manny", "Moe", "Jack")
        val compYs = List("Manny", "Moe", "Jack")

        println(compXs.iterator.sameElements(compYs))

        val compXt = List("Manny", "Moe", "Jack")
        val compYt = List("Manny", "Jack", "Moe")

        println(compXt.iterator.sameElements(compYt))

        val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
        val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
        println(xs1.iterator.sameElements(ys1))

        val xt1 = Set(1, 2, 3)
        val yt1 = Set(3, 2, 1)
        println(xt1.iterator.sameElements(yt1))
    }
}