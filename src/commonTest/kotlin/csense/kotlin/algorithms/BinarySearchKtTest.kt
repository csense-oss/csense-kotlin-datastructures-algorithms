package csense.kotlin.algorithms

import csense.kotlin.tests.assertions.*
import kotlin.test.Test

class BinarySearchKtTest {

    /**
     * Highlights the reason why this is there.
     * The use case is more complex data than a simple array of eg ints, where a custom way to compare elements is desirably.
     * also the extension is on array types, which the STD algorithm is not.
     */
    @Test
    fun testBinarySearchComplexData() {
        //constructed in order  otherwise binary search does not work..
        val array = arrayOf(RandomComplexData("Test1", 0), RandomComplexData("Test2", 1), RandomComplexData("Test3", 2))
        //we want to find Test2, and
        val result = array.binarySearch { data, _ ->
            data.name.compareTo("Test2").itemComparison.toComparing()
        }
        result.assert(1)
    }

    data class RandomComplexData(val name: String, val order: Int)


    @Test
    fun testBinarySearch() {
        val strArray = arrayListOf("a", "b", "c", "d")
        val indexOfA = strArray.binarySearch { item: String, _: Int ->
            return@binarySearch item.compareTo("a").itemComparison.toComparing()
        }
        indexOfA.assert(0)

        val indexOfB = strArray.binarySearch { item: String, _: Int ->
            item.compareTo("b").itemComparison.toComparing()
        }
        indexOfB.assert(1)

        val indexOfq = strArray.binarySearch { item: String, _: Int ->
            item.compareTo("q").itemComparison.toComparing()
        }
        indexOfq.assertNull()


        val indexOfIndex = strArray.binarySearch { _: String, index: Int ->
            (index - 3).itemComparison.toComparing()
        }
        indexOfIndex.assert(3)


    }


}