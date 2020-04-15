package Codeforces.B.FilyaandHomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());

        List<Integer> list = new ArrayList();
//        Map<Integer, Integer> map = new HashMap();

        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            int curr = Integer.parseInt(stk.nextToken());
            list.add(curr);

        }

        Collections.sort(list, Collections.reverseOrder());
        int a = list.get(0);
        int dif = -1;
        for (int i = 1; i < list.size(); i++) {
            if (a - list.get(i) > 0) {
                dif = a - list.get(i);
                break;
            }
        }
        int compare = list.get(list.size() - 1) + dif;

        for (int k = 0; k < list.size() - 1; k++) {
            if (list.get(k) == compare || list.get(k) - dif == compare || list.get(k) + dif == compare) {
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
