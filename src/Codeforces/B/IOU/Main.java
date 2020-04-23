package Codeforces.B.IOU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(in.readLine());
 
        Map<Integer, Integer> a = new HashMap();
        Map<Integer, Integer> p = new HashMap();
        Map<Integer, Integer> c = new HashMap();
 
        StringTokenizer stk = new StringTokenizer(in.readLine());
 
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(stk.nextToken());
 
            if (!p.containsKey(curr)) {
                p.put(curr, i);
                c.put(curr, i);
            } else if (a.get(curr) == 1) {
                c.put(curr, i);
            } else {
                if (i - c.get(curr) != c.get(curr) - p.get(curr)) {
                    System.out.println("0");
                    return;
                } else {
                    p.remove(curr);
                    p.put(curr, c.get(curr));
                    c.put(curr, i);
                }
            }
 
            if (!a.containsKey(curr)) {
                a.put(curr, 1);
            } else {
                int freq = a.get(curr);
                a.remove(curr);
                a.put(curr, freq + 1);
            }
 
        }
 
        List<Pair> l = new ArrayList();
 
        for (Integer integer : a.keySet()) {
            l.add(new Pair(integer, c.get(integer) - p.get(integer)));
        }
 
        Collections.sort(l);
 
        System.out.println(a.keySet().size());
        for (Pair pair : l) {
            System.out.println(pair.val + " " + (a.get(pair.val) == 1 ? 0 : pair.exp));
        }
 
    }
}
 
class Pair implements Comparable<Pair> {
 
    int val, exp;
 
    public Pair(int val, int exp) {
        this.val = val;
        this.exp = exp;
    }
 
    @Override
    public int compareTo(Pair o) {
        return val - o.val;
    }
 
}