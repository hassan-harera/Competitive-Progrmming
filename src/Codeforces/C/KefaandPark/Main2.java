package Codeforces.C.KefaandPark;

import java.util.*;

import java.io.*;

public class Main2 {

    public static void main(String[] args) {

        FastReader in = new FastReader();

        int n = in.nextInt();

        int m = in.nextInt();

        int[] x = new int[n];

        for (int i = 0; i < x.length; i++) {

            x[i] = in.nextInt();

        }

        List<Integer>[] g = new List[n];

        for (int i = 0; i < g.length; i++) {

            g[i] = new ArrayList();

        }

        boolean[] vis = new boolean[n];

        int e = n - 1;

        while (e-- > 0) {

            int a = in.nextInt() - 1;

            int b = in.nextInt() - 1;

            g[a].add(b);

            g[b].add(a);

        }

        Stack<Integer> s = new Stack();

        s.push(0);

        vis[0] = true;

        int count = 0;

        while (!s.isEmpty()) {

            int p = s.pop();

            boolean t = true;

            for (int y = 0; y < g[p].size(); y++) {

                int c = g[p].get(y);

                if (!vis[c]) {

                    t = false;

                    if (x[c] > 0) {

                        if (!(x[p] + 1 > m)) {

                            s.push(c);
                            x[c] = x[p] + 1;

                        }

                    } else {
                        s.push(c);
                    }

                    vis[c] = true;

                }

            }

            if (t) {

                count++;

            }

        }

        System.out.println(count);

    }

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
