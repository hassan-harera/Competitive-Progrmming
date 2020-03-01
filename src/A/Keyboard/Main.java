package A.Keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String st = "qwertyuiopasdfghjkl;zxcvbnm,./";
        List<Character> l = new ArrayList<>();
        for (int i = 0; i < st.length(); i++) {
            l.add(st.charAt(i));
        }

        String ch = bf.readLine();
        String s = bf.readLine();
        if (ch.equals("R")) {
            for (int i = 0; i < s.length(); i++) {
                {
                    s = s.substring(0, i) + l.get(l.indexOf(s.charAt(i)) - 1) + s.substring(i + 1, s.length());
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(0, i) + l.get(l.indexOf(s.charAt(i)) + 1) + s.substring(i + 1, s.length());
            }
        }
        StringBuilder out = new StringBuilder();
        out.append(s);
        System.out.println(out);
    }
}
