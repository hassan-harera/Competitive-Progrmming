package Codeforces.C.Thor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int[] a = new int[300005];
    static int[] b = new int[300005];
    static int[] c = new int[300005];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        int ans = 0;
        int popped = 0;
        int cnt1 = 1, cnt2 = 1;

        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(in.readLine());

            int t = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            if (t == 1) {
                a[cnt1++] = x;
                b[x]++;
                c[x]++;
                ans++;
            } else if (t == 2) {
                ans -= b[x];
                b[x] = 0;
            } else {
                while (cnt2 <= x) {
                    int id = a[cnt2++];
                    c[id]--;
                    if (b[id] > c[id]) {
                        ans--;
                        b[id]--;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
