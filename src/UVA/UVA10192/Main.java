package UVA.UVA10192;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1;
        int tes = 1;
        while (!(str1 = in.readLine()).equals("#")) {
            String str2 = in.readLine();

            char[] I = new char[str1.length() + 1];
            char[] J = new char[str2.length() + 1];
            for (int i = 1; i < I.length; i++) {
                I[i] = str1.charAt(i - 1);
            }
            for (int i = 1; i < J.length; i++) {
                J[i] = str2.charAt(i - 1);
            }

            int[][] dp = new int[I.length][J.length];
            for (int i = 1; i < I.length; i++) {
                for (int j = 1; j < J.length; j++) {
                    if (I[i] == J[j]) {
                        dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            sb.append("Case #" + tes + ": you can visit at most " + dp[I.length - 1][J.length - 1] + " cities." + "\n");
            tes++;
        }
        System.out.print(sb);
//        System.out.println( "Case #1: you can visit at most 3 cities.".equals("Case #1: you can visit at most 3 cities."));
    }
}
