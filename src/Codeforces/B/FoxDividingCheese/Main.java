package Codeforces.B.FoxDividingCheese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        double a1 = Integer.parseInt(stk.nextToken());
        double a2 = Integer.parseInt(stk.nextToken());

        if (a1 == a2) {
            System.out.println(0);
            return;
        }

        int op1[] = new int[3], op2[] = new int[3];
        while (a1 > 0) {
            if (a1 % 3 == 0) {
                a1 = (a1 / 3);
                op1[0]++;
            } else if (a1 % 5 == 0) {
                a1 = (a1 / 5);
                op1[1]++;
            } else if (a1 % 2 == 0) {
                a1 = (a1 / 2);
                op1[2]++;
            } else {
                break;
            }
        }

        while (a2 > 0) {
            if (a2 % 3 == 0) {
                a2 = (a2 / 3);
                op2[0]++;
            } else if (a2 % 5 == 0) {
                a2 = (a2 / 5);
                op2[1]++;
            } else if (a2 % 2 == 0) {
                a2 = (a2 / 2);
                op2[2]++;
            } else {
                break;
            }
        }
        if (a1 != a2) {
            System.out.println("-1");
        } else {
            System.out.println(Math.abs(op1[0] - op2[0]) + Math.abs(op1[1] - op2[1]) + Math.abs(op1[2] - op2[2]));
        }

    }
}
