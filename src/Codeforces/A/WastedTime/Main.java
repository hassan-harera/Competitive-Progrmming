package Codeforces.A.WastedTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        final int speed = 50;
        double ans = 0;

        int[][] XY = new int[N][2];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(in.readLine());
            XY[i][0] = Integer.parseInt(stk.nextToken());
            XY[i][1] = Integer.parseInt(stk.nextToken());
            if (i >= 1) {
                double defX = Math.abs(XY[i][0] - XY[i - 1][0]);
                double defY = Math.abs(XY[i][1] - XY[i - 1][1]);
                ans += Math.sqrt(Math.pow(defX, 2) + Math.pow(defY, 2));
            }
        }
        System.out.println((ans / speed) * K);
    }

}
