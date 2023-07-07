
// classes that integrate this trait will need to provide a concrete implementation for isSimilar...
trait Similarity {
  // abstract
  def isSimilar(x: Any): Boolean
  // concrete
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}

object Traits {
  // self-type lists the required dependencies for mixing traits
  // dependencies can't have identical methods / property names (illegal inheritance error)
  def selfTyping() = {
    trait B {
      def bId = 2
    }

    trait A {
      self: B => def aId = 1
    }

    val obj = new A with B 
    println(obj.aId + obj.bId)
  }

  // traits are polymorphic! any type can be referred to by another type if related by extension
  // allows for different types to be utilized in a uniform interface...
  // subtyping and parametric
  // subtyping is the example below... if B is A, then you can use B anywhere A is required...
  // you've used this in typescript before... 
  // parametric polymorphism allows for typing something that can use many variables (List[T])
  def multipleExtension() = {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class OurListener 

    class MyListener extends OurListener with EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Woodchuck Stampede") => "An unfortunate woodchuck stampede occurred"
          case _ => "Nothing of importance occurred"
        }
      }
    }

    val evt = Event("Woodchuck Stampede")
    val myListener = new MyListener
    println(myListener.listen(evt))
  }



  // traits are just like interfaces in java
  // used to define object types by specifying their signatures
  // no constructor parameters!
  def main(args: Array[String]) = {
    println("Hello Traits")
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event) = {
        event match {
          case Event("Moose Stampede") => "An unfortunate moose stampede occurred"
          case _ => "Nothing of importance occurred"
        }
      }
    }

    val evt = Event("Moose Stampede")
    val myListener = new MyListener
    println(myListener.listen(evt))

    multipleExtension()

    selfTyping()
  }
}