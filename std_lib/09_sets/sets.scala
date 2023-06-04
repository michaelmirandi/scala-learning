object Sets {

    def creation() = {
        // Sets are iterables that contain no duplicates
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        println(mySet.size)
    }

    def distinctSets() = {
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
        println(mySet.size)
    }
    
    def addingToSets() = {
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val aNewSet = mySet + "Illinois"

        println(aNewSet.contains("Illinois"))
        println(mySet.contains("Illinois"))
    }

    def mixedTypes() = {
        val mySet = Set("Michigan", "Ohio", 12)
        println(mySet.contains(12))
        println(mySet.contains("Michigan"))
    }

    def memberExistence() = {
        val mySet = Set("Michigan", "Ohio", 12)

        println(mySet(12))
        println(mySet("MI"))
    }

    def removingElements() = {
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val aNewSet = mySet - "Michigan"

        println(aNewSet.contains("Michigan"))
        println(mySet.contains("Michigan"))
    }

    def removingMultiples() = {
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val aNewSet = mySet -- List("Michigan", "Ohio")

        println(aNewSet.contains("Michigan"))
        println(aNewSet.contains("Wisconsin"))
        println(aNewSet.size)
    }

    def gracefulRemoveOfNonexistingElement() = {
        val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val aNewSet = mySet - "Minnesota"

        println(aNewSet.equals(mySet))
    }

    def intersection() = {
        val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val mySet2 = Set("Michigan", "Wisconsin", "Minnesota")

        val aNewSet = mySet1 intersect mySet2 

        println(aNewSet.equals(Set("Michigan", "Wisconsin")))
    }

    def joining() = {
        val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val mySet2 = Set("Michigan", "Wisconsin", "Minnesota")
        val aNewSet = mySet1 union mySet2

        println(aNewSet.equals(Set("Michigan", "Wisconsin", "Ohio", "Iowa", "Minnesota")))
    }

    def isSubset() = {
        val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
        val mySet3 = Set("Wisconsin", "Michigan")

        println(mySet2 subsetOf mySet1)
        println(mySet3 subsetOf mySet1)
    }

    def difference() = {
        val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val mySet2 = Set("Wisconsin", "Michigan")    
        val aNewSet = mySet1 diff mySet2 

        println(aNewSet.equals(Set("Ohio", "Iowa")))
    }

    def equivalency() = {
        val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
        val mySet2 = Set("Wisconsin", "Michigan", "Ohio", "Iowa")

        println(mySet1.equals(mySet2))
    }
    
    def main(args: Array[String]) = {
        creation()
        distinctSets()
        addingToSets()
        memberExistence()
        removingElements()
        removingMultiples()
        gracefulRemoveOfNonexistingElement()
        intersection()
        joining()
        isSubset()
        difference()
        equivalency()
    }
}