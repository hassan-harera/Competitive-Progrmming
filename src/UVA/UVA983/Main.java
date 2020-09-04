package UVA.UVA983;

import UVA.UVA784.*;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*

1 2 1 3
0 2 3 3
1 0 2 2
1 2 2 1
    
12 18
13 17
_____
     */
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] matx = new int[n + 1][n + 1];
        int[][] ans = new int[n - m + 1][n - m+1];
        
        for (int i = 0; i < matx.length; i++) {
                matx[i][0] = 0;
                matx[0][i] = 0;
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                matx[i][j] = Integer.parseInt(in.readLine());
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                        matx[i][j] +=    matx[i][j-1];  
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                        matx[j][i] +=    matx[j-1][i];  
            }
        }
        
        
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = matx[m+i][m+j] - (matx[m+i][j]) - (matx[i][m+j]) + matx[i][j];
                System.out.println(ans[i][j]);
            }
        }   
        
        
       
    }
}