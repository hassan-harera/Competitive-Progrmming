package Codeforces.B.PreparingOlympiad;


import java.util.Stack;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int n, l, r, x;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        l = in.nextInt();
        r = in.nextInt();
        x = in.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long ans = solve(new Stack(), 0);
        System.out.println(ans);
    }

    public static long solve(Stack<Integer> list, int idx) {
        if (idx >= arr.length) {
//            Collections.sort(list);
            long sum = 0;
            int min = Integer.MAX_VALUE, max = -1;
            for (Integer i : list) {
                sum += i;
                min = Integer.min(min, i);
                max = Integer.max(max, i);
            }
            if (list.size() < 2 || sum < l || sum > r || (max-min) < x) {
                return 0;
            } else {
                return 1;
            }
        }

        long ans = 0;

        list.add(arr[idx]);
        ans += solve(list, idx + 1);
        list.pop();
        ans += solve(list, idx + 1);
        return ans;
    }
}
