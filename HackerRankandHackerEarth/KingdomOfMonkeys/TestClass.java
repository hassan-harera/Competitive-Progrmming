package KingdomOfMonkeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestClass {

    static List<pair>[] EOM;
    static int[] RootOM;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            int NOM = Integer.parseInt(stk.nextToken());
            RootOM = new int[NOM + 1];
            for (int i = 0; i < RootOM.length; i++) {
                RootOM[i] = i;
            }
            EOM = new ArrayList[NOM + 1];
            for (int i = 0; i < EOM.length; i++) {
                EOM[i] = new ArrayList<>();
            }
            int NOE = Integer.parseInt(stk.nextToken());
            for (int i = 0; i < NOE; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int ROA = find(a);
                int ROB = find(b);
                if (ROA != ROB) {
                    EOM[a].add(new pair(b));
                    EOM[b].add(new pair(a));
                    RootOM[ROA] = ROB;
                }
            }
            stk = new StringTokenizer(bf.readLine());
            long[] g = new long[NOM + 1];
            for (int i = 1; i <= NOM; i++) {
                int root = find(i);
                g[root] += Integer.parseInt(stk.nextToken());
            }
            long max = g[0];
            for (int i = 0; i < g.length; i++) {
                if (g[i] > max) {
                    max = g[i];
                }
            }
            sb.append(max);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int find(int a) {
        if (a == RootOM[a]) {
            return a;
        }
        return RootOM[a] = find(RootOM[a]);

    }
}

class pair {

    int ind, gained = 0;

    pair(int ind) {
        this.ind = ind;
    }

}
