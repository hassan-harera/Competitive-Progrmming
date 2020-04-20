package Codeforces.C.Woodcutters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int grid[][] = new int[n][2];

        if(n == 1){
            System.out.println(n);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(in.readLine());
            grid[i][0] = Integer.parseInt(stk.nextToken());
            grid[i][1] = Integer.parseInt(stk.nextToken());
        }

        int ans = 2;
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] - grid[i-1][0] > grid[i][1]) {
                ans++;
            } else if (grid[i+1][0] - grid[i][0] > grid[i][1]) {
                grid[i][0]+=grid[i][1];
                ans++;
            }
        }
        
        System.out.println(ans);
        
    }
}
