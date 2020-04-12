package Codeforces.B.StudentsandShoelaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n, m;

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[a - 1].add(b - 1);
            graph[b - 1].add(a - 1);
        }
        int count = 0, ans = 0;
        List<Integer> toRemove = new ArrayList<>();
        Boolean[] arr = new Boolean[n];
        Arrays.fill(arr, false);

        while (count <= n - 2) {
            Boolean b = false;
            for (int i = 0; i < n; i++) {
                if (count >= n - 1) {
                    break;
                }

                if (!arr[i] && graph[i].size() == 1) {
                    arr[i] = true;
                    count++;
                    b = true;
                    toRemove.add(i);
                } else if (!arr[i] && graph[i].isEmpty()) {
                    arr[i] = true;
                    count++;
                }

            }
            for (Integer integer : toRemove) {
                if (!graph[integer].isEmpty()) {
                    graph[graph[integer].get(0)].remove(integer);
                }
                graph[integer].clear();
            }
            toRemove.clear();

            if (b) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
