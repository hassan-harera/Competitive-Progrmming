package Codeforces.C.Starsky;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();
        int c = in.nextInt();

        int[][][] mat = new int[105][105][c + 1];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int s = in.nextInt();
            mat[x][y][s]++;
        }

        for (int x = 1; x < 105; x++) {
            for (int y = 1; y < 105; y++) {
                for (int b = 0; b < c + 1; b++) {
                    mat[x][y][b] += mat[x - 1][y][b] + mat[x][y - 1][b] - mat[x - 1][y - 1][b];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int ans = 0;
            int t = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for (int b = 0; b < c + 1; b++) {
                int mult = (t + b) % (c + 1);

                ans += (mat[x2][y2][i] - mat[x1 - 1][y2][i] - mat[x2][y1 - 1][i] + mat[x1 - 1][y1 - 1][i]) * mult;
            }

            System.out.println(ans);
        }
    }
}
