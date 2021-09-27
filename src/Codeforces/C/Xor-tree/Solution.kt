//package Codeforces.C.`Xor-tree`
//
//import java.util.*
//import kotlin.collections.ArrayList
//import kotlin.collections.HashSet
//import kotlin.math.max
//import kotlin.math.min
//
//
//val graph = Array<ArrayList<Int>>(100005) { ArrayList() }
//val op = IntArray(size = 100005, init = { 0 })
//val init = BooleanArray(size = 100005)
//val goal = BooleanArray(size = 100005)
//
//fun main() {
//    val `in` = Scanner(System.`in`)
//
//    val n = `in`.nextInt()
//    for (i in 2..n) {
//        val a = `in`.nextInt()
//        val b = `in`.nextInt()
//        graph[min(a, b)]!!.add(max(a, b))
//    }
//
//    for (i in 0 until n) {
//        val a = `in`.nextInt()
//        init[i] = a == 1
//    }
//
//    for (i in 0 until n) {
//        val a = `in`.nextInt()
//        goal[i] = a == 1
//    }
//
//    search().forEach { node ->
//        change(1, node)
//    }
//}
//
//fun change(level: Int, node: Int) {
//    val queue: Queue<Int> = LinkedList()
//    queue.add(node)
//
//    while (queue.isNotEmpty()) {
//        val cur = queue.poll()
//
//        if (level % 2 == 1) {
//            graph[cur].forEach {
//                queue.add(it)
//                init[cur] = goal[cur]
//            }
//        }
//    }
//}
//
//fun search(): HashSet<Int> {
//    val queue: Queue<Int> = LinkedList<Int>()
//    queue.add(1)
//
//    val needToChange = HashSet<Int>()
//    while (queue.isNotEmpty()) {
//        val node = queue.poll()
//
//        if (init[node] != goal[node]) {
//            needToChange.add(node)
//        }
//
//        graph[node].forEach {
//            queue.add(it)
//        }
//    }
//
//    return needToChange
//}
//
//
