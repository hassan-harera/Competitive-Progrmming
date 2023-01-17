/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.EasterEggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] colors = new char[]{'R', 'O', 'Y', 'G', 'B', 'I', 'V'};
        int n = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (ans.length() >= n) {
                break;
            }
            ans.append(colors[i] + "");
        }

        while (ans.length() < n) {
            for (int i = 3; i < 7; i++) {
                if (ans.length() >= n) {
                    break;
                }
                ans.append(colors[i] + "");
            }
        }
        
        System.out.println(ans.toString());
    }

}
