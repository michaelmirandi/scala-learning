// no params
class WithoutClassParameters {
  def addColors(red: Int, green: Int, blue: Int) = {
    (red, green, blue)
  }

  def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
    (red, green, blue)
  }
}

// named params
class WithClassParameters(
    val defaultRed: Int,
    val defaultGreen: Int,
    val defaultBlue: Int
) {
  def addColors(red: Int, green: Int, blue: Int) = {
    (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }

  def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
    (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }
}

// default params
class WithClassParametersInClassDefinition(
    val defaultRed: Int = 0,
    val defaultGreen: Int = 255,
    val defaultBlue: Int = 100
) {
  def addColors(red: Int, green: Int, blue: Int) = {
    (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }

  def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
    (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }
}

object NamedAndDefaultArgs {
  def printName(first: String, last: String) = {
    println(first + " " + last)
  }

  def printNameDefault(
      first: String = "Michael",
      last: String = "Mirandi"
  ) = {
    println(first + " " + last)
  }

  def main(args: Array[String]) = {
    println("Hello Named & Default Args")
    // you can use the name of the variables explicitly in a call
    printName("Michael", "Mirandi")
    printName(first = "Michael", last = "Mirandi")
    printName(last = "Mirandi", first = "Michael")

    // the order doesn't matter if it's named
    // works will with default params too
    printNameDefault(last = "Smith")

    // you can specify args in any order if you use names

    val me = new WithoutClassParameters()

    val myColor = me.addColors(green = 0, red = 255, blue = 0)
    println(myColor)

    // default args by leaving them off
    val newMe = new WithoutClassParameters()
    val myNewColor = me.addColorsWithDefaults(green = 255)
    println(myNewColor)

    // access class params & specify args in any order using names
    val withParams = new WithClassParameters(40, 50, 60)
    val withParamsColor = withParams.addColors(green = 50, red = 60, blue = 40)
    println(withParamsColor)

    // access class params & default args if you leave them off
    val newWithParams = new WithClassParameters(10, 20, 30)
    val newWithParamColor = newWithParams.addColorsWithDefaults(green = 70)
    println(newWithParamColor)

    // default class params & default args too
    val another = new WithClassParametersInClassDefinition()
    val anotherColor = another.addColorsWithDefaults(green = 70)
    println(anotherColor)

    // default parameters can be functions too...
    def reduce(a: Int, f: (Int, Int) => Int = _ + _): Int = f(a, a)
    println(reduce(5))
    println(reduce(5, _ * _))
  }
}
