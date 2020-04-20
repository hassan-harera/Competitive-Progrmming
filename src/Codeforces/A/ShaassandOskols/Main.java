package A.ShaassandOskols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken()), idx[], m;

        idx = new int[n];
        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            idx[i] = Integer.parseInt(stk.nextToken());
        }

        m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if (idx.length == 1) {

            } else if (r > 1 && r < n) {
                idx[r - 2] += c - 1;
                idx[r] += idx[r - 1] - c;
            } else if (r <= 1) {
                idx[r] += idx[r - 1] - c;
            } else {
                idx[r - 2] += c - 1;
            }
            idx[r - 1] = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(idx[i]);
        }

    }

}
