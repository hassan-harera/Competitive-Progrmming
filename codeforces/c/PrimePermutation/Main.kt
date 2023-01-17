package Codeforces.C.PrimePermutation

import java.util.*


var doublyPrimes = BooleanArray(1005)
var normalPrimes  = BooleanArray(1005)

fun main() {
    val s = readLine()!!

    Arrays.fill(normalPrimes, true)
    getPrimes()

    Arrays.fill(doublyPrimes, false)

    val map = IntArray(26)
    for (i in s.indices) {
        map[s[i].toInt() - 'a'.toInt()]++
    }

    for (i in 2..s.length) {
        if (normalPrimes[i]) {
            var j = i + i
            while (j <= s.length) {
                doublyPrimes[j] = true
                doublyPrimes[i] = true
                j += i
            }
        }
    }

    var total = 0
    for (i in 1..s.length) {
        if (doublyPrimes[i])
            total++
    }

    var mx = 0
    var charInd = 0
    for (j in map.indices) {
        if (map[j] > mx) {
            mx = map[j]
            charInd = j
        }
    }

    if (mx < total) {
        println("NO")
        return
    }


    var ans = ""
    for (i in 1..s.length) {
        if (doublyPrimes[i]) {
            ans += Char('a'.toInt() + charInd)
            map[charInd]--
            total--
        } else {
            if (map[charInd] > total) {
                ans += Char('a'.toInt() + charInd)
                map[charInd]--
            } else {
                for (j in map.indices) {
                    if (j != charInd && map[j] > 0) {
                        ans += Char(j + 'a'.toInt())
                        map[j]--
                        break
                    }
                }
            }
        }
    }
    println("YES")
    println(ans)
}


private fun getPrimes() {
    var i = 2
    while (i * i < 1005) {
        if (normalPrimes[i]) {
            var j = i * 2
            while (j < 1005) {
                normalPrimes[j] = false
                j += i
            }
        }
        i++
    }
}
