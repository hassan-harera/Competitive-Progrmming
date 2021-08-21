package Codeforces.C.LearningLanguages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] L;
    static List<Integer>[] N;
    static int[] parent;
    static Boolean flag = false;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();

        N = new List[n + 1];
        for (int i = 0; i < N.length; i++) {
            N[i] = new ArrayList();
        }

        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        L = new List[l + 1];
        for (int i = 0; i < L.length; i++) {
            L[i] = new ArrayList();
        }

        for (int i = 1; i <= n; i++) {
            int nOL = in.nextInt();
            if (nOL > 0) {
                flag = true;
            }
            for (int j = 0; j < nOL; j++) {
                int ll = in.nextInt();
                L[ll].add(i);
                N[i].add(ll);
            }
        }

        System.out.println(search());
    }

    private static int search() {
        for (int i = 1; i < L.length; i++) {
            for (int l : L[i]) {
                union(l, L[i].get(0));
            }
        }

        int res = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        if (flag) {
            return res - 1;
        } else {
            return res;
        }
    }

    static int root(int idx) {
        if (idx == parent[idx]) {
            return idx;
        }

        return parent[idx] = root(parent[idx]);
    }

    static void union(int idx, int idx2) {
        int root = root(idx);
        int root2 = root(idx2);

        parent[root2] = root;
    }
}
