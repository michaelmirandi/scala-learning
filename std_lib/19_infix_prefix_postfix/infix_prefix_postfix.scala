object PrefixPostfix {
    def main(args: Array[String]) = {
        // below is prefix
        println("Hello Infix Prefix Postfix")
        // any method which takes a single parameter can be used as an i nfix operator
        // a.m(b) -> a m b
        val g: Int = 3
        println(g + 4)
        println(g.+(4))
        // infix operators do not work if an object has a method that takes 2 parameters...
        val anotherG: String = "Check out the big brains on Brad!"
        println(anotherG indexOf "o")

        // anotherG indexOf "0", 4 does not work... 
        // second parameter is fromIndex...
        println(anotherG.indexOf("o", 7))

        // below is postfix
        // a.m => a m
        // a.+(b) => a + b and a.! is the same as a!
        // postfix has lower precedence then infix
        // foo bar baz -> foo.bar(baz)
        // foo bar baz bam -> (foo.bar(baz)).bam
        // foo bar baz bam bim -> (foo.bar(baz).bam(bim))
        val gThree: Int = 31 
        println(gThree.toHexString)

        // prefix operators work when an object has a metho name that starts with unary_
        println(-gThree)

        // creating a prefix operator for your own class
        class Stereo {
            def unary_+ = "on"
            def unary_- = "off"
        }

        val stereo = new Stereo
        println(+stereo)
        println(-stereo)
    }
}