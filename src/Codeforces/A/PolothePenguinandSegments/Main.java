package Codeforces.A.PolothePenguinandSegments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int sum = 0;
        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            int dif = r - l + 1;
            sum += dif;
        }
        if (sum % k == 0) {
            System.out.println("0");
            return;
        }
        System.out.println(k - (sum % k));
    }
}
