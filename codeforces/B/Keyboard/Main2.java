package Codeforces.B.Keyboard;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        Map<Point, Boolean> map = new HashMap();
        Boolean isFound[] = new Boolean[26];
        Arrays.fill(isFound, false);
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'S') {
                    map.put(new Point(i, j), Boolean.TRUE);
                } else {
                    isFound[grid[i][j] - 'a'] = true;
                }
            }

        }

        Boolean canUpper[] = new Boolean[26];
        Arrays.fill(canUpper, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'S') {
                    for (Point p : map.keySet()) {
                        if (Math.sqrt((p.x - i) * (p.x - i) +  (p.y - j) * (p.y - j)) <= x) {
                            canUpper[grid[i][j] - 'a'] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        int ans = 0;
        int q = Integer.parseInt(in.readLine());
        String str = in.readLine();
        for (int i = 0; i < str.length(); i++) {
            if(!isFound[Character.toLowerCase(str.charAt(i))-'a']){
                System.out.println("-1");
                return;
            }
            
            if(Character.isUpperCase(str.charAt(i))){
                if(map.isEmpty()){
                    System.out.println("-1");
                    return;
                }
                if(!canUpper[Character.toLowerCase(str.charAt(i))- 'a']){
                    ans++;
                }
            }
        }
        
        System.out.println(ans);
    }
}