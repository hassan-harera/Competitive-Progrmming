package A.WordCapitalization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int NOC = 0, NOS = 0;
        if (Character.isLowerCase(str.charAt(0))) {
            char ch = Character.toUpperCase(str.charAt(0));
            str = ch + str.substring(1, str.length());
        } else if (Character.isUpperCase(str.charAt(0))) {
            char ch = Character.toUpperCase(str.charAt(0));
            str = ch + str.substring(1, str.length());
        }
        System.out.print(str);
    }

}
