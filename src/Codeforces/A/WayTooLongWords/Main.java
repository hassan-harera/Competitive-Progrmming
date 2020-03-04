package A.WayTooLongWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        while (n-- > 0) {
            String str = bf.readLine();
            if (str.length() <= 10) {
                sb.append(str + "\n");
            } else {
                String s = "";
                s += str.charAt(0);
                s += str.length() - 2;
                s += str.charAt(str.length() - 1);
                sb.append(s + "\n");
            }
        }
        System.out.println(sb);
    }

}
