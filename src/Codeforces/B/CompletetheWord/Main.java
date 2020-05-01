package Codeforces.B.CompletetheWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = in.readLine();

        int st[] = new int[26];
        Boolean isQ = true;
        Boolean isC = true;
        int qs = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '?') {
                st[str.charAt(i) - 'A']++;
                isQ = false;
            } else {
                qs++;
                isC = false;
            }
        }

        if (str.length() < 26) {
            System.out.println("-1");
            return;
        }
        
        if (isC) {
            for (int i = 0; i < 26; i++) {
                System.out.print(st[i]);
                if (st[i] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
            System.out.println(str);
        }

        for (int i = 0; i < 26; i++) {
            if (st[i] == 0) {
                qs--;
            }
            if (qs < 0) {
                System.out.println("-1");
                return;
            }
        }

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                while (true) {
                    if (st[j % 26] == 0) {
                        sb.append((char) ((j % 26) + 'A'));
                        j++;
                        break;
                    }
                    j++;
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.print(sb);

    }

}
