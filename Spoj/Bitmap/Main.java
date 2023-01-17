package Spoj.Bitmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int compR, compC;
    static List<Pixel> pixels;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt(), m = in.nextInt();

            pixels = new ArrayList();
            for (int i = 0; i < n; i++) {
                String line = in.next();
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '1') {
                        pixels.add(new Pixel(i, j));
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    compR = i;
                    compC = j;
                    Collections.sort(pixels);
                    int Dif = Math.abs(pixels.get(0).r - compR) + Math.abs(pixels.get(0).c - compC);
                    sb.append(Dif + " ");
                }
                sb.append("\n");
            }
            
            System.out.print(sb);
        }
    }

    static class Pixel implements Comparable<Pixel> {

        int r, c;

        public Pixel(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pixel o) {
            int oDif = Math.abs(o.r - compR) + Math.abs(o.c - compC);
            int thisDif = Math.abs(r - compR) + Math.abs(c - compC);

            return thisDif - oDif;
        }
    }
}
