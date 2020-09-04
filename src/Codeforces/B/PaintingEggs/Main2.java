package Codeforces.B.PaintingEggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int[] arr, values;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        values = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(values, 0);
        max = -1;

        for (int i = 0; i < arr.length; i++) {
            int total = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[j + 1]) {
                    total++;
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[j - 1]) {
                    total++;
                } else {
                    break;
                }
            }
            values[i] = total;
            max = Integer.max(max, total);
        }

        System.out.println(max);
    }
}
