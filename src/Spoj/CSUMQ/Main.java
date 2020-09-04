package Spoj.CSUMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
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
        
        for (int i = 1; i <= n; i++) {
            arr[i] +=  arr[i - 1];
        }
 
        int nq = Integer.parseInt(in.readLine());
 
 
        for (int i = 0; i < nq; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
 
                str.append(arr[r+1]- arr[l]);
                str.append("\n");
        }
        
        System.out.print(str.toString());
    }
}
