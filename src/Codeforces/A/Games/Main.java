package A.Games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][0] == arr[j][1]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
