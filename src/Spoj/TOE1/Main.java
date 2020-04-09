package Spoj.TOE1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());

        f:
        while (n-- > 0) {
            int xNum = 0;
            int oNum = 0;
            char[][] grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String str = in.readLine();
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = str.charAt(j);
                    if (grid[i][j] == 'X') {
                        xNum++;
                    } else if (grid[i][j] == 'O') {
                        oNum++;
                    }
                }
            }
            in.readLine();
            if (oNum > xNum || xNum > (oNum + 1)) {
                sb.append("no\n");
            } else {
                Boolean xWin = false;
                Boolean oWin = false;

                for (int i = 0; i < 3; i++) {
                    char ch;
                    if (i == 0) {
                        if ((grid[i][0] != '.') && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                            if (grid[i][0] == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                        if ((grid[i][0] != '.') && grid[0][0] == grid[1][0] && grid[2][0] == grid[1][0]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (grid[1][0] == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }

                        if ((grid[i][0] != '.') && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (grid[1][1] == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                    } else if (i == 1) {
                        if ((grid[i][0] != '.') && grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (grid[1][1] == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                        if ((grid[i][0] != '.') && grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (grid[1][1] == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                    } else {
                        ch = grid[i][0];
                        if ((grid[i][0] != '.') && ch == grid[i][1] && grid[i][1] == grid[i][2]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (ch == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                        if ((grid[i][0] != '.') && grid[i][0] == grid[1][1] && grid[1][1] == grid[0][2]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (ch == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                        ch = grid[i][2];
                        if ((grid[i][0] != '.') && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                            if (xWin || oWin) {
                                sb.append("no\n");
                                continue f;
                            }
                            if (ch == 'X') {
                                xWin = true;
                            } else {
                                oWin = true;
                            }
                        }
                    }
                }
                if (xWin && oNum == xNum) {
                    sb.append("no\n");
                    continue f;
                } else if (oWin && oNum != xNum) {
                    sb.append("no\n");
                    continue f;
                }
                sb.append("yes\n");
            }
        }
        System.out.print(sb);
    }
}
