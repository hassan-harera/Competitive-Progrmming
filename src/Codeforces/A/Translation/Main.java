package Codeforces.A.Translation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        String str1 = in.readLine();
        String str2 = in.readLine();

        for (int i = str1.length() - 1; i >= 0; i--) {
            sb.append(str1.charAt(i));
        }
        String s = sb.toString();
        if (str2.equals(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
