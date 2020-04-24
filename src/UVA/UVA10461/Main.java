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
            graph[b].add(a);
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
        Boolean max[] = new Boolean[time.length];
        Arrays.fill(max, false);
        max[a] = true;
        Boolean min[] = new Boolean[time.length];
        Arrays.fill(min, false);
//        
//        while (!q.isEmpty()) {
//            int curr = q.poll();
//            for (Integer o : graph[curr]) {
//                if (!max[o]) {
//                    max[o] = true;
//                    q.add(o);
//                }
//            }
//        }

        for (Integer o : graph[a]) {
            if (!min[o]) {
                min[o] = true;
                q.add(o);
            }
        }
        int ma = 0;
        int mi = 0;
        for (int i = 0; i < time.length; i++) {
            if (i != a) {
                ma += time[i];
            }
        }
        for (int i = 0; i < time.length; i++) {
            if (min[i]) {
                mi += time[i];
            }
        }
        return ma - mi;
    }
}
