package A.VanyaandFence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int c = 0;

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(stk.nextToken()) > h) {
                c++;
            }
        }
        
        System.out.println(n-c + (c*2));
    }

}
