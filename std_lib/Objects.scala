// Single object (singleton)... not a static method in a class. Replaces static in Java

object Greeting {
    def main(args: Array[String]) = {
        println(english)
        println(espanol)
    }
    def english = "Hi"
    def espanol = "Hola"
}

// objects that have the same name as a class are called companion objects... Often used to contain factory methods for the class that it complements
class Movie(val name: String, val year: Short)

object Movie {
    def main(args: Array[String]) = {
        val movie: Option[Movie] = academyAwardBestMoviesForYear(1932)
        // for getting attrs
        println(movie.get.name)
    }

    def academyAwardBestMoviesForYear(x: Short) = {
        x match {
            case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
            case 1931 => Some(new Movie("Cimarron", 1931))
            case 1932 => Some(new Movie("Grand Hotel", 1932))
            // Default case
            case _ => None
        }
    }
}

// companion objects have access to private values and variables from instantiated objects from the corresponding class
class Person(val name: String, private val superheroName: String)

object Person {
    def main(args: Array[String]) = {
        val clark = new Person("Clark Kent", "Superman")
        val peter = new Person("Peter Parker", "Spider-man")
        println(Person.showMeInnerSecret(clark))
        println(Person.showMeInnerSecret(peter))

    }

    def showMeInnerSecret(x: Person) = x.superheroName;
}
