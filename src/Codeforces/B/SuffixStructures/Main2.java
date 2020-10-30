package Codeforces.B.SuffixStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine(), t = in.readLine();
        int[] sArr = new int[26], tArr = new int[26];

        Boolean isAutomaton = false;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (j == t.length() - 1) {
                    isAutomaton = true;
                }
                j++;
            }
        }
        if (isAutomaton) {
            System.out.println("automaton");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (sArr[t.charAt(i) - 'a'] < tArr[t.charAt(i) - 'a']) {
                System.out.println("need tree");
                return;
            }
        }

        if (s.length() > t.length()) {
            System.out.println("both");
        } else {
            System.out.println("array");
        }

    }
}
