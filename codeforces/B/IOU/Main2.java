/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.IOU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n+1];
        Arrays.fill(arr, 0);
        
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(stk.nextToken());     
            int b = Integer.parseInt(stk.nextToken());     
            int c = Integer.parseInt(stk.nextToken());
            
            arr[a] += c;
            arr[b] -= c;
        }
        
        long ans = 0;
        for (int i = 0; i < n+1; i++) {
            if(arr[i] > 0)
            ans += arr[i];            
        }
        System.out.println(ans);
    }
}