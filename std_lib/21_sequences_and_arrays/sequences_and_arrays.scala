object SequencesAndArrays {
    def main(args: Array[String]) = {
        println("Hello Sequences & Arrays")
        // arrays in scala are fixed size & same type
        val l = List(1, 2, 3)
        val a = l.toArray 
        println(a equals Array(1, 2, 3))
        
        // sequences are special cases of iterable collections of class Iterable
        // they always have a defined order of elements
        val s = a.toSeq
        val newL = s.toList
        println(newL)

        // you can create a squence from a for loop
        val anotherS = for (v <- 1 to 4) yield v
        println(anotherS.toList)

        val yetAnotherS = for (v <- 1 to 10 if v % 3 == 0) yield v
        println(yetAnotherS.toList)

        val daS = Seq("hello", "to", "you")
        val filtered = daS.filter(_.length > 2)
        println(filtered)

        // you can filter arrays the same way
        val anotherA = Array("hello", "to", "you", "again")
        val anotherAFiltered = anotherA.filter(_.length > 3)
        println(anotherAFiltered.toList)

        // mapping values in a sequence through the function
        val bruhS = Seq("hello", "world")
        val anotherR = bruhS map {
            _.reverse
        }
        println(anotherR)
    }
}