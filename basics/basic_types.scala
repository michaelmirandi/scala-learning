// convert to a Double

object BasicTypes {
    def main(args: Array[String]) = {
        5.toDouble

        // Double
        5.6

        // convert to an Int
        5.6.toInt


        // Boolean
        true
        false

        // Chars have numeric value
        'a'.toInt

        // convert Int to Char
        ('a' - 1).toChar

        "Hello World"

        // can add and multiply to strings
        "h1" + 5

        "h1" * 3

        // tuple, can be any type
        val temp = ("hi", 1, (1, 2, 3))
        "h1" -> 1
        // get values from tuple
        temp._3._3

        // integer overflow
        // 32bit Integers
        2000000000 + 2000000000

        53.toBinaryString
        -53.toBinaryString

        // ints are most efficient
        Long
        Int
        Byte
        Short
        Char
        println("Hello World")
    }
    
}
