package Codeforces.B.VasyaandWrestling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();

        int l = 0;
        long s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {

            int cur = Integer.parseInt(in.readLine());

            if (i == n - 1) {
                l = cur;
            }

            if (cur < 0) {
                s2 += -cur;
                l2.add(-cur);
            } else {
                s1 += cur;
                l1.add(cur);
            }
        }

        if (s1 > s2) {
            System.out.println("first");
        } else if (s2 > s1) {
            System.out.println("second");
        } else {

            for (int i = 0; i < l1.size() && i < l2.size(); i++) {
                int c1 = l1.get(i);
                int c2 = l2.get(i);
                if (c1 > c2) {
                    System.out.println("first");
                    return;
                } else if (c1 < c2) {
                    System.out.println("second");
                    return;
                }
            }
            if (l > 0) {
                System.out.println("first");
            } else {
                System.out.println("second");
            }

        }
    }
}
