package StringTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toLowerCase();
        List<Character> l = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'u' || str.charAt(i) == 'o' || str.charAt(i) == 'i' || str.charAt(i) == 'e' || str.charAt(i) == 'a' || str.charAt(i) == 'y'); else {
                l.add(str.charAt(i));
            }
        }
        str = "";
        for (Character character : l) {
            str += "." + character;
        }
        System.out.println(str);

    }
}
