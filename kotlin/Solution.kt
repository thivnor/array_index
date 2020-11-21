import java.util.*
import kotlin.collections.HashMap

fun solve(given: IntArray): List<List<List<Int>>> {

    // Step 1: compute diffs
    val diffs = IntArray(given.size)
    for (i in given.indices) {
        diffs[i] = i - given[i]
    }

    // Step 2: create lookup
    val lookup: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in diffs.indices) {
        val key = diffs[i]
        if (!lookup.containsKey(key)) {
            lookup[key] = ArrayList()
        }
        lookup[key]!!.add(i)
    }

    // Step 3: Find pairs and permute indices
    val result: MutableList<List<List<Int>>> = ArrayList()
    for (key in lookup.keys) {
        if (key > 0 && lookup.containsKey(-key)) {
            val permutations: MutableList<List<Int>> = ArrayList()
            for (a in lookup[key]!!) {
                for (b in lookup[-key]!!) {
                    permutations.add(listOf(a, b))
                }
            }
            result.add(permutations)
        }
    }
    return result
}


fun main() {
    val given1 = intArrayOf(1, 5, 2, 4, 3)
    println("Given: ${given1.contentToString()}")
    println("Solution: ${solve(given1)}")
    val given2 = intArrayOf(11, 10, 3, 4, 3, 2, 1, 4, 5, 4, 5, 6, 3, 2, 1, 6, 5, 7, 7, 8, 9, 12, 11, 12, 12, 1, 1, 1)
    println("Given: ${given2.contentToString()}")
    println("Solution: ${solve(given2)}")
}
