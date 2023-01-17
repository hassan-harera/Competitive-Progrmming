package A.NewPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int Y = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());

        char[] arr = new char[W];
        String ans = "";

        for (int i = 0; i < W; i++) {
            arr[i] = (char) ('a' + i);
        }

        int i = 0;
        for (; ans.length() < Y; i++) {
            i = i % W;
            ans += arr[i];
        }

        System.out.println(ans);

    }
}
