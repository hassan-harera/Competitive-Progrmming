package Codeforces.C.Terseprincess;

import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();

        if (a + b >= n) {
            System.out.println("-1");
            return;
        }
        if (b == 0 && n - a == 1) {
            System.out.println("-1");
            return;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        int ind = 1;
        int sum = 1;

        if (b == 0) {
            while (ind < (n - a)) {
                arr[ind] = 1;
                ind++;
            }

            while (ind < (n)) {
                arr[ind] = arr[ind - 1] + 1;
                ind++;
            }
        } else {
            while (ind < (n - a + 1)) {
                arr[ind] = sum + 1;
                sum += sum + 1;
                ind++;
            }
            for (int i = ind; ind < (b + 1); ind++) {
                arr[ind] = sum + 1;
                sum += sum + 1;
            }

            for (int i = (b + 1); i < (b + 1 + a); i++) {
                arr[i] = arr[i - 1] + 1;
            }

            for (int i = (b + 1 + a); i < (n); i++) {
                arr[i] = 1;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
