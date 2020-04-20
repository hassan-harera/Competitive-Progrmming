package A.Football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st = bf.readLine();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < st.length(); i++) {
            q.add(st.charAt(i));
        }
        int c = 1;
        char ch = q.poll();
        while (!q.isEmpty()) {
            if (q.peek() == ch) {
                ch = q.poll();
                ++c;
            } else {
                ch = q.poll();
                c = 1;
            }
            if (c == 7) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}
