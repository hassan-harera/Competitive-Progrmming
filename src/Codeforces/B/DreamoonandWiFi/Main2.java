/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.DreamoonandWiFi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String f2 = in.readLine();
        String f1 = in.readLine();

        int n_q = 0;
        int n_p1 = 0, n_n1 = 0, n_p2 = 0, n_n2 = 0;

        for (int i = 0; i < f1.length(); i++) {
            if (f1.charAt(i) == '+') {
                n_p1++;
            } else if (f1.charAt(i) == '-') {
                n_n1++;
            } else if (f1.charAt(i) == '?') {
                n_q++;
            }

            if (f2.charAt(i) == '+') {
                n_p2++;
            } else if (f2.charAt(i) == '-') {
                n_n2++;
            }
        }

        if (n_q == 0 && (n_p1 != n_p2)) {
            System.out.println((double) 0);
            return;
        } else if (n_q == 0 && n_p1 == n_p2) {
            System.out.println((double) 1);
            return;
        }
        if (n_p1 > n_p2 || n_n1 > n_n2) {
            System.out.println((double) 0);
            return;
        }

        int facQ = 1;
        for (int i = 2; i <= n_q; i++) {
            facQ *= i;
        }
        int facR = 1;
        for (int i = 2; i <= Math.abs(n_p1 - n_p2); i++) {
            facR *= i;
        }
        int facDif = 1;
        for (int i = 2; i <= (n_q - Math.abs(n_p1 - n_p2)); i++) {
            facDif *= i;
        }

        int totalPos = (int) Math.pow(2, n_q);

        double ans = facQ;
        ans /= (facR * facDif);
        ans /= (totalPos);

        System.out.println(ans);
    }
}
