package Codeforces.B.Coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Pair[] arr = new Pair[3];
        arr[0] = new Pair('A');
        arr[1] = new Pair('B');
        arr[2] = new Pair('C');

        String[] sts = new String[3];
        for (int i = 0; i < 3; i++) {
            sts[i] = in.readLine();
        }

        if (sts[1].charAt(0) == sts[0].charAt(2) && sts[0].charAt(0) == sts[1].charAt(2) && sts[0].charAt(1) == sts[1].charAt(1)) {
            System.out.println("Impossible");
            return;
        }
        if (sts[2].charAt(0) == sts[1].charAt(2) && sts[1].charAt(0) == sts[2].charAt(2) && sts[1].charAt(1) == sts[2].charAt(1)) {
            System.out.println("Impossible");
            return;

        }
        if (sts[2].charAt(0) == sts[0].charAt(2) && sts[0].charAt(0) == sts[2].charAt(2) && sts[0].charAt(1) == sts[2].charAt(1)) {
            System.out.println("Impossible");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (sts[i].charAt(1) == '>') {
                arr[sts[i].charAt(0) - 65].val++;
            } else {
                arr[sts[i].charAt(2) - 65].val++;
            }
        }

        Arrays.sort(arr);

        if (arr[0].val == arr[1].val && arr[1].val == arr[2].val) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(arr[0].ch + "" + arr[1].ch + "" + arr[2].ch);
    }
}

class Pair implements Comparable<Pair> {

    char ch;
    int val;

    public Pair(char ch) {
        this.ch = ch;
        this.val = 0;
    }

    @Override
    public int compareTo(Pair o) {
        return val - o.val;
    }

}
