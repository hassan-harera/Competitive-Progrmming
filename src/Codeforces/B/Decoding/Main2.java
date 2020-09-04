package Codeforces.B.Decoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String str = in.readLine();

        Boolean isRight;

        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        sb.append(str);

        if (n % 2 == 0) {
            isRight = true;
        } else {
            isRight = false;
        }

        ans.append(sb.charAt(0));
        sb.deleteCharAt(0);

        for (int i = 0; sb.length() >= 1;) {
            if (isRight) {
                ans.append(sb.charAt(i));
                sb.deleteCharAt(i);
                isRight = !isRight;
            } else {
                ans = new StringBuilder().append(sb.charAt(i)).append(ans);
                sb.deleteCharAt(i);
                isRight = !isRight;
            }
        }

        System.out.println(ans.toString());

    }

}
