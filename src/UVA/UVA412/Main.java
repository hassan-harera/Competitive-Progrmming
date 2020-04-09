package UVA.UVA412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(in.readLine());
            }

            Arrays.sort(arr);
            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int ch = gcd(arr[i], arr[j]);
                    if (ch == 1) {
                        total++;
                    }
                }
            }
            if (total == 0) {
                System.out.println("No estimate for this data set.");
                return;
            }
            System.out.println(Math.sqrt(6 * ((n * (n - 1)) / 2) / total));
        }
    }

    public static int gcd(int x, int y) {
        int t;
        while (x % y >= 1) {
            t = x;
            x = y;
            y = t % y;
        }
        return y;
    }
}
