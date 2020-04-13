package Codeforces.A.Twins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            total += arr[i];
        }

        Arrays.sort(arr);

        int ans = 0;
        
        int sum1 = 0;
        int sum2 = total;
        for (int i = n-1; sum1 <= sum2 &&  i >= 0; i--) {
            sum1 += arr[i];
            sum2 -= arr[i];
            ans++;
        }
        
        System.out.println(ans);
    }
}
