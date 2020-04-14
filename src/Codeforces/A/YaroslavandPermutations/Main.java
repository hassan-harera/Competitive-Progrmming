package CodeforcesA.YaroslavandPermutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        if (n == 1) {
            System.out.println("YES");
            return;
        }

        int max = n % 2 == 0 ? n / 2 : n / 2 + 1;

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        Map<Integer, Integer> map = new HashMap();

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(stk.nextToken());
            if (map.containsKey(curr)) {
                map.replace(curr, map.get(curr) + 1);
                continue;
            }
            map.put(curr, 1);
        }

        for (Integer value : map.values()) {
            if (value > max) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}