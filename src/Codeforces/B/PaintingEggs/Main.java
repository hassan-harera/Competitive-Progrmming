package Codeforces.B.PaintingEggs;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
StringBuilder ans = new StringBuilder();

        int n = in.nextInt();

        int A[] = new int[n];
        int G[] = new int[n];

        long As = 0, Gs = 0;

        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            G[i] = in.nextInt();

            if (Math.abs(As + A[i] - Gs) <= Math.abs(Gs + G[i] - As)) {
                ans.append('A');
                As += A[i];
            } else {
                ans.append('G');
                Gs += G[i];
            }
        }
        
        if (Math.abs(As - Gs) <= 500) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
