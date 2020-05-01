package Codeforces.B.Hopscotch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        if (x < -a || x > a) {
            System.out.println("-1");
            return;
        }

        if (y % a == 0) {
            System.out.println("-1");
            return;
        }

        int row = y / a + 1;

        if (Math.abs(x) >= 0.5 * a + 1 && (row % 2 == 0)) {
            return;
        }

        if (Math.abs(x) >= a && row % 2 == 1) {
            System.out.println("-1");
            return;
        }

        if (row == 1) {
            if (Math.abs(x) >= 0.5 * a + 1 || x == 0) {
                System.out.println("-1");
            } else if (Math.abs(x) < 0.5 * a + 1) {
                System.out.println("1");
            }
        } else {
            if (row % 2 == 1) {
                if (x > 0) {
                    System.out.println(row + (row - 3) / 2 + 1);
                } else if (x < 0) {
//  1   1-2- 1-2  1-2  1-2   1-2  first 3 rows is base case   the  number in the positive side from this equation
                    System.out.println(row + (row - 3) / 2);
                } else {
                    System.out.println("-1");
                }
            } else {
                if (x > 0) {
                    System.out.println("-1");
                }
                System.out.println(row + (row / 1) - 2);
            }
            // number of the negative side in this row from this equation

        }
    }
}
