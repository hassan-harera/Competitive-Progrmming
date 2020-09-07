package Spoj.TicTacToe1;

import com.sun.source.tree.CaseTree;
import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static String arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());

        arr = new String[400000];
        arr[0] = ".........";
        buildArr(new StringBuilder("........."), 1, 0);
        while (n-- > 0) {
            sb = new StringBuilder();
            sb.append(in.readLine());
            sb.append(in.readLine());
            sb.append(in.readLine());

            if (n > 0) {
                in.readLine();
            }

            if (checkValid(sb, 0)) {
                System.out.println("yes");;
            } else {
                System.out.println("no");
            }
        }
    }

    private static void buildArr(StringBuilder n, int i, int k) {
        if (i >= 9) {
            return;
        }

        for (int j = 0; j < 9; j++) {
            if (n.charAt(j) == '.') {
                arr[k * 9 + j + 1] = n.replace(j, j, i % 2 == 0 ? "O" : "X").toString();
                buildArr(n, i + 1, k + 1);
            }
        }
    }

    private static Boolean checkValid(StringBuilder n, int k) {
        for (int j = 0; j < 9; j++) {
            if (arr[k * 9 + j + 1] == null) {
                return false;
            }
            if (arr[k * 9 + j + 1].equals(n)) {
                return true;
            }
        }

        Boolean isValid = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[k * 9 + i + 1].charAt(j) != '.' && arr[k * 9 + i + 1].charAt(j) == n.charAt(j)) {
                    isValid = isValid || checkValid(n, k*9+i+1);
                }else if (arr[k * 9 + i + 1].charAt(j) != '.' && arr[k * 9 + i + 1].charAt(j) != n.charAt(j)) {
                    break;
                }
            }
        }
        
        return isValid;
    }

}
