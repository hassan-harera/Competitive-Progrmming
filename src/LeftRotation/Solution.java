package LeftRotation;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        for (int i = d; i < n; i++) {
            a[i - d] = a[i];
        }

        int j = 0;
        for (int i = n - d; i < n; i++) {
            a[i] = temp[j];
            ++j;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
