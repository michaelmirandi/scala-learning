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

        // toIterable will convert any Traversable to an Iterable
        // base trait for all Scala collections defines an iterator 
        // method to iterate through the collections elements
        println(toWhateverSet.toIterable)
        // toSeq converts Traversable to Seq
        // Seq is an ordered Iterable and a superclass to List, Queue, and Vector
        // Sequences provide a method apply for indexing
        println(toWhateverSet.toSeq)
        // toIndexedSeq converst Traversable to an IndexedSeq
        // IndexedSeq is an indexed sequence used in Vectors and Strings...
        println(toWhateverSet.toIndexedSeq)
        // toStream converts Traversables to a LazyList.. elements are evaluated as they 
        // are needed
        val streamList = List(4, 6, 7, 8, 9, 13, 14)
        println((streamList.to(LazyList) take 3))

        // toSet converts Traversable to a Set
        // collection of unordered, unique values
        val setList = List(4, 6, 7, 8, 9, 13, 14)
        println(setList.toSet)

        // toMap converts a Traversable to a Map
        // depends on the original collection (List or Seq)
        val listToMap = List("Phoenix" -> "Arizona", "Austin" -> "Texas")
        println(listToMap.toMap)
        // same thing applies to sets
        val setToMap = Set("Phoenix" -> "Arizona", "Austin" -> "Texas")
        println(setToMap.toMap)

        // intuitive...
        val mapToPlayWith = setToMap.toMap
        println(mapToPlayWith.isEmpty)
        println(mapToPlayWith.nonEmpty)

        val emptySet = Set()
        println(emptySet.isEmpty)
        println(emptySet.nonEmpty)

        // size provides the size of the traversable
        println(mapToPlayWith.size)

        // knownSize will return number of elements if Traversable has finite end... otherwise -1
        println(mapToPlayWith.knownSize)
        val stream = 0 #:: 1 #:: LazyList.empty
        println(stream.knownSize)
        // streams are now know as LazyLists...
        // changed in Scala 2.12
        // use #:: to create a LazyList

        // head returns the first element of an ordered collection
        // random element if order is not defined (map, set)

        val headList = List(10, 19, 45, 1, 22)
        println(headList.head)

        // headOption returns first element as an option of an ordered collection
        // None is returned if there is no first element
        println(headList.headOption)

        val headListTwo = List()
        println(headListTwo.headOption)

        // last returns the last element of an ordered collection
        println(headList.last)

        // same with lastOption...
        // options are important
        // options represent something that may or may not exist...
        println(headList.lastOption)
        println(headListTwo.lastOption)

        // find will locate the first item that matches the predicate p as Some...
        // or None if an element is not found

        println(headList.find(_ % 2 != 0))

        val findList = List(4, 8, 16)
        println(findList.find(_ % 2 != 0))

        // tail returns all but the head...
        println(headList.tail)

        // init returns the rest of the collection without the last element
        println(headList.init)

        // from index and a to index... slice will return a part of the collection
        println(headList.slice(1, 3))

        // take is used to get the first x number of elements
        println(headList.take(3))

        // `makeLazyList` is a recursive function that generates a LazyList starting from `v`
        def makeLazyList(v: Int): LazyList[Int] = v #:: makeLazyList(v + 1)

        // Initialize the LazyList with `makeLazyList(2)`. This creates an infinite sequence starting at 2.
        val a = makeLazyList(2)

        // Print the first 3 elements of the sequence as a List
        println((a take 3).toList) // Prints: List(2, 3, 4)

        // drop will take the rest of the Traversable except the numbers of elements given
        // drop first 6 elements of the array
        println(((a drop 6) take 3).toList)

        // takeWhile will continually accumulate elements unitl a predicate is no longer satisfied
        val takeWhileList = List(87, 44, 5, 4, 200, 10, 39, 100)
        println(takeWhileList.takeWhile(_ < 100))

        // dropWhile will continually drop elements until a predicate is not longer satisfied
        println(takeWhileList.dropWhile(_ < 100))

        // the above are ordered... drop while & take while are sequential
        

        // filter will take out all elements that don't satisfy a predicate
        // Arrays are also Traversable
        val filterArray = takeWhileList.toArray 
        println(filterArray.filter(_ < 100).toList)

        // filterNot will take out all elements that satisfy a predicate
        println(filterArray.filterNot(_ < 100).toList)

        // splitAt will split a Traversable at a position
        // defined as (xs take n, xs drop n)
        val arrayResult = filterArray splitAt 3
        println(arrayResult._1.toList)
        println(arrayResult._2.toList)

        // span will split a Traverable according to a predicate
        // defined as (xs takeWhile p, xs dropWhile p)
        val spanResult = filterArray span (_ < 100)
        println(spanResult._1.toList)
        println(spanResult._2.toList)

        // partition will split a Traversable according a predicate
        // left hand side contains elements satisified by the predicate
        // right hand side contains all the other elements
        val paritionResult = filterArray partition (_ < 100)
        println(paritionResult._1.toList)
        println(paritionResult._2.toList)

        // groupBy will categorize a Traversable accoriding to a given function and return a map with the results
        val oddAndSmallPartial: PartialFunction[Int, String] = {
            case x: Int if x % 2 != 0 && x < 100 => "Odd and less than 100"
        }

        val evenAndSmallPartial: PartialFunction[Int, String] = {
            case x: Int if x != 0 && x % 2 == 0 && x < 100 => "Even and less than 100"
        }

        val negativePartial: PartialFunction[Int, String] = {
            case x: Int if x < 0 => "Negative Number"
        }

        val largePartial: PartialFunction[Int, String] = {
            case x: Int if x > 99 => "Large Number"
        }

        val zeroPartial: PartialFunction[Int, String] = {
            case x: Int if x == 0 => "Zero"
        }

        val partialResult = filterArray groupBy {
            oddAndSmallPartial orElse
            evenAndSmallPartial orElse
            negativePartial orElse
            largePartial orElse
            zeroPartial
        }

        println(partialResult("Even and less than 100").size)
        println(partialResult("Large Number").size)
        println(partialResult)


        // forall will determine if a predicate is valid for all members of a traversable
        val forAllList = filterArray.toList 
        val forAllResult = forAllList.forall(_ < 100)
        println(forAllResult)

        // exists will determine if a predicate is valid for some members of a Traversable
        println(forAllList exists (_ < 100))

        // count will count the number of elements that satisfy a predicate in a Traversable
        println(forAllList.count(_ < 100))

        // foldLeft combines an operation starting with a seed and combining from the left
        // first parameter is the intial value of the fold
        // next is a function that takes two arguments
        // very similar to reduce in js / ts
        val foldList = List(5, 4, 3, 2, 1)
        println(foldList.foldLeft(0) {
            (`running total`, `next element`) => `running total` - `next element`
        })

        println(foldList.foldLeft(0)(_ - _))
        println((((((0 - 5) - 4) - 3) - 2) - 1))

        // foldRight is the exact same, but going from right to left
        println(foldList.foldRight(0) {
            (`running total`, `next element`) => `running total` - `next element`
        })

        println(foldList.foldRight(0)(_ - _))
        println(5 - (4 - (3 - (2 - (1 - 0)))))

        // reduceLeft is similar to foldLeft, except that the seed is the head value
        println(foldList.reduceLeft{_ + _})
        val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
        println(stringList.reduceLeft {_ + _})

        // reduceRight is the same except the seed is the last value
        println(foldList.reduceRight{_ + _})
        println(stringList.reduceRight {_ + _})

        // some methods take much of the folding work out by providing basic funtionality
        val intList = foldList.toList
        println(intList.sum)
        println(intList.product)
        println(intList.max)
        println(intList.min)

        // naive recursive implementation of reduceRight is not tail recursive
        // lead to stack overflow if used on larger traversables
        // reduceLeft can be implemented with tail recursion
        // can avoid stack overflow with reduceRight by transforming list 
        // and using reduceLeft and inverting the reduce function
        println(intList.reduceRight((x, y) => x - y))
        println(intList.reverse.reduceLeft((x, y) => y - x))
        println(intList.reverse.reduce((x, y) => y - x))

        // transpose will take a traversable of traversables and group them by their
        // position in it's own traversable
        val transposeList = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
        println(transposeList.transpose)

        val anotherTransposeList = List(List(1), List(4))
        println(anotherTransposeList.transpose)

        // mkString will format a Traversable using a given string as the delimiter
        // similar to join in python
        val antList = (1 to 5).toList 
        println(antList.mkString(","))

        // also takes a beginning and end string to surround the list
        println(antList.mkString(">", ",", "<"))

        // addString will take a StringBuilder to add the contents of list into the builder
        val stringBuilder = new StringBuilder()
        val stringBuilderList = (1 to 15).toList 
        stringBuilder.append("I want all numbers 6-12: ")
        stringBuilderList.filter(it => it > 5 && it < 13).addString(stringBuilder, ",")
        println(stringBuilder.mkString)
    }
}