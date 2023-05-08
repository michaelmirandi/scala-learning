// Options prevent null pointer exceptions
// no notion of a null value in scala, only optional values.
// none objects instead of null... seems a lot like python


object Options {
  def main(args: Array[String]) = {
    val someValue: Option[String] = Some("I am wrapped in something")
    val emptyValue: Option[String] = None
    val val1 = maybeItWillReturnSomething(true)
    val val2 = maybeItWillReturnSomething(false)

    println(val1 getOrElse "No value")
    println(val2 getOrElse "No value")
    println(val2 getOrElse {"default function"})
    assert(!val1.isEmpty)
    assert(val2.isEmpty)
    patternMatching()
    collectionOperations()
    foldExample()
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }

  def patternMatching() = {
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
        case Some(v) => v
        case None => 0.0
    }
    println(value)
    val noValue: Option[Double] = None
    val value1 = noValue match {
        case Some(v) => v
        case None => 0.0
    }
    println(value1)
  }

  // think of things as collections... an options can be a collection of 1 or 0 things...
  def collectionOperations() = {
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)
    println(result1)
    println(result2)
  }

  def foldExample() = {
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.fold(1)(_ * 3)
    // fold provides a default number... for ints it's 1
    val result2 = noNumber.fold(1)(_ * 3)
    println(result1)
    println(result2)
  }

}
