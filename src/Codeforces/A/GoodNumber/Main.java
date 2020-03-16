package Codeforces.A.GoodNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int ans = 0;
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Boolean nums[] = new Boolean[k + 1];
        Arrays.fill(nums, false);

        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine();

            for (int j = 0; j < arr[i].length(); j++) {
                int curr = Integer.parseInt(arr[i].charAt(j) + "");
                if (curr <= k) {
                    nums[curr] = true;
                }
            }
            Boolean isGood = true;
            for (int j = 0; j < k + 1; j++) {
                if (!nums[j]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                ++ans;
            }
        }
        System.out.print(ans);
    }

}
