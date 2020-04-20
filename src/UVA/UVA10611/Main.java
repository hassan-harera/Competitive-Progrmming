package UVA.UVA10611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        arr = new int[N];

        StringTokenizer stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int Q = Integer.parseInt(in.readLine());

        stk = new StringTokenizer(in.readLine());
        for (int i = 0; i < Q; i++) {
            int curr = Integer.parseInt(stk.nextToken());

            int resBiger = binarySearchHigh(curr);
            int resSmaller = binarySearchLow(curr);

            if (resSmaller != -1) {
                sb.append(resSmaller + " ");
            } else {
                sb.append("X ");
            }
            if (resBiger != -1) {
                sb.append(resBiger + " ");
            } else {
                sb.append("X ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int binarySearchLow(int target) {
        int low = 0, high = arr.length - 1, mid ;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        if (high < 0) {
            return -1;
        }
        return arr[high];
    }

    static int binarySearchHigh(int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        if (low > arr.length - 1) {
            return -1;
        }
        return arr[low];
    }
}
