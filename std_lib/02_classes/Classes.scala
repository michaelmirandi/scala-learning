// Classes are static templates that can be instantiated into many objects at runtime

class Point(x: Int, y: Int) {
  override def toString(): String = "(" + x + ", " + y + ")"
}

object Classes {
    def main(args: Array[String]) = {
        val pt = new Point(1, 2)
        println(pt)
    }
}