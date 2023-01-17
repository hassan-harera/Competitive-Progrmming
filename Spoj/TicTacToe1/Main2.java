package Spoj.TicTacToe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            sb = new StringBuilder();
            sb.append(in.readLine());
            sb.append(in.readLine());
            sb.append(in.readLine());

            if (n > 0) {
                in.readLine();
            }

            BFS(sb.toString());
        }
    }

    private static void BFS(String des) {
        Queue<String> q = new LinkedList();

        q.add(".........");

        Boolean win = false;
        Boolean X = false;
        while (!q.isEmpty()) {
            X  = !X;

            String curr = q.poll();
            if (curr.equals(des)) {
                win = true;
                break;
            }
            for (int i = 0; i < 9; i++) {
                if (curr.charAt(i) == '.') {
                    if ((X ? 'X' : 'O') == des.charAt(i)) {
                        String s = curr.substring(0, i) + (X ? "X" : "O") + curr.substring(i + 1, 9);
                        q.add(s);
                    }
                }
            }
        }

        if (win) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
