package StringSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += Character.hashCode(str.charAt(i)) - 96;
        }

        System.out.println(sum);
    }
}