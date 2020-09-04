/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.A.BearandBgBrother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken()) - 1;

        int[] values = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int total = values[idx] == 1 ? 1 : 0;

        for (int i = 1; idx - i >= 0 || idx + i < n; i++) {
            if (idx - i < 0) {
                total = values[idx + i] == 1 ? total + 1 : total;
            } else if (idx + i >= n) {
                total = values[idx - i] == 1 ? total + 1 : total;
            }else if(values[idx - i] == 1 || values[idx + i] == 1){
                total++;
            }
        }
        
        System.out.println(total);
    }

}
