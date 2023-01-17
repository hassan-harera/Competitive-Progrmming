/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.EffectiveApproach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long vasya = 0, petya = 0;

        int nElements = Integer.parseInt(in.readLine());
        Map<Integer, Integer> arrElements = new HashMap();

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < nElements; i++) {
            arrElements.put(Integer.parseInt(st.nextToken()), i + 1);
        }

        int nQuerys = Integer.parseInt(in.readLine());
        int arrQuerys[] = new int[nQuerys];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < nQuerys; i++) {
            arrQuerys[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nQuerys; i++) {
            if (arrElements.containsKey(arrQuerys[i])) {
                vasya += arrElements.get(arrQuerys[i]);
                petya += (nElements - arrElements.get(arrQuerys[i]) + 1);
            }
        }

        System.out.println(vasya +" " + petya);

    }
}
