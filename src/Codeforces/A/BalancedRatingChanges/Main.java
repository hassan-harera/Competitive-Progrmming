package Codeforces.A.BalancedRatingChanges;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int mod = 0;

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                if (mod == 0) {
                    ans[i] = arr[i] / 2;
                    mod += arr[i] % 2;
                } else {
                    arr[i] += mod;
                    ans[i] = arr[i] / 2;
                    mod = arr[i] % 2;
                }
            } else {
                ans[i] = arr[i] / 2;
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
