package Codeforces.A.FillingDiamonds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long arr[] = new long[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(in.readLine());
        Arrays.fill(arr, -1);
        arr[0] = 1;
        arr[1] = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            sb.append(factorial(n) + "\n");

        }
        System.out.print(sb);
    }

    public static long fac(int a) {
        long sum = 1;

        for (int i = a; i >= 2; i--) {
            if (i < arr.length) {
                return sum * arr[i];
            }
            sum *= i;
        }
        return sum;
    }

    static long factorial(int n) {
        if (n >= arr.length) {
            return fac(n);
        }

        long res_size = 1;
        if (arr[n] != -1) {
            return arr[n];
        }

        for (int x = 2; x <= n; x++) {
            res_size *= x;
        }
        return arr[n] = res_size;
    }

}
