package D.OneDCafeteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static table[] arr;
    static int min;
    static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<table> s = new TreeSet<>();
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        arr = new table[n];

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(stk.nextToken());
            arr[i] = new table(i + 1, a);
            s.add(arr[i]);
        }
        while (q-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            String Q = stk.nextToken();
            int a = Integer.parseInt(stk.nextToken());
            if (Q.equals("in")) {
                table t = s.ceiling(new table(1, a));
                if (t == null) {
                    sb.append("-1" + "\n");
                } else {
                    s.remove(t);
                    sb.append(t.index + "\n");
                }
            } else {
                s.add(arr[a - 1]);
            }
        }
        System.out.println(sb);

    }
}

class table implements Comparable<table> {

    int index;
    int cap;

    table(int i, int c) {
        index = i;
        cap = c;
    }

    @Override
    public int compareTo(table t) {
        if (cap == t.cap) {
            return index - t.index;
        }
        return cap - t.cap;
    }

}
