/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.VanyaandLanterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        double ans = 0.00000;
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            ans = Double.max((arr[i]-arr[i-1])/2.000000000, ans);
        }
        
                    ans = Double.max(arr[0] - 0, ans);
                    ans = Double.max(l - arr[n-1], ans);
                    
                    System.out.println(ans);
        
    }

}
