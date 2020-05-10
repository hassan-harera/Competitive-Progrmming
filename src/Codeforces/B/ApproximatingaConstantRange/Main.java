package Codeforces.B.ApproximatingaConstantRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer stk = new StringTokenizer(in.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int longest = 1, prev = -1, current = arr[0], next;
        int currentCount = 1, prevCount = 0;

        for (int i = 1; i < arr.length; i++) {
            next = arr[i];

            if (next == current) {
                currentCount++;
            } else if (next == prev) {
                prevCount += currentCount;
                prev = current;
                current = next;
                currentCount = 1;
            } else {
                longest = Integer.max(longest, currentCount + prevCount);
                prevCount = currentCount;
                prev = current;
                current = next;
                currentCount = 1;
            }
        }
        longest = Integer.max(longest, currentCount + prevCount);
        System.out.println(longest);

    }
}
