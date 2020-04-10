package Codeforces.B.KuriyamaMiraisStones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        long[] arr1 = new long[n + 1];
        long[] arr2 = new long[n + 1];

        arr1[0] = 0;
        arr2[0] = 0;
        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr1[i] = Integer.parseInt(stk.nextToken());
            arr2[i] = arr1[i];
        }
        
        
        Arrays.sort(arr2);

        for (int i = 1; i <= n; i++) {
            arr1[i] += arr1[i - 1];
            arr2[i] += arr2[i - 1];
        }

        int m = Integer.parseInt(in.readLine());
        int[][] ques = new int[m][3];
        Long sum;
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(in.readLine());
            ques[i][0] = Integer.parseInt(stk.nextToken());
            ques[i][1] = Integer.parseInt(stk.nextToken());
            ques[i][2] = Integer.parseInt(stk.nextToken());
            if (ques[i][0] == 1) {
                sum = new Long(""+arr1[ques[i][2]])-(arr1[ques[i][1] - 1]);
                sb.append(sum + "\n");
            } else {
                sum = new Long(""+arr2[ques[i][2]])-(arr2[ques[i][1] - 1]);
                sb.append(sum + "\n");
            }
        }

        System.out.print(sb);
    }

}
