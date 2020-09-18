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

        String ans = "";
        Map<Character, Boolean> p = new HashMap();
        int nQ = 0;

        if(sb.length() == 26){
            for (int j = 0; j < 26; j++) {
                char c = sb.charAt(j);
                if (p.containsKey(c)) {
                    break;
                }

                if (c == '?') {
                    nQ++;
                } else {
                    p.put(c, Boolean.TRUE);
                }
            }
            if (nQ + p.keySet().size() == 26) {
                ans = sb.toString();
            }
            
        }
        
        for (int i = 0; i < sb.length() - 26; i++) {
            nQ = 0;
            p = new HashMap();
            
            for (int j = i; j < 26+i; j++) {
                char c = sb.charAt(j);
                if (p.containsKey(c)) {
                    break;
                }

                if (c == '?') {
                    nQ++;
                } else {
                    p.put(c, Boolean.TRUE);
                }
            }
            if (nQ + p.keySet().size() == 26) {
                ans = sb.substring(i, i + 26);
                break;
            }
        }

        if (ans.equals("")) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '?') {
                for (int j = 0; j < 26; j++) {
                    if (!p.containsKey((char) ('A' + j))) {
                        ans =  ans.substring(0, i) +  (char) ('A' + j) + ans.substring(i+1, ans.length());
                        p.put((char) ('A' + j), Boolean.TRUE); 
                        break;
                    }
                }
            }
        }
        
        System.out.println(ans);

    }
}
