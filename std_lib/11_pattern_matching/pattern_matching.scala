object PatternMatching {

    // mapping
    // match allows you to apply a function to an object
    def matchTest(x: Int): String = x match {
        case 1 => "one"
        case 2 => "two"
        case _ => "many"
    }

    def exampleOne() = {
        val stuff = "blue"

        val myStuff = stuff match {
            case "red" => println("RED"); 1
            case "blue" => println("BLUE"); 2
            case "green" => println("GREEN"); 3
            case _ => println(stuff); 0 
        }
    }

    def complexStuff() = {
        val stuff = "blue"

        val myStuff = stuff match {
            case "red" => (255, 0, 0)
            case "green" => (0, 255, 0)
            case "blue" => (0, 0, 255)
            case _ => println(stuff); 0
        }

        println(myStuff)
    }

    def goldilocks(expr: Any) = {
        expr match {
            case ("porridge", "Papa") => "Papa eating porridge"
            case ("porridge", "Mama") => "Mama eating porridge"
            case ("porridge", "Baby") => "Baby eating porridge"
            case _ => "what?"
        }
    }

    def wildcardMatching(expr: Any) = {
        expr match {
            case ("porridge", _) => "eating"
            case ("chair", "Mama") => "sitting"
            case ("bed", "Baby") => "sleeping"
            case _ => "what?"
        }
    }

    def substitution(expr: (String, String)) = {
        expr match {
          case ("porridge", bear) => bear + " said someone's been eating my porridge"  
          case ("chair", bear) => bear + " said someone's been sitting in my chair"  
          case ("bed", bear) => bear + " said someone's been sleeping in my bed"  
        }
    }

    // backquote can be used to refer to a stable variable in scope
    def stableVariables(expr: (String, String)) = {
        val foodItem = "porridge"
        expr match {
            case (`foodItem`, _) => "eating"
            case ("chair", "Mama") => "sitting"
            case ("bed", "Baby") => "sleeping"
            case _ => "what?"

        }
    }

    def methodParameter(i: Int, j: Int) = {
        j match {
            case `i` => true
            case _ => false
        }
    }

    // splitting a list into parts
    def listMatching() = {
        // since the case doesn't terminate in Nil, xs is interpreted as the rest of the list.
        val secondElement = List(1, 2, 3) match {
            case x :: xs => xs.head
            case _ => 0
        }

        println(secondElement)

        // x is the first element, y is the second element, and xs is the rest
        val anotherOne = List(1, 2, 3) match {
            case x :: y :: xs => y
            case _ => 0
        }

        println(s"Another one: $anotherOne")

        val twoOrMore = List(1) match {
            case x :: y :: xs => y
            case _ => 0
        }

        println(s"Two or more: $twoOrMore")

        val exactNumber = List(1, 2, 3) match {
            case x :: y :: Nil => y // only matches a list with exactly 2 items
            case _ => 0
        }

        println(s"Exact Number: $exactNumber")

        // extracting longer elements
        val longerEles = List(1, 2, 3) match {
            case x :: y :: z :: tail => tail 
            case _ => 0
        }

        val result = longerEles == Nil

        println(s"Longer elements: $result")

    }

    

    def main(args: Array[String]) = {
        println(matchTest(3))
        exampleOne()
        complexStuff()
        println(goldilocks(("porridge", "Mama")))
        println(wildcardMatching(("porridge", "Papa")))
        println(wildcardMatching(("chair", "Mama")))
        println(substitution(("porridge", "Papa")))
        println(substitution(("chair", "Mama")))
        println(stableVariables(("porridge", "Papa")))
        println(stableVariables(("chair", "Mama")))
        println(stableVariables(("porridge", "Cousin")))
        println(stableVariables(("beer", "Cousin")))
        println(methodParameter(3, 3))
        println(methodParameter(7, 9))
        println(methodParameter(9, 9))
        listMatching()
    }
}