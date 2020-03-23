package Codeforces.A.NextRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int val = 0;

        stk = new StringTokenizer(in.readLine());

        int arr[] = new int[N];
        List<Integer> list = new ArrayList();

        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(stk.nextToken());
            if (c > 0) {
                list.add(c);
            }
            if (i == K - 1) {
                val = c;
            }
        }

        int check = 0;
        for (; check < list.size() && list.get(check) >= val; check++) {
            check++;
        }
        System.out.println(check);

    }
}
