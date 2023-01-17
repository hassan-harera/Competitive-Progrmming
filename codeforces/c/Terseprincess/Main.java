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

        if (a + 1 >= n && n > 1) {
            System.out.println("-1");
            return;
        }

        int[] arr = new int[n];
        int ind, sum, mx;
        arr[0] = 2;
        ind = 1;
        sum = arr[0];
        mx = arr[0];

        while (b > 0 && ind < n) {
            arr[ind] = sum + 1;
            mx = Integer.max(mx, arr[ind]);
            sum += sum + 1;
            ind++;
            b--;
        }

        while (ind < n - a) {
            arr[ind] = 1;
            ind++;
        }

        while (a > 0 && ind < n) {
            arr[ind] = mx + 1;
            mx = Integer.max(mx, arr[ind]);
            ind++;
            a--;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
