package A.KseniaandPanScales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        StringTokenizer stk = new StringTokenizer(str, "|");
        String[] strs = new String[3];
        if (str.charAt(0) == '|') {
            strs[1] = stk.hasMoreElements() ? stk.nextToken() : "";
            strs[0] = "";
        } else if (str.charAt(str.length() - 1) == '|') {
            strs[0] = stk.hasMoreElements() ? stk.nextToken() : "";
            strs[1] = "";

        } else {
            strs[0] = stk.nextToken();
            strs[1] = stk.nextToken();
        }
        strs[2] = in.readLine();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = strs[i].length();
        }
        int i = 0;
        while (arr[2] != 0) {
            if (arr[0] < arr[1]) {
                strs[0] += strs[2].charAt(i);
                arr[0]++;
                arr[2]--;
            } else {
                strs[1] += strs[2].charAt(i);
                arr[1]++;
                arr[2]--;
            }
            i++;
        }
        if (strs[0].length() != strs[1].length()) {
            System.out.println("Impossible");
        } else {
            System.out.println(strs[0] + "|" + strs[1]);
        }
    }

}
