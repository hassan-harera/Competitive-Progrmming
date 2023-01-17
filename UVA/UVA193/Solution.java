package UVA.UVA193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static Graph g;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int K = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            N = K + 1;
            g = new Graph(K + 1);
            while (M-- > 0) {
                stk = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                g.addEdge(a, b);
            }
            char[] col = new char[K + 1];
            Arrays.fill(col, 'a');

            solve(1, col, 0, new ArrayList<>());
        }
    }

    static void solve(int n, char[] col, int b, List<Integer> list) {
        if (n == N) {
            System.out.println(b);
            for (int c : list) {
                System.out.print(c + " ");
            }
            return;
        }
        Boolean isBlack = false;
        for (int l : g.graph[n]) {
            if (col[l] == 'b') {
                isBlack = true;
                break;
            }
        }
        if (!isBlack) {
            col[n] = 'b';
            list.add(n);
            solve(n + 1, col, b + 1, list);
            return;
        }
        solve(n + 1, col, b, list);
    }

}

class Graph {

    List<Integer>[] graph;

    public Graph(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b) {
        graph[a].add(b);
        graph[b].add(a);
    }
}
