
package Codeforces.C.DrazilandFactorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] res = new String [] {" ", " ", "2 ", "3 ", "2 2 3 ", "5 ", "3 5 ", "7 ", "2 2 2 7 ", "2 3 3 7 "};
        
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(res[Integer.parseInt("" + s.charAt(i))]);
        }
        
        StringTokenizer st = new StringTokenizer(sb.toString());
        List<Integer>  list = new ArrayList<>();
        
        while (st.hasMoreElements()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}