package Codeforces.B.ColorfulField1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Pair> map;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        String[] sr = {"Carrots", "Kiwis", "Grapes"};

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        map = new HashMap<>();

        List<Pair> ques = new ArrayList<>();

        int[] arr = new int[n * m + 1];
        int tot = 0, s = 0;

        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            ques.add(new Pair(r, c));
        }

        Collections.sort(ques);

        for (int i = 0; i < ques.size(); i++) {
            int r = ques.get(i).row;
            int c = ques.get(i).col;

//            Arrays.fill(arr, s, ((r - 1) * m + c), tot);
            map.put((r - 1) * m + c, new Pair(r, c));
            tot++;
            s = (r - 1) * m + c;
        }

        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if (map.containsKey((r - 1) * m + c)) {
                sb.append("Waste\n");
            } else {
                int cur = ((r - 1) * m + c - arr[(r - 1) * m + c] - 1) % 3;
                sb.append(sr[cur] + "\n");
            }
        }

        System.out.print(sb);
    }
}

class Pair implements Comparable<Pair> {

    int row, col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Pair o) {
        if (row != o.row) {
            return row - o.row;
        }
        return col - o.col;
    }

}
