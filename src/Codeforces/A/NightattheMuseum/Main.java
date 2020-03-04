package A.NightattheMuseum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name = in.readLine();
        char a = 'a';
        int count = 13, res = 0;
        for (int i = 0; i < name.length(); i++) {
            int r = Math.abs(name.charAt(i) - a);
            if (r >= count) {
                res += 26 - r;
            } else {
                res += r;
            }
            a = name.charAt(i);
        }
        System.out.println(res);
    }

}
