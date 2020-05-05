package Codeforces.B.PashaandString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        char[] s = new char[str.length() + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = str.charAt(i - 1);
        }

        int m = in.nextInt();
        int arr[] = new int[str.length() + 2];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            arr[a]++;
            arr[str.length() - a + 2]--;

        }

        for (int i = 1; i < arr.length / 2; i++) {
            arr[i] += arr[i - 1];

            if (arr[i] % 2 == 1) {
                char c = s[i];
                s[i] = s[str.length() - i + 1];
                s[str.length() - i + 1] = c;
            }
        }

        for (int i = 1; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }
}
