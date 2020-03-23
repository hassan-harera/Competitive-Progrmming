package Codeforces.A.YoungPhysicist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int X = 0, Y = 0, Z = 0;

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
            X += arr[i][0];
            Y += arr[i][1];
            Z += arr[i][2];

        }
        if (X != 0 || Y != 0 || Z != 0) {
            System.out.print("NO");
        } else {
            System.out.print("YES");
        }

    }
}
