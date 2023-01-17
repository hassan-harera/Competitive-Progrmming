package Codeforces.C.`Xor-tree`

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min


const val `DON'T_CHANGE` = 1
const val CHANGE_NODE = 2
const val CHANGE_CHILDREN = 3
const val CHANGE_NODE_AND_CHILDREN = 4

val graph = Array<ArrayList<Int>>(100005) { ArrayList() }
val opers = IntArray(size = 100005, init = { 0 })
val init = BooleanArray(size = 100005)
val goal = BooleanArray(size = 100005)
fun main() {
    val `in` = Scanner(System.`in`)

//    graph.fill(ArrayList())

    val n = `in`.nextInt()
    for (i in 2..n) {
        val a = `in`.nextInt()
        val b = `in`.nextInt()
        graph[min(a, b)]!!.add(max(a, b))
    }

    for (i in 0 until n) {
        val a = `in`.nextInt()
        init[i] = a == 1
    }

    for (i in 0 until n) {
        val a = `in`.nextInt()
        goal[i] = a == 1
    }

    search()
}

fun search() {
    val q: Queue<Int> = LinkedList()
    q.add(1)

    var ans = 0
    val ansList = arrayListOf<Int>()
    while (q.isNotEmpty()) {
        val cur = q.poll()
        var operation = `DON'T_CHANGE`

        if (opers[cur] == CHANGE_NODE) {
            init[cur] = init[cur].not()
            operation = CHANGE_CHILDREN
        } else if (opers[cur] == CHANGE_CHILDREN) {
            operation = CHANGE_NODE
        } else if (opers[cur] == CHANGE_NODE_AND_CHILDREN) {
            init[cur] = init[cur].not()
            operation = CHANGE_NODE
        }

        if (init[cur] != goal[cur]) {
            init[cur] = init[cur].not()
            ans++
            ansList.add(cur)
            when (operation) {
                `DON'T_CHANGE` -> {
                    operation = CHANGE_CHILDREN
                }
                CHANGE_NODE-> {
                    operation = CHANGE_NODE_AND_CHILDREN
                }
            }
        }

        graph[cur].forEach {
            opers[it] = operation
            q.add(it)
        }
    }

    println(ans)
    ansList.forEach {
        println(it)
    }
}
