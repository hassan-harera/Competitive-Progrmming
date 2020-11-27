package Codeforces.C.LearningLanguages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static List<Integer>[] L;
    static List<Integer>[] N;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();

        N = new List[n + 1];
        L = new List[l + 1];
        Arrays.fill(N, new ArrayList());
        Arrays.fill(L, new ArrayList());

        for (int i = 1; i <= n; i++) {
            int nOL = in.nextInt();

            for (int j = 0; j < nOL; j++) {
                int ll = in.nextInt();
                L[ll].add(i);
                N[i].add(ll);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Integer.min(search(i + 1), ans);
        }
        
        System.out.println(ans);
    }

    private static int search(int i) {
        Queue<Integer> QN = new LinkedList();
        Queue<Integer> QL = new LinkedList();

        Boolean[] VN = new Boolean[N.length];
        Boolean[] VL = new Boolean[L.length];

        Arrays.fill(VN, false);
        Arrays.fill(VL, false);

        QL.add(i + 1);

        while (!QL.isEmpty() || !QN.isEmpty()) {
            int l = QL.isEmpty() ? 0 : QL.poll();
            for (Integer integer : L[l]) {
                if (!VN[integer]) {
                    QN.add(integer);
                }
            }
            int n = QN.isEmpty() ? 0 : QN.poll();
            for (Integer integer : N[n]) {
                if (!VL[integer]) {
                    QL.add(integer);
                }
            }
            VL[l] = true;
            VN[n] = true;
        }
        
        int cost = 0;
        for (int j = 1; j < VN.length; j++) {
            cost = VN[0] ? cost : cost + 1;
        }
        return cost;
    }
}
