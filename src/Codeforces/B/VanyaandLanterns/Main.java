package Codeforces.B.VanyaandLanterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        double max = 0;
        int[] arr = new int[n];

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        Arrays.sort(arr);
        
        max = Integer.max(arr[0] - 0, l - arr[arr.length - 1]);

        double maxD = 0;
        for (int i = 1; i < arr.length; i++) {
            maxD = Double.max(arr[i] - arr[i - 1], maxD);
        }
        max = Double.max(maxD / 2, max);
        System.out.println(max);
    }
}
