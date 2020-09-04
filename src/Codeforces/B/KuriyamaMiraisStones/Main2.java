package Codeforces.B.KuriyamaMiraisStones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    
    // don't use system out printing big number of lines collect them in sb and push them at last
    

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder str = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        long arr[] = new long[n + 1];
        arr[0] = 0;

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long arrSorted[] = arr.clone();
        Arrays.sort(arrSorted);

        arr[0] = 0;
        arrSorted[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i] + arr[i - 1];
            arrSorted[i] = arrSorted[i] + arrSorted[i - 1];
        }

        int nq = Integer.parseInt(in.readLine());

        for (int i = 0; i < nq; i++) {
            st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (t == 1) {
                str.append(arr[r] - arr[l - 1]);
                str.append("\n");
            } else {
                str.append(arrSorted[r] - arrSorted[l - 1]);
                str.append("\n");
            }
        }
        
        System.out.print(str.toString());
    }
}