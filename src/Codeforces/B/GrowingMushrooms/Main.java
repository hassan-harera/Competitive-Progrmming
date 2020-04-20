package Codeforces.B.GrowingMushrooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int t1 = Integer.parseInt(stk.nextToken());
        int t2 = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        float per = 100 - k;

        Participant[] ps = new Participant[n];
        FinalParticipant[] fp = new FinalParticipant[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            ps[i] = new Participant(a, b);
            float total = (ps[i].before * t1 * (per/100)) + ps[i].after * t2;
            fp[i] = new FinalParticipant(i+1, total);

        }

        Arrays.sort(fp);

        for (int i = 0; i < n; i++) {

            System.out.println(fp[i].idx + " " + fp[i].total);
        }
    }
}

class Participant {

    int before;
    int after;

    public Participant(int b, int a) {
        if (a <= b) {
            before = a;
            after = b;
        } else {
            after = a;
            before = b;

        }
    }

}

class FinalParticipant implements Comparable<FinalParticipant> {

    int idx;
    double total;

    public FinalParticipant(int idx, double total) {
        this.total = total;
        this.idx = idx;
    }

    @Override
    public int compareTo(FinalParticipant o) {
        if (total != o.total) {
            return (int) (o.total - total);
        }
        return idx - o.idx;
    }
}
