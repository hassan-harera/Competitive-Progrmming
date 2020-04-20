package A.BrainsPhotos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> l = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        while (n-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            String st;
            while (stk.hasMoreElements()) {
                st = stk.nextToken();
                l.add(st);
            }

        }
        int c = 10;
        for (String string : l) {

            if (string.equals("Y") || string.equals("M") || string.equals("C")) {
                System.out.println("#Color");
                c = 0;
                break;
            }
        }

        if (c != 0) {
            System.out.println("#Black&White");
        }
    }
}
