package Spoj.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (!(str = in.readLine()).equals("")) {
            String t = ".........";
            if (solve(t, 1)) {
                sb.append("valid" + "\n");
            } else {
                sb.append("invalid" + "\n");
            }
        }
        System.out.print(sb);

    }

    static Boolean solve(String t, int cur) {

        if (cur > 9) {
            if (str.equals(t)) {
                return true;
            }
            return false;
        }

        Boolean flag = false;

        if (str.charAt(cur - 1) == '.') {
            flag = solve(t, cur + 1) || flag;
        } else {
            for (int i = 0; i < 9; i++) {
                if (t.charAt(i) == '.') {
                    char undo = t.charAt(i);
                    if (cur % 2 == 0 && str.charAt(i) == 'O') {
                        t = t.substring(0, i) + 'O' + t.substring(i + 1, 9);
                        flag = solve(t, cur + 1) || flag;
                        t = t.substring(0, i) + undo + t.substring(i + 1, 9);
                    } else if (cur % 2 == 1 && str.charAt(i) == 'X') {
                        t = t.substring(0, i) + 'X' + t.substring(i + 1, 9);
                        flag = solve(t, cur + 1) || flag;
                        t = t.substring(0, i) + undo + t.substring(i + 1, 9);
                    }
                }

            }
        }
        return flag;
    }
}
