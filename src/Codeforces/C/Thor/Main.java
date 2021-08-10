package Codeforces.C.Thor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> apps[] = new ArrayList[300005];
    static HashMap<Integer, Integer> notifications = new HashMap();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        int cnt = 1, min = 0;

        for (int i = 0; i < apps.length; i++) {
            apps[i] = new ArrayList();
        }

        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(in.readLine());

            int t = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            if (t == 1) {
                notifications.put(cnt, 0);
                apps[x].add(cnt);
                cnt++;
            } else if (t == 2) {
                for (int noti : apps[x]) {
                    notifications.remove(noti);
                }
                apps[x].clear();
            } else {
                for (int j = x; j > 0 && x > 0; j--) {
                    if (notifications.containsKey(j)) {
                        notifications.remove(j);
                        x--;
                    }
                }
            }
            System.out.println(notifications.size());
        }
    }
}
