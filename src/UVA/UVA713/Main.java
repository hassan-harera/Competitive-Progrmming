package UVA.UVA713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        while (N-- > 0) {

            stk = new StringTokenizer(in.readLine());

            String num1 = stk.nextToken();
            String num2 = stk.nextToken();

            String newNum1 = "";
            String newNum2 = "";

            for (int i = num1.length() - 1; i >= 0; i--) {
                newNum1 += num1.charAt(i);
            }
            for (int i = num2.length() - 1; i >= 0; i--) {
                newNum2 += num2.charAt(i);
            }

            BigInteger n1 = new BigInteger(newNum1);
            BigInteger n2 = new BigInteger(newNum2);

            BigInteger sum = n1.add(n2);

            String s = sum.toString();
            String newSum = "";

            for (int i = s.length() - 1; i >= 0; i--) {
                newSum += s.charAt(i);
            }

            sb.append(new BigInteger(newSum).toString() + "\n");
        }
        System.out.print(sb);
    }
}
