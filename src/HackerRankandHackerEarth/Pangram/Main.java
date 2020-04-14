package Pangram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        String str = bf.readLine().toLowerCase();
        int n = Integer.parseInt(stk.nextToken());
        List<Character> l = new ArrayList<>();
        if (n < 26) {
            System.out.println("NO");
        } else {

            for (int i = 0; i < str.length(); i++) {
                if (!l.contains(str.charAt(i))) {
                    l.add(str.charAt(i));
                }
            }
            if (l.size() < 26) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

    }

}
