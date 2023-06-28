object RangeObj {

    def helloRanges() = {
        val someNumbers = Range(0, 10)
        val second = someNumbers(1)
        val last = someNumbers.last

        println(someNumbers.size)
        println(second)
        println(last)
    }

    def usingUntil() = {
        val someNumbers = Range(0, 10)
        val otherRange = 0 until 10 

        println(someNumbers == otherRange)

    }

    def stepWithIncrement() = {
        val someNumbers = Range(2, 10, 3)
        val second = someNumbers(1)
        val last = someNumbers.last
        println(someNumbers.size)
        println(someNumbers)
        println(second)
        println(last)

        // range does not include its end bound, even with step increment

        val extraNumbers = Range(0, 34, 2)
        println(extraNumbers)

        // inclusive upper bound
        val inclusiveNumbers = Range(0, 34, 2).inclusive
        println(inclusiveNumbers)

        // writing inclusive ranges in shorthand
        val shortHandInclusive = 0 to 34
        println(shortHandInclusive)
    }

    // predefined to, until, and by... very intuitive
    // upper limit exclusive is until
    def main(args: Array[String]) = {
        helloRanges()
        usingUntil()
        stepWithIncrement()
    }
}