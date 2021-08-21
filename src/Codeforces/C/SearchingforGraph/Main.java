package Codeforces.C.SearchingforGraph;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();

            int count = 1;

            for (int i = 1; i <= n && count <= 2 * n + p; i++) {
                for (int j = i + 1; j <= n && count <= 2 * n + p; j++) {
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }
    }
}
