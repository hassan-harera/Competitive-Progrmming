package Codeforces.B.SuffixStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str1 = in.readLine();
        String str2 = in.readLine();

        int[] s1 = new int[26];
        int[] s2 = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            s1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            s2[str2.charAt(i) - 'a']++;
            if (s2[str2.charAt(i) - 'a'] > s1[str2.charAt(i) - 'a']) {
                System.out.println("need tree");
                return;
            }
        }
        int j = 0, i = 0;
        while(i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j >= str2.length()) {
            System.out.println("automaton");
        } else {
            if (str1.length() == str2.length()) {
                System.out.println("array");
            } else {
                System.out.println("both");
            }
        }
    }
}
