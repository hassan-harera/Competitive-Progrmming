package Codeforces.C.Hackepackyourbags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        HashMap<Integer, Integer> dur_price = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int dur = b - a + 1;
            if (dur_price.containsKey(dur)) {
                dur_price.replace(dur, Integer.min(dur_price.get(dur), c));
            } else {
                dur_price.put(dur, c);
            }
        }

        long ans = Long.MAX_VALUE;

//        ArrayList<Integer> durs = new ArrayList();
//        durs.addAll(dur_price.keySet());
//        Collections.sort(durs);
        for (int it : dur_price.keySet()) {
            long sol = 0;

            if (dur_price.containsKey(x - it)) {
                sol += dur_price.get(it);
                sol += dur_price.get(x - it);
            } else {
                sol = Long.MAX_VALUE;
            }
            ans = Long.min(sol, ans);
        }
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}
