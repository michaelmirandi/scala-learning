// all elements of list must have same type
// lists are immutable, while arrays are not
// lists represent a linked list, whereas arrays are flat

object Lists {
    def main (args: Array[String]) = {
        val a = List(1, 2, 3)
        val b = List(1, 2, 3)

        // object equality (js's ===)
        println(a eq b)
        // content equality (js's ==)
        println(a == b)

        nil_lists()
        inline_creation()
        access_methods()
        immutable()
        useful_utility_methods()
        shorthand()
        reduce()
        range()
        prepend_and_concat()
        reuse_tails()
    }

    def nil_lists() = {
        val a: List[String] = Nil
        val b: List[Int] = Nil

        println(a == Nil)
        println(a eq Nil)
    
        println(b == Nil)
        println(b eq Nil)

        println(a == b)
        println(a eq b)
    }

    def inline_creation() = {
        val a = List(1, 2, 3)
        println(a eq List(1, 2, 3))
    }

    def access_methods() = {
        val a = List(1, 2, 3)
        println(a.headOption == Some(1))

        println(a.tail == List(2, 3))

        val b = List(1, 3, 5, 7, 9)

        println(b(0) eq 1)
        println(b(2) eq 5)
        println(b(4) eq 9)

        // intercept[IndexOutOfBoundsException] {
        //     println(a(5))
        // }
    }

    def immutable() = {
        val a = List(1, 3, 5, 7, 9)
        val b = a.filterNot(v => v == 5)

        println(a eq List(1, 3, 5, 7, 9))
        println(b eq List(1, 3, 7, 9))
    }

    def useful_utility_methods() = {
        val a = List(1, 3, 5, 7, 9)
        println(a.length)
        println(a.reverse)

        println(a.map {v => v * 2})
        println(a.filter {v => v % 3 == 0})
    }

    def shorthand() = {
        val a = List(1, 2, 3)

        println(a.map { _ * 2 })
        println(a.filter { _ % 2 != 0 })
    }

    def reduce() = {
        val a = List(1, 3, 5, 7)
        println(a.reduceLeft(_ + _))
        println(a.reduceLeft(_ * _))

        // reduce starting with specific value
        println(a.foldLeft(0)(_ + _))
        println(a.foldLeft(10)(_ + _))
        println(a.foldLeft(1)(_ * _))
        println(a.foldLeft(0)(_ * _))
    }

    def range() = { 
        val a = (1 to 5).toList
        println(a)
    }

    def prepend_and_concat() = {
        // prepend
        val a = List(1, 3, 5, 7)
        println(0 :: a)

        // concat
        val head = List(1, 3)
        val tail = List(5, 7)
        println(head ::: tail)
        println(head ::: Nil)
    }

    def reuse_tails() = {
        val d = Nil
        val c = 3 :: d
        val b = 2 :: c 
        val a = 1 :: b

        println(a)
        println(a.tail)
        println(b.tail)
        println(c.tail)
    }
}

