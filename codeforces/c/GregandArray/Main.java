package Codeforces.C.GregandArray;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

        long[] arr = new long[n + 1];
        int[][] operation = new int[m + 1][3];
        int[] operationFreq = new int[m + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 1; i < operation.length; i++) {
            operation[i][0] = in.nextInt();
            operation[i][1] = in.nextInt();
            operation[i][2] = in.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            operationFreq[l]++;
            if (r < operation.length - 1) {
                operationFreq[r + 1]--;
            }
        }

        for (int i = 1; i < operationFreq.length; i++) {
            operationFreq[i] = operationFreq[i - 1] + operationFreq[i];
        }

        long[] sum = new long[arr.length];
        for (int i = 1; i < operationFreq.length; i++) {
            int times = operationFreq[i];
            sum[operation[i][0]] += (times * operation[i][2]);
            if (operation[i][1] < sum.length - 1) {
                sum[operation[i][1] + 1] -= (times * operation[i][2]);
            }
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i] + sum[i - 1];
        }
        
        for (int i = 1; i < sum.length; i++) {
            arr[i] = sum[i] + arr[i];
            System.out.print(arr[i] + " ");
        }
    }
}