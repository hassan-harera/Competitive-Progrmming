package Codeforces.B.Keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Key> map;
    static List<Key> shifts;
    static List<Key>[] ks;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int ans = 0;
        map = new HashMap<>();
        int[] b = new int[26];
        Arrays.fill(b, 0);

        ks = new List[26];
        for (int i = 0; i < 26; i++) {
            ks[i] = new ArrayList<>();
        }

        shifts = new ArrayList();

        char[][] keys = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < m; j++) {
                keys[i][j] = str.charAt(j);
                if (keys[i][j] == 'S') {
                    shifts.add(new Key(i, j, keys[i][j]));
                } else {
                    ks[(int) keys[i][j] - 97].add(new Key(i, j, keys[i][j]));
                }
                map.put(keys[i][j] - 0, new Key(i, j, keys[i][j]));
            }
        }

        Collections.sort(shifts);
        for (int i = 0; i < 26; i++) {
            Collections.sort(ks[i]);
        }

        int q = Integer.parseInt(in.readLine());

        String query = in.readLine();

        f:
        for (int i = 0; i < q; i++) {
            char lch = Character.toLowerCase(query.charAt(i));
            char uch = query.charAt(i);
            if (!map.containsKey(lch - 0)) {
                System.out.println("-1");
                return;
            }
            if (Character.isUpperCase(uch)) {
                if (shifts.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
            }
            if (Character.isUpperCase(uch)) {
                b[lch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            Boolean g = true;
            if (b[i] >= 1) {
                f:
                for (Key k : ks[i]) {
                    for (Key key : shifts) {
                        double d = Math.sqrt(Math.pow(Math.abs(key.col - k.col), 2) + Math.pow(Math.abs(key.row - k.row), 2));
                        if (d <= x) {
                            g = false;
                            break f;
                        }
                    }
                }
            }
            if (g) {
                ans += b[i];
            }
        }
//        List<Key> list = ks[(int) lch - 97];
//        if (Character.isUpperCase(uch)) {
//            if (shifts.isEmpty()) {
//                System.out.println("-1");
//                return;
//            }
//            for (Key k : list) {
//                for (Key key : shifts) {
//                    double d = Math.sqrt(Math.pow(Math.abs(key.col - k.col), 2) + Math.pow(Math.abs(key.row - k.row), 2));
//                    if (d <= x) {
//                        continue f;
//                    }
//                    if (Math.abs(key.col - k.col) >= x && Math.abs(key.row - k.row) - (n + m) >= x) {
//                        break;
//                    }
//                }
//            }
//            ans++;
//        }
//    }

        System.out.println(ans);
    }

}

class Key implements Comparable<Key> {

    int row, col;
    char key;

    public Key(int row, int col, char key) {
        this.row = row;
        this.col = col;
        this.key = key;
    }

    @Override
    public int compareTo(Key o) {
        if (row != o.row) {
            return row - o.row;
        }
        return col - o.col;
    }

}
