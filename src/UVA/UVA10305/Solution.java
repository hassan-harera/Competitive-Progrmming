package UVA.UVA10305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static List<Integer>[] graph;
    static int N;
    static Boolean[] vis;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        stk = new StringTokenizer(in.readLine());
        int n = N = 1 + Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        vis = new Boolean[N];
        Arrays.fill(vis, false);

        graph = new List[n];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        while (m-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[a].add(b);
        }
        
        
        for (int i = 1; i<N ; i++) {
            if(!vis[i]){
                solve(i);
            }
        }
    }

    static void solve(int a){
        if (vis[a]) {
            return;
        }
        vis[a] = true;
        for (int b : graph[a]) {
            solve(b);
        }
        System.out.println(a);
    }

}
