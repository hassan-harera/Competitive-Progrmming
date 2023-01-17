package Codeforces.A.IWannaBetheGuy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);

        StringTokenizer stk = new StringTokenizer(in.readLine());
        int p = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < p; i++) {
            int a = Integer.parseInt(stk.nextToken());
            arr[a] = a;
        }

        stk = new StringTokenizer(in.readLine());
        int q = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(stk.nextToken());
            arr[a] = a;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == -1) {
                System.out.println("Oh, my keyboard!");
                return;
            }
        }
        System.out.println("I become the guy.");
    }
}
