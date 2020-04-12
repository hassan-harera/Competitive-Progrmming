package Codeforces.B.Summerselloff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n, f;

        n = Integer.parseInt(stk.nextToken());
        f = Integer.parseInt(stk.nextToken());

        int[] products = new int[n];
        int[] clients = new int[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            products[i] = Integer.parseInt(stk.nextToken());
            clients[i] = Integer.parseInt(stk.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.min(products[i], clients[i]);
        }

        List<Day> copms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (products[i] > 0 && clients[i] > products[i]) {
                copms.add(new Day(i, Integer.min(products[i] * 2, clients[i]) - Integer.min(products[i], clients[i])));
            }
        }

        Collections.sort(copms);

        for (int i = 0; i < f; i++) {
            if (i < copms.size()) {
                sum += copms.get(i).sells;
            } else {
                break;
            }
        }

        System.out.println(sum);
    }
}

class Day implements Comparable<Day> {

    int index, sells;

    public Day(int index, int sells) {
        this.index = index;
        this.sells = sells;
    }

    @Override
    public int compareTo(Day o) {
        return o.sells - sells;
    }

}
