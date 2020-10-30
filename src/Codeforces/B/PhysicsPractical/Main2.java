package Codeforces.B.PhysicsPractical;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    static int n;
    static int arr[];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int ans = Integer.MAX_VALUE, count = 0;
        Arrays.sort(arr);

        for (int i = n - 1; i >= 0; i--) {
            ans = Integer.min(ans, binarySearch(i));
        }

        System.out.println(ans);
    }

    public static int binarySearch(int i) {
        int start = 0, end = n;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= arr[i] * 2) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return i + (n - start);
    }
}
