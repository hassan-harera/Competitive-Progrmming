package Codeforces.B.ColorfulField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        String[] words = {"Carrots", "Kiwis", "Grapes"};

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int nW = Integer.parseInt(stk.nextToken());
        int nQ = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> Wests = new HashMap<>();

        while (nW-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            Wests.put((a - 1) * m + b, nW);
        }

        Set<Integer> list = Wests.keySet();
        List<Integer> l = new ArrayList<>();
        for (Integer integer : list) {
            l.add(integer);
        }
        Collections.sort(l);
        Wests = new HashMap();
        for (int i = 0; i < l.size(); i++) {
            Wests.put(l.get(i), i + 1);
        }

        while (nQ-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(stk.nextToken()) - 1;
            int j = Integer.parseInt(stk.nextToken());

            if (Wests.containsKey((i * m) + j)) {
                System.out.println("Waste");
            } else {
                int curr = i * m + j;
                int k = 0;
                for (; curr < l.get(k) && k < l.size(); k++) {
                }
                System.out.println(words[(curr - k) % 3]);
            }
        }
    }

}

class Pair implements Comparable<Pair> {

    int i, j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair o) {
        if (i != o.i) {
            return i - o.i;
        }
        return j - o.j;
    }
}
