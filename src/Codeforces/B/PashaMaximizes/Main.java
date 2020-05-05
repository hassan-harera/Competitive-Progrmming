package Codeforces.B.PashaMaximizes;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String str = in.next();
        int k = in.nextInt();
        int arr[] = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];

            int idx = -1;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > cur && j - i <= k) {
                    cur = arr[j];
                    idx = j;
                }
            }

            if (idx != -1) {
                for (int j = idx; j > i; j--) {
                    k--;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
