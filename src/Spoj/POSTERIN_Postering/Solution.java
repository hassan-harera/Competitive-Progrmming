package Spoj.POSTERIN_Postering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new  StringBuilder();
        StringTokenizer stk;
        
        Map<Integer,Integer> check = new HashMap();
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            stk = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(stk.nextToken());
            int h = Integer.parseInt(stk.nextToken());
            
            check.put(h, l);
        }
        
        System.out.print(check.keySet().size());
    }
}