package DreamoonandWiFi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str1 = in.readLine();
        String str2 = in.readLine();
        int pos = 0, neg = 0, ques = 0;
        int pos1 = 0, neg1 = 0;
        int n = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '+') {
                pos++;
            } else if (str1.charAt(i) == '-') {
                neg++;
            }
            if (str2.charAt(i) == '+') {
                pos1++;
            } else if (str2.charAt(i) == '-') {
                neg1++;
            }
            if (str2.charAt(i) == '?') {
                ques++;
            }
        }
        if (pos1 > pos || neg1 > neg) {
            System.out.println((double) 0);
        } else if (ques == 0) {
            System.out.println(1);
        } else {
            System.out.println(1 / ques);
        }

    }
}
