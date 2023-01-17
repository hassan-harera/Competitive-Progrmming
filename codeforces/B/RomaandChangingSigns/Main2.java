package Codeforces.B.RomaandChangingSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n];
        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i] < 0) {
                arr[i] *= -1;
                k--;
            } else {
                break;
            }

        }

        if (k > 0) {
            if (k % 2 == 1) {
                Arrays.sort(arr);
                arr[0] *= -1;
            }

        }

        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        
        System.out.println(sum);
    }
}