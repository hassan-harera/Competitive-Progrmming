/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.FilyaandHomework;

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

        int n = Integer.parseInt(in.readLine());

        int arr[] = new int[n];
        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        if (n == 1) {
            System.out.println("YES");
            return;
        } else if (n == 2) {
            if (arr[1] - arr[0] == 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        if (n % 2 == 1) {
            int mid = n / 2;
            int dif = Math.abs(arr[mid] - arr[0]);

            for (int i = 1; i < n; i++) {
                if (i != mid) {
                    if (Math.abs(arr[i] - arr[mid]) != dif && Math.abs(arr[i] - arr[mid]) != 0) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
            System.out.println("YES");

        } else {
            int mid1 = n / 2 - 1;
            int dif1 = Math.abs(arr[mid1] - arr[0]);
            int mid2 = n / 2;
            int dif2 = Math.abs(arr[mid2] - arr[0]);

            boolean can = true;
            for (int i = 1; i < n; i++) {
                if (i != mid1) {
                    if (Math.abs(arr[i] - arr[mid1]) != dif1 && Math.abs(arr[i] - arr[mid1])  != 0) {
                        can = false;
                        break;
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                if (i != mid2) {
                    if (Math.abs(arr[i] - arr[mid2]) != dif2 && Math.abs(arr[i] - arr[mid2]) != 0) {
                        can = can || false;
                        break;
                    }
                }
            }

            if (can) {
                System.out.println("YES");

            } else {
                System.out.println("NO");
            }

        }

    }
}
