object Traversable {
    def main(args: Array[String]) = {
        println("Hello Traversables")
        // top of collection hierarchy is the trait Traversable
        // only abstract operation is foreach
        // def foreach[U](f: Elem => U)

        // any collection class that implements Traversable just needs to define this method
        // all other methods can be inhierted from Traversable
        // Traversables are subclasses of: List, Array, Map, Set, and Stream
        // ++ appends two traversables together

        val set = Set(1, 9, 10, 22)
        val list = List(3, 4, 5, 10)
        // this will yield a set (first type)
        val result = set ++ list 
        println(result.size)

        // this will yield list (first type)
        val result2 = list ++ set 
        println(result2.size)

        val newSet = Set(1, 3, 4, 6)
        val newResult = newSet.map(_ * 4)
        println(newResult.lastOption)

        // flatten will pack all child Traversables into a single Traversable
        val listToFlatten = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
        println(listToFlatten.flatten)

        // flatMap will apply a function to a Traversable of Traversables
        val flatMapped = listToFlatten.flatMap(_.map(_ * 4))
        println(flatMapped)

        val anotherList = List(1, 2, 3, 4, 5)
        val anotherListResult = anotherList.flatMap(it => if (it % 2 == 0) Some(it) else None)
        println(anotherListResult)

        // collect applies a partial function to all elements
        // returns a different collection
        val collectList = List(4, 6, 7, 8, 9, 13, 14)
        val collectResult = collectList.collect {
            case x: Int if (x % 2 == 0) => x * 3
        }

        println(collectResult)

        // case fragments can be chained together to make a more robust result
        val partialFunction1: PartialFunction[Int, Int] = {
            case x: Int if x % 2 == 0 => x * 3
        }

        val partialFunction2: PartialFunction[Int, Int] = {
            case y: Int if y % 2 != 0 => y * 4
        }

        // infix prefix syntax
        val chainedResult = collectList.collect(partialFunction1 orElse partialFunction2)
        println(chainedResult)

        // foreach will apply a function to all elements of a Traversable
        // unlike map... it will reutrn a Unit type...
        // equivalent of void in Java / C++
        val forEachList = List(4, 6, 7, 8, 9, 13, 14)
        forEachList.foreach(num => println(num * 4))
        println(forEachList)

        // toArray converts a Traversable to an Array...
        // special wrapper around primitive Java array
        val toWhateverSet = Set(4, 6, 7, 8, 9, 13, 14)
        println(toWhateverSet.toArray)
        // toList converts a Traversable to a List
        println(toWhateverSet.toList)

        // toList, toSet, and toArray will not convert if the collection type is the same
        val testList = List(5, 6, 7, 8, 9)
        val testResult = testList.toList 
        println(testResult eq testList)
    }
}