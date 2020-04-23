package Timus.Timus1638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bookworm {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(in.readLine());

        int s = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        if (start == end) {
            System.out.println(s);
            return;
        } else if (start < end) {
            System.out.println((end - start + 1) * c);
            return;
        } else {
            System.out.println(((start - end + 1) * c) + (start - end +1 ) * s) ;
        }

    }
}
