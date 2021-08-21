package Codeforces.C.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer stk;

        int n = Integer.parseInt(in.readLine());
        LinkedList<Person> q = new LinkedList();

        Person[] p = new Person[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            String name = stk.nextToken();
            int h = Integer.parseInt(stk.nextToken());

            p[i] = new Person(name, h);
        }
        Arrays.sort(p);

        for (int i = 0, c = (n + 1) * (n + 1); i < n; i++, c -= n) {
            if (p[i].h > i) {
                System.out.println(-1);
                return;
            }

            q.add(p[0].h + p[i].h, new Person(p[i].name, c));
        }

        for (Person person : q) {
            System.out.println(person.name + " " + person.h);
        }
    }

    static class Person implements Comparable<Person> {

        String name;
        int h;

        public Person(String name, int h) {
            this.name = name;
            this.h = h;
        }

        @Override
        public int compareTo(Person o) {
            return h - o.h;
        }
    }
}
