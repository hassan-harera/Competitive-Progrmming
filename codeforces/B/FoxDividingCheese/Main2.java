package Codeforces.B.FoxDividingCheese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        long a = Integer.parseInt(stk.nextToken());
        long b = Integer.parseInt(stk.nextToken());

        int steps = 0;

        while (a != b) {
            if (a % 5 == 0) {
                a = a / 5;
            } else if (a % 3 == 0) {
                a = a / 3;
            } else if (a % 2 == 0) {
                a = a / 2;
            } else {
                System.out.println("-1");
                return;
            }
            if (b % 5 == 0) {
                b = b / 5;
            } else if (b % 3 == 0) {
                b = b / 3;
            } else if (b % 2 == 0) {
                b = b / 2;
            } else {
                System.out.println("-1");
                return;
            }
            steps++;
        }
        System.out.println(steps);
    }
}
