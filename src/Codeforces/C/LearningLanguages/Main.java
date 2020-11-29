package Codeforces.C.LearningLanguages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static List<Integer>[] L;
    static List<Integer>[] N;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();

        N = new List[n + 1];
        L = new List[l + 1];
        for (int i = 0; i < N.length; i++) {
            N[i] = new ArrayList();
        }
        for (int i = 0; i < L.length; i++) {
            L[i] = new ArrayList();
        }

        for (int i = 1; i <= n; i++) {
            int nOL = in.nextInt();

            for (int j = 0; j < nOL; j++) {
                int ll = in.nextInt();
                L[ll].add(i);
                N[i].add(ll);
            }
        }

        System.out.println(search());
    }

    private static int search() {
        Set<Integer> [] set = new Set[N.length];
        
        Boolean flag = false;
        for (int j = 1; j < N.length; j++) {
            if (!N[j].isEmpty()) {
                flag = true;
            }
            for (Integer l : N[j]) {
                for (Integer n : L[l]) {
                    if (n != j) {
                        set[j].add(n);
                        set[n].add(j);
                    }
                }
            }
        }

        int count = 0;
        for (int j = 1; j < N.length; j++) {
            count = Integer.max(count, set[j].size());
        }
        return N.length - 1 - count;
    }
}
