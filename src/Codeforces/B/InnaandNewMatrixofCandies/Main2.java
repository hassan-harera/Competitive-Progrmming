package Codeforces.B.InnaandNewMatrixofCandies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] dwarf = new int[n];
        int[] sweet = new int[n];

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'G') {
                    dwarf[i] = j;
                } else if (grid[i][j] == 'S') {
                    sweet[i] = j;
                }
            }
        }
        
        int max = -1;
        
        for (int i = 0; i < n; i++) {
            if(sweet[i] < dwarf[i] && dwarf[i] != m-1){
                        System.out.println("");
                    return;
                    } 
            
            int min  = Integer.min(m - dwarf[i] - 2, Math.abs(sweet[i] - dwarf[i] -1 ));
            
            max = Integer.max(max, min);
        }
        System.out.println(max);
        
    }
}
