package Codeforces.C.PalindromeTransformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer in = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(in.nextToken());
        int p = Integer.parseInt(in.nextToken()) - 1;
        int m = n / 2 - 1, ans = 0;

        String s = br.readLine();

        if (p > m) {
            p = n - p - 1;
        }
        int l = 0, r = m;
        while (l <= m && s.charAt(l) == s.charAt(n - l - 1)) {
            l++;
        }
        while (r >= 0 && s.charAt(r) == s.charAt(n - r - 1)) {
            r--;
        }
        for (int i = l; i <= r; i++) {
            int c = Math.abs(s.charAt(i) - s.charAt(n - i - 1));
            ans += Integer.min(c, 26 - c);
        }
        if (l <= r) {
            ans += r - l + Integer.min(Math.abs(p - l), Math.abs(p - r));
        }
        System.out.println(ans);
    }
}
