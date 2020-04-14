package Codeforces.A.FreeIceCream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        Long NofI = Long.parseLong(stk.nextToken());
        Long NofL = Long.parseLong("0");

        while (N-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            String s = stk.nextToken();
            if (s.equals("+")) {
                int plus = Integer.parseInt(stk.nextToken());
                NofI += plus;
            } else {
                int min = Integer.parseInt(stk.nextToken());
                if (NofI - min < 0) {
                    ++NofL;
                } else {
                    NofI -= min;
                }
            }

        }
        System.out.println(NofI + " " + NofL);

    }

}
