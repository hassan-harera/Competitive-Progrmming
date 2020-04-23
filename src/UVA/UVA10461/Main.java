package UVA.UVA10461;

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

    static List<Integer>[] graph;
    static int[] time;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int u = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        graph = new List[u + 1];
        time = new int[u + 1];
        for (int i = 0; i <= u; i++) {
            graph[i] = new ArrayList();
        }

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < u; i++) {
            time[i] = Integer.parseInt(stk.nextToken());
        }
        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[a].add(b);
        }

        int q = Integer.parseInt(in.readLine());
        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(stk.nextToken());
            System.out.println(query(a));
        }

    }

    static int query(int a) {
        Queue<Integer> q = new LinkedList();
        q.add(a);
        int[] total = (int[]) Arrays.copyOf(time, time.length);
        int max = -1;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!graph[curr].isEmpty()) {
                for (Integer o : graph[curr]) {
                    total[o] += total[curr];
                    q.add(o);
                }
            } else {
                max = Integer.max(max, total[curr]);
                min = Integer.min(min, total[curr]);
            }
        }
        return max-min;
    }
}
