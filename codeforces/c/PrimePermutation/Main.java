package Codeforces.C.PrimePermutation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int root[] = new int[1005];
    static int primes[] = new int[1005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        Arrays.fill(primes, 1);
        getPrimes();

        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);
        }

        for (int i = 1; i <= s.length(); i++) {
            if (primes[i] == 1) {
                for (int j = i * 2; j <= s.length(); j += i) {
                    join(j, i);
                }
            }
        }
        
        
    }

    static int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return find(root[x]);
    }

    static void join(int r, int c) {
        root[find(r)] = root[(r)];
    }

    private static void getPrimes() {
        for (int i = 2; i * i < 1005; i++) {
            if (primes[i] == 1) {
                for (int j = i * 2; j < 1005; j += i) {
                    primes[i] = 0;
                }
            }
        }
    }
}
