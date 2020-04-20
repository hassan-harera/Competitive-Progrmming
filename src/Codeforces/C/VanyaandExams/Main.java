package Codeforces.C.VanyaandExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        /*
        The first line contains three integers n, r, avg (1 ≤ n ≤ 105, 1 ≤ r ≤ 109, 1 ≤ avg ≤ min(r, 106)) — the number of exams, the maximum grade and the required grade point average, respectively.

         */
        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int avg = Integer.parseInt(stk.nextToken());

        int total = 0;

        Pair subjs[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int gra = Integer.parseInt(stk.nextToken());
            total += gra;
            subjs[i] = new Pair(gra, Integer.parseInt(stk.nextToken()));
        }
        long dif = avg * n - total;
        long ans = 0;
        Arrays.sort(subjs);

        for (int i = 0; i < n; i++) {
            if (dif > 0) {
                long min = Integer.min(r - subjs[i].grade,(int) dif);
                dif -= min;
                ans += subjs[i].freq * min;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {

    int grade, freq;

    public Pair(int grade, int freq) {
        this.grade = grade;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair t) {
        if (freq != t.freq) {
            return freq - t.freq;
        }
        return grade - t.grade;
    }
}
