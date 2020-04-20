package ToggleString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                char c = Character.toLowerCase(str.charAt(i));
                if (i == 0) {
                    str = c + str.substring(i + 1, str.length());
                } else if (i == str.length() - 1) {
                    str = str.substring(0, str.length() - 1) + c;
                } else {
                    str = str.substring(0, i) + c + str.substring(i + 1, str.length());
                }

            } else {
                char c = Character.toUpperCase(str.charAt(i));
                if (i == 0) {
                    str = c + str.substring(i + 1, str.length());
                } else if (i == str.length() - 1) {
                    str = str.substring(0, str.length() - 1) + c;
                } else {
                    str = str.substring(0, i) + c + str.substring(i + 1, str.length());
                }
            }
        }
        System.out.println(str);
    }
}
