/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.BallsandBoxes;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        long arr[] = new long[n + 1];
        long min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            min = Long.min(arr[i], min);
        }

        for (int i = 1; i <= n; i++) {
            arr[i] -= min;
        }

        long cnt = (min * n);
        while (arr[x] != 0) {
            arr[x]--;
            cnt++;
            x = x == 1 ? n : x - 1;
        }
        arr[x] += cnt;
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
