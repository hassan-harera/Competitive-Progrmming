import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.jvm.JvmStatic
import kotlin.math.max


val sumCom = IntArray(201)
val negCom = IntArray(201)
val arr = IntArray(201)
val list = ArrayList<Area>()

fun main() {
    val `in` = Scanner(System.`in`)
    val n = `in`.nextInt()
    val k = `in`.nextInt()

    for (i in 1..n) {
        val cur = `in`.nextInt()
        arr[i] = cur
        sumCom[i] = cur
    }

    for (i in 1 until sumCom.size) {
        sumCom[i] += sumCom[i - 1]
    }

    for (i in 1 until sumCom.size) {
        for (j in 1..0 + 1) {
            list.add(
                Area(
                    l = j,
                    r = i,
                    sum = sumCom[i] - sumCom[j],
                )
            )
        }
    }

    list.sortByDescending {
        it.sum
    }

    var ans = 0
    list.forEach {
        val smallest = ArrayList<Int>()
        val biggest = ArrayList<Int>()

        for (i in it.l..it.r)
            smallest.add(arr[i])

        for (j in 0 until it.l)
            biggest.add(arr[j])

        for (j in it.r + 1..n)
            biggest.add(arr[j])

        smallest.sort()
        biggest.sortDescending()

        var sum = it.sum
        for (i in 0 until k) {
            if (i >= smallest.size || i >= biggest.size)
                break
            ans = max(
                sum,
                sum - smallest[i] + biggest[i]
            )
        }
        ans = max(ans, sum)
    }

    println(ans)
}

data class Area(
    val l: Int,
    val r: Int,
    val sum: Int,
//    val neg: Int
)
