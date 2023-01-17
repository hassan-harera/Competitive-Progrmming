package Codeforces.B.EasyNumberChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    int count = 0;
                    int res = i * j * k;
                    for (int l = 1; l * l <= res; l++) {
                        if (res % l == 0) {
                            count++;
                            if (l * l != res) {
                                count++;
                            }
                        }

                    }
                    ans += count;
                }
            }
        }
        System.out.println((ans % 1073741824));
    }
}
