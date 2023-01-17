package Codeforces.C.SoldierandCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Queue<Integer> q1 = new LinkedList<>(), q11 = new LinkedList<>(),
                q2 = new LinkedList<>(), q22 = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        st.nextToken();
        while (st.hasMoreElements()) {
            int cur = Integer.parseInt(st.nextToken());
            q1.add(cur);
            q11.add(cur);
        }

        st = new StringTokenizer(in.readLine());
        st.nextToken();
        while (st.hasMoreElements()) {
            int cur = Integer.parseInt(st.nextToken());
            q2.add(cur);
            q22.add(cur);
        }
        int counter = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            q11.clear();
            q11.addAll(q1);
            q22.clear();
            q22.addAll(q2);

            int c1 = q1.poll(), c2 = q2.poll();
            if (c1 > c2) {
                q1.add(c2);
                q1.add(c1);
            } else {
                q2.add(c1);
                q2.add(c2);
            }

            if (counter >= n * 1000) {
                System.out.println("-1");
                return;
            }
            counter++;
            
        }

        if (q1.isEmpty()) {
            System.out.println(counter + " 2");
        } else {
            System.out.println(counter + " 1");
        }
    }
}
