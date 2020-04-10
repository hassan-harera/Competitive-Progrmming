package Codeforces.B.SorttheArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int arr1[] = new int[n];
        int arr2[] = new int[n];

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = arr2[i] = Integer.parseInt(stk.nextToken());
        }

        int l = - 1, idxL = -1;
        int r = -1, idxR = -1;

        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                r = arr1[i];
                idxR = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr1[i] != arr2[i]) {
                l = arr1[i];
                idxL = i;
                break;
            }
        }

        if (l == -1 || r == -1) {
            System.out.println("yes");
            System.out.println(1 + " " + 1);
            return;
        }

        if (arr2[idxL] != arr1[idxR] || arr2[idxR] != arr1[idxL]) {
            System.out.println("no");
            return;
        }
        reverse(arr1, idxR, idxL);
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
        System.out.println((idxR + 1) + " " + (idxL + 1));

    }

    static void reverse(int a[], int l, int r) {
        int temp[] = new int[a.length];
        for (int i = l, j = r; i <= r; i++, j--) {
            temp[i] = a[j];
        }
        for (int i = l; i <= r; i++) {
            a[i] = temp[i];
        }
    }
}
