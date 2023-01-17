package com.harera.problemsolving.kattis.tiling

import kotlin.math.max

class Solution_2N_version {

    fun solve(n: Int): Int {
        if (n == 0)
            return 0
        if (n == 1)
            return 1

        var answer = 0
        if (n >= 1)
            answer += 1 * solve(n - 1)
        if (n >= 2)
            answer += 2 * solve(n - 2)
        return answer
    }
}

class Solution_3N_version {

    fun solve(n: Int): Int {
        if (n == 0)
            return 0
        if (n == 2)
            return 3
        if (n == 4)
            return 2

        var answer = 0
        if (n >= 2) {
            answer += 3 * solve(n - 2)
        }
        if (n >= 4)
            answer += 2 * solve(n - 4)
        return answer
    }
}

fun main() {
    val solution = Solution_2N_version()
    println(solution.solve(4))
}