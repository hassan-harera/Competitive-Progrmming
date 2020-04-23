package Codeforces.B.BearandStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String temp = "" + str;
        int size = str.length() - 1;
        final String bear = "bear";

        List<Pair> bears = new ArrayList();

        int l = 0,r = 0;
        int shift = 0;
        while ((l = str.indexOf(bear, l)) != -1) {
            r = l+3;
            bears.add(new Pair(l + shift, r+ shift));
            str = str.substring(l + 4);
            shift += r+1;
        }

        Collections.sort(bears);
        int min = 0;
        for (int i = 1; i < bears.size(); i++) {
            min += (size - bears.get(i).r) - bears.get(i - 1).l - 1;
        }

        int ans = 0;
        for (Pair bear1 : bears) {
            int le = bear1.l - 0 + 1;
            int ri = size - bear1.r + 1;
            ans += (le * ri);
        }

        System.out.println(ans - min);
    }
}

class Pair implements Comparable<Pair> {

    int l, r;

    public Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Pair o) {

        return l - o.l;
    }

}
