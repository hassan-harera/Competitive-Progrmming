package Codeforces.C.Starsky;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    static int[][] mat = new int[100005][100005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();
        int c = in.nextInt();

        for (int j = 0; j < 100005; j++) {
            for (int k = 0; k < 100005; k++) {
                mat[j][k] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int s = in.nextInt();
            mat[x][y] = s;
        }

        for (int i = 0; i < q; i++) {
            int ans = 0;
            int t = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (mat[j][k] != -1) {
                        ans += Integer.min(c, mat[j][k] + t);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
