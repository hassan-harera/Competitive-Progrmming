package A.ValeraandX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        char[][] chars = new char[n][n];

        char f1, f2;
        for (int i = 0; i < n; i++) {
            String st = bf.readLine();
            for (int j = 0; j < n; j++) {
                chars[i][j] = st.charAt(j);
                f1 = chars[0][0];
                f2 = chars[0][1];
                if (i == j) {
                    if (f1 != chars[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                } else if (j == n - 1 - i) {
                    if (f1 != chars[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                } else if (f2 != chars[i][j] || f1 == chars[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}
