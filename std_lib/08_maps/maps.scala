object Maps {
    def creation () = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        println(myMap.size)
    }

    def identicalPairs () = {
        val myMap = Map("MI" -> "Michigan", "MI" -> "Michigan")
        println(myMap.size)
    }

    def addingToMap() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio")
        val aNewMap = myMap + ("IL" -> "Illinois")
        println(aNewMap.contains("IL"))
    }

    def iteratingMaps() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
        val mapValues = myMap.values
        println(mapValues.size)
        println(mapValues.head)

        val lastElement = mapValues.last
        println(lastElement)
    }

    def accessingMaps() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        println(myMap("MI"))
        println(myMap("IA"))
    }

    def overwriteMapKey() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Meechigan")
        val mapValues = myMap.values
        println(mapValues.size)
        println(myMap("MI"))
    }

    def keysOfDifferentTypes() = {
        val myMap = Map("Ann Arbor" -> "MI", 49931 -> "MI")
        println(myMap("Ann Arbor"))
        println(myMap(49931))
    }

    def accessingNonExistingKeys() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        // intercept[NoSuchElementException] {
        // myMap("TX")
        // }
        println(myMap.getOrElse("TX", "missing data"))
        val anotherMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa") withDefaultValue "missing data"
        println(anotherMap("TX"))
    }

    def removeMapElements() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        val aNewMap = myMap - "MI"
        println(aNewMap.contains("MI"))
        println(myMap.contains("MI"))
    }

    def removeMapElementsBulk() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        val aNewMap = myMap -- List("OH", "MI")
        println(aNewMap.contains("MI"))
        println(myMap.contains("MI"))
        println(aNewMap.contains("WI"))
        println(aNewMap.size)
        println(myMap.size)
    }

    def removingNonExistingElements() = {
        val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        val aNewMap = myMap - "MN"
        println(aNewMap.equals(myMap))
    }

    def equalityIndependentOfOrder() = {
        val myMap1 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
        val myMap2 = Map("WI" -> "Wisconsin", "MI" -> "Michigan", "IA" -> "Iowa", "OH" -> "Ohio")
        println(myMap1.equals(myMap2))
    }

    def main (args: Array[String]) = {
        // map is an iterable of key / values
        // Predef is a different syntax you can use to declare maps
        // fundamental operations on maps are similar to those on sets
        // lookup operaions: apply, get, getOrElse, contains, and isDefinedAt
        // additions & updates: +, ++, update
        // removals: -, --
        // Subcollection: keys, keySet, keysIterator, values, valuesIterator
        // Transformation: filterKeys and mapValues -> .filter & .map in ts...
        creation()
        identicalPairs()
        addingToMap()
        iteratingMaps()
        accessingMaps()
        accessingNonExistingKeys()
        removeMapElements()
        removeMapElementsBulk()
    }


}