package UVA.UVA571

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min


fun main() {

    val `in` = Scanner(System.`in`)

    while (true) {
        val stringCheck = `in`.next()
        if (stringCheck == "") {
            break
        }
        val Ca = stringCheck.toInt()
        val Cb = `in`.nextInt()
        val N = `in`.nextInt()

        solve(0, 0, Ca, Cb, N, ArrayList<String>())
    }
}

fun solve(curA: Int, curB: Int, ca: Int, cb: Int, n: Int, arrayList: ArrayList<String>) {
    if (curB == n) {
        arrayList.forEach {
            println(it)
        }
        return
    }


    if (curB == 0)
        solve(
            curA, cb, ca, cb, n, arrayList.apply {
                add("fill B")
            }
        )


    if (curB != 0) {
        solve(
            min(curB + curA, ca), 0, ca, cb, n, arrayList.apply {
                add("pour B A")
            }
        )
    }

    if (curA != 0 && curA != ca) {
        solve(
            0, curB, ca, cb, n, arrayList.apply {
                add("empty A")
            }
        )
    }

    if (curA != 0) {
        solve(
            0, min(curB + curA, cb), ca, cb, n, arrayList.apply {
                add("pour A B")
            }
        )
    }

    if (curB != 0 && curB != cb) {
        solve(
            curA, 0, ca, cb, n, arrayList.apply {
                add("empty B")
            }
        )
    }


    if (curA == 0) {
        solve(
            ca, curB, ca, cb, n, arrayList.apply {
                add("fill A")
            }
        )
    }

}
