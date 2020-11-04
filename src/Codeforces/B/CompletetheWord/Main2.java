package Codeforces.B.CompletetheWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(in.readLine());

        Boolean isNice = false;

        for (int i = 0; i < sb.length() - 26; i++) {
            int nq = 0;
            Map<Character, Boolean> p = new HashMap();

            String sb1 = sb.substring(i, i + 26);
            for (int j = 0; j < 26; j++) {
                if (sb1.charAt(j) == '?') {
                    nq++;
                } else {
                    p.put(sb1.charAt(j), Boolean.FALSE);
                }
            }

            if (p.size() + nq == 26) {
                isNice = true;
                for (int k = i, a = 0; a < 26; k++, a++) {
                    if (sb.charAt(k) == '?') {
                        for (int t = 0; t < 26; t++) {
                            if (!p.containsKey((char) ('A' + t))) {
                                sb.replace(k, k, "" + ((char) ('A' + k)));
                                p.put(((char) ('A' + t)), true);
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (isNice) {
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == '?'){
                    sb.replace(i, i, "A");
                }
            }
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }
    }
}
