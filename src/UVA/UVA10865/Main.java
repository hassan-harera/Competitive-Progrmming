package UVA.UVA10865;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int X[] = new int[20005];
        int Y[] = new int[20005];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            X[i] = x;
            Y[i] = y;
        }

        int col = N / 2;
        int row = N / 2;

        int ol = 0, st = 0;

        for (int i = 0; i < N; i++) {
            if ((X[i] - X[col] < 0 && Y[i] - Y[row] < 0) || (X[i] - X[col] > 0 && Y[i] - Y[row] > 0)) {
                st++;
            } else if ((X[i] - X[col] < 0 && Y[i] - Y[row] > 0) || (X[i] - X[col] > 0 && Y[i] - Y[row] < 0)) {
                ol++;
            }
        }

        System.out.println(st + " " + ol);
    }
}
