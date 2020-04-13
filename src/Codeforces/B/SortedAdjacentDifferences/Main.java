package Codeforces.B.SortedAdjacentDifferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(in.readLine());
            int[] arr = new int[n];

            List<Pair> list = new ArrayList();

            StringTokenizer stk = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(arr);

            for (int i = 0, j = n - 1; i < j; i++, j--) {
                list.add(new Pair(i, j, Math.abs(arr[j] - arr[i])));
            }
            Collections.sort(list);
            int[] ans = new int[n];
            int i = 0;
            for (Pair pair : list) {
                ans[i] = arr[pair.idx2];
                ans[i + 1] = arr[pair.idx1];
                i += 2;
            }
            for (int j = 0; j < n; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.print("\n");
        }
    }
}

class Pair implements Comparable<Pair> {

    int idx1, idx2, dif;

    public Pair(int idx1, int idx2, int dif) {
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.dif = dif;
    }

    @Override
    public int compareTo(Pair o) {
        return dif - o.dif;
    }
}
