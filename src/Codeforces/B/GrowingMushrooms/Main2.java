/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.GrowingMushrooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int t1 = Integer.parseInt(stk.nextToken());
        int t2 = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Participant[] p = new Participant[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            double max = Double.max((double)((a * t1) * (double) ((100 - k) / 100)) + (b * t2), ((double) ((b * t1) * (double) ((100 - k))) / 100) + (a * t2));
            p[i] = new Participant(i + 1, max);
        }

        Arrays.sort(p);

        for (Participant participant : p) {
            System.out.println(participant.indes + " " + participant.totalMash);
        }

    }

}

class Participant implements Comparable<Participant> {

    int indes;
    double totalMash;

    public Participant(int indes, double totalMash) {
        this.indes = indes;
        this.totalMash = totalMash;
    }

    @Override
    public int compareTo(Participant t) {
        if (totalMash != t.totalMash) {
            return (int) (t.totalMash - totalMash);
        }

        return indes - t.indes;
    }

}
