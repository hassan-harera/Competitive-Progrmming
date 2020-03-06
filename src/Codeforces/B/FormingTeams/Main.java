package Codeforces.B.FormingTeams;

import Codeforces.B.ColorfulField.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static List<Integer>[] graph;
    static int[] roots;
    static List<Integer> anss;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        anss = new ArrayList<>();

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        roots = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            roots[i] = i;
        }
        while (m > 0) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[a].add(b);
            m--;
        }
        for (int i = 1; i < n + 1; i++) {
            int ans = 0;
            for (int j = 1; j < n + 1; j++) {
                if (!graph[i].contains(j)) {
                    ans++;
                }
            }
            anss.add(ans);
        }
        int c = n / 2;
        int res = 0;
        for (int i = c; i >= 1; i++) {
            if (Collections.frequency(anss, c) == 2) {
                System.out.print(n - (i * 2));
                break;
            }
        }
    }

    static int find(int n) {
        if (n == roots[n]) {
            return n;
        }
        return find(roots[n]);
    }

}
