package C.TanyaandToys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        StringBuilder out;

        HashSet<Integer> l = new HashSet<>();
        int last = 0;

        int n = Integer.parseInt(stk.nextToken());
        int amo = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(bf.readLine());
        while (stk.hasMoreElements()) {
            String st = stk.nextToken();
            l.add(Integer.parseInt(st));
        }

        HashSet<Integer> co = new HashSet<>();
        int c1 = amo, c2 = amo;
        for (int i = 1; i <= c1 && c2 > 0; i++) {
            if (!l.contains(i)) {
                co.add(i);
                c2 -= i;
                last = i;

            }
        }
        int sum = 0;
        for (Integer integer : co) {

            sum += integer;
        }
        if (sum > amo) {
            int m = sum - amo;
            for (int i = m; m > 0 && i <= last; i++) {
                if (co.contains(i)) {
                    co.remove(i);
                    m -= i;
                }
            }
            out = new StringBuilder();
            out.append(co.size());
            System.out.println(out);
            for (Integer integer : co) {
                out = new StringBuilder();
                out.append(integer);
                System.out.print(out + " ");
            }
        } else {
            System.out.println(co.size());
            for (Integer integer : co) {
                System.out.print(integer + " ");
            }
        }
    }

}
