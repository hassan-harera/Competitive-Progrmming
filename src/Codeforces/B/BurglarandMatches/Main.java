package Codeforces.B.BurglarandMatches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int total = 0;

        List<Container> conts = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            conts.add(new Container(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        Collections.sort(conts);

        for (Container cont : conts) {
            if (cont.matchBox >= n) {
                total += n * cont.matches;
                break;
            } else {
                total += cont.matchBox * cont.matches;
                n -= cont.matchBox;
            }
        }

        System.out.println(total);
    }
}

class Container implements Comparable<Container> {

    int matchBox, matches;

    public Container(int matchBox, int matches) {
        this.matchBox = matchBox;
        this.matches = matches;
    }

    @Override
    public int compareTo(Container o) {
        if (o.matches != matches) {
            return o.matches - matches;
        }
        return o.matchBox- matchBox;
    }

}