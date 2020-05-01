package Codeforces.B.BearandFriendshipCondition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            int size = graph[i].size();
            for (Integer it : graph[i]) {
                if(graph[it].size() != size){
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        
        System.out.println("YES");

    }
}
