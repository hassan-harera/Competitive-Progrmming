package Timus.Timus1100;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        PriorityQueue<Team> pq = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            pq.add(new Team(in.nextInt(), in.nextInt()));
        }

        while (!pq.isEmpty()) {
            Team t = pq.poll();
            System.out.println(t.id + " " + t.m);
        }

    }

}

class Team implements Comparable<Team> {

    int id, m;

    public Team(int id, int m) {
        this.id = id;
        this.m = m;
    }

    @Override
    public int compareTo(Team t) {
        if (m != t.m) {
            return t.m - m;
        }
        return id - t.id;
    }

}
