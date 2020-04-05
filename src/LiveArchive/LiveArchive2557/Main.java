package LiveArchive.LiveArchive2557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        while (N-- > 0) {

            int n = Integer.parseInt(in.readLine());
            sb.append((int) Math.sqrt(n) + "\n");
        }
        System.out.print(sb);
    }
}
