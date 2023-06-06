object Formatting {

    def string_in_format() = {
        val s = "Hello World"
        println("Application %s".format(s))
    }

    def literals_single() = {
        val a = 'a'
        val b = 'B'

        println("%c".format(a))
        println("%c".format(b))
    }

    def escape_sequence() = {
        val c = 'a'
        val e = '\"'
        val f = '\\'

        println("%c".format(c))
        println("%c".format(e))
        println("%c".format(f))
    }

    def with_numbers() = {
        val j = 190
        println("%d bottles of beer on the wall" format j - 100)
    }

    def with_numbers_and_strings() = {
        val j = 190
        val k = "vodka"

        println("%d bottles of %s on the wall".format(j - 100, k))
    }

    def main(args: Array[String]) = {
        string_in_format()
        literals_single()
        escape_sequence()
        with_numbers()
        with_numbers_and_strings()
    }
}