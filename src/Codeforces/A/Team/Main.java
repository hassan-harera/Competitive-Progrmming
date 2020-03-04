package A.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            int c = 0;
            for (int j = 0; j < 3; j++) {
                c += Integer.parseInt(stk.nextToken());
            }
            if (c >= 2) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

}
