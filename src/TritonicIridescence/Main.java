package TritonicIridescence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        String str = in.readLine();
        Boolean diff = false;
        for (int i = i = 1; i < n; i++) {
            if (str.charAt(i) == '?' && str.charAt(i) == str.charAt(i - 1)) {
                diff = true;
            } else if (str.charAt(i) == '?' && i < n - 1 && str.charAt(i - 1) == str.charAt(i + 1)) {
                diff = true;
            } else if (str.charAt(i) != '?' && str.charAt(i) == str.charAt(i - 1)) {
                System.out.println("NO");
                return;
            }

        }
        if (diff || str.charAt(0) == '?' || str.charAt(n - 1) == '?') {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
