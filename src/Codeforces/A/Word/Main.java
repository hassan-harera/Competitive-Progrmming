package A.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int NOC = 0, NOS = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                ++NOS;
            } else if (Character.isUpperCase(str.charAt(i))) {
                ++NOC;
            }
        }
        if (NOC > NOS) {
            str = str.toUpperCase();
        } else {
            str = str.toLowerCase();
        }

        System.out.print(str);
    }

}
