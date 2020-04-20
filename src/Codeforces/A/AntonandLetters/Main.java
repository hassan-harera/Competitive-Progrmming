package A.AntonandLetters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        List<Character> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (l.isEmpty()) {
                    l.add(s.charAt(i));
                } else if (!l.contains(s.charAt(i))) {
                    l.add(s.charAt(i));
                }
            }
        }
        System.out.println(l.size());
    }
}
