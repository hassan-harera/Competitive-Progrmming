package Codeforces.B.Fence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n + 1];
        arr[0] = 0;
        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i-1];
        }
        
        int ans = Integer.MAX_VALUE;
        int j = -1;
        for (int i = k; i <= n; i++) {
            if(arr[i]-arr[i-k] < ans){
                ans = arr[i]-arr[i-k];
                j = i-k +1;
            }
        }
        System.out.println(j);
    }
}
