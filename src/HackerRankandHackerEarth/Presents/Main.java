package Presents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr1[i] = Integer.parseInt(stk.nextToken());
            arr2[arr1[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

}
