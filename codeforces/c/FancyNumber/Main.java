package Codeforces.C.FancyNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int num = in.nextInt();
        String nS = num + "";

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (char c : nS.toCharArray()) {
            int cur = Integer.parseInt(c + "");

            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (Integer integer : map.keySet()) {
            int remin = k - map.get(integer);
            int sum = 0;
            if (remin <= 0) {
                res = Integer.min(res, sum);
                continue;
            }
            for (Integer integer1 : map.keySet()) {
                if (Objects.equals(integer, integer1)) {
                    continue;
                }
                if (remin <= 0) {
                    break;
                }

                if (map.get(integer1) >= remin) {
                    sum += Math.abs(integer - integer1) * remin;
                    break;
                } else {
                    sum += Math.abs(integer - integer1) * map.get(integer1);
                    remin -= map.get(integer1);
                }
            }
            res = Integer.min(res, sum);
        }

        System.out.println(res);
    }
}
