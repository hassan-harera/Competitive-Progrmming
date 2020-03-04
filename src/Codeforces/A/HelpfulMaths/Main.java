package A.HelpfulMaths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        List<Character> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '+') {
                l.add(s.charAt(i));
            }
        }
        s = "";
        Collections.sort(l);
        for (Character character : l) {
            s += character + "+";
        }
        s = s.substring(0, s.length() - 1);
        System.out.println(s);
    }

}
