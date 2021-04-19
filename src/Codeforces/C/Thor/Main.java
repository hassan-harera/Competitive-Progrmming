package Codeforces.C.Thor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int convert[] = new int[100005];
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> apps[] = new ArrayList[n];
        HashMap<Integer, Integer> notifications = new HashMap();

        for (int i = 0; i < n; i++) {
            apps[i] = new ArrayList();
        }

        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(in.readLine());

            int t = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            if (t == 1) {
                x--;
//                convert[i] = apps[x].size();
                notifications.put(i, x);
                apps[x].add(i);
            } else if (t == 2) {
                x--;
                for (int noti : apps[x]) {
                    notifications.remove(noti);
                }
                apps[x].clear();
            } else {
                for (int j = 0; j < x; j++) {
                    if (notifications.containsKey(j)) {
                        apps[notifications.get(j)].remove(0);
                        notifications.remove(j);
                    }
                }
            }

            System.out.println(notifications.size());
        }
    }

//    static class Noti {
//
//        int appId, id;
//        Boolean visit = false;
//
//        public Noti(int appId, int id) {
//            this.appId = appId;
//            this.id = id;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return super.equals(); 
//        }
//    }
}
