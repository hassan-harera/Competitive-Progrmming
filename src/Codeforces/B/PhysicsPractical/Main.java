package Codeforces.B.PhysicsPractical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int arr[] = new int[n];
        int steps1 = 0;
        int steps2 = 0;

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] * 2 >= arr[n - 1]) {
                steps1 = i;
                break;
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] / 2 <= arr[0]) {
                steps2 = n - j;
                break;
            }
        }

        System.out.println(Integer.min(steps1, steps2));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapSort(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapSort(arr, i, 0);
        }
    }

    private static int[] heapSort(int[] arr, int n, int i) {
        int large = i;
        int left = large * 2 + 1;
        int right = large * 2 + 2;

        if (left < n && arr[left] > arr[large]) {
            large = left;
        }
        if (right < n && arr[right] > arr[large]) {
            large = right;
        }
        if (large != i) {
            int temp = arr[i];
            arr[i] = arr[large];
            arr[large] = temp;
            heapSort(arr, n, large);
        }
        return arr;
    }
}
