/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.CaisaandPylons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author harera
 */
public class Main1 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[3];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String str = in.readLine();
            if (str.charAt(1) == '>') {
                arr[str.charAt(0) - 'A']++;
            } else {
                arr[str.charAt(2) - 'A']++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }

        char[] sorted = new char[3];
        for (int j = 0; j < 3; j++) {
            if (arr[j] == 2) {
                sorted[0] = (char) (j + 'A');
            }
        }
        for (int j = 0; j < 3; j++) {
            if (arr[j] == 1) {
                sorted[1] = (char) (j + 'A');
            }
        }
        for (int j = 0; j < 3; j++) {
            if (arr[j] == 0) {
                sorted[2] = (char) (j + 'A');
            }
        }

        System.out.println(sorted[2] + "" + sorted[1] + ""+sorted[0]);
    }
}
