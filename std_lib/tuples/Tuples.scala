/*
Tuples can contain objects with different types, unlike arrays
*/

object Tuples {
  def main(args: Array[String]) = {
    val t = (1, "Hello", Console)
    val tuple = ("apple", "dog")
    val fruit = tuple._1
    val animal = tuple._2
    println(fruit)
    println(animal)

    // different types
    val tuple5 = ("a", 1, 2.2, None, "five")

    println(tuple5._2)
    println(tuple5._5)

    // unpacking
    val student = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student
    println(name)
    println(age)
    println(gpa)

    // swap can be used to move items in a tuple with only 2 elements
    val swapExample = ("apple", 3).swap
    println(swapExample._1)
    println(swapExample._2)


  }
}
