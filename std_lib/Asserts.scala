
/* 
    Three general types of assertions:
        assert (general)
        assertResult (expected vs actual)
        intercept (ensure an exception is thrown)
*/

object StdAsserts {
    def main(args: Array[String]) = {
        val left = 2
        val right = 2
        assert(left == right)
        print("Hello Assertions")
        val result = "3"
    }
    
}



