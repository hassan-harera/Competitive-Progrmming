package UVA.UVA105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        arr = new int[10002];
        int start = Integer.MAX_VALUE;
        int end = -1;

        String str;
        while (!(str = in.readLine()).equals("")) {
            stk = new StringTokenizer(str);
            int l = Integer.parseInt(stk.nextToken());
            int h = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            for (int i = l; i < r; i++) {
                if (arr[i] < h) {
                    arr[i] = h;

                }
            }
            start = Integer.min(start, l);
            end = Integer.max(end, r);
        }

        System.out.print(start + " " + arr[start]);

        for (int i = start + 1; i < end; i++) {
            if (arr[i - 1] != arr[i]) {
                System.out.print(" " + (i) + " " + arr[i]);
            }
        }

        System.out.print(" " + end + " " + 0);

    }
}
