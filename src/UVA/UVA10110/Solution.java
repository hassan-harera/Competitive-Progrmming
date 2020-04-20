package UVA10110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        
        int N;
        while ((N = Integer.parseInt(in.readLine())) != 0) {
            Boolean isOn = false;
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    isOn = !isOn;
                }
            }
            if (isOn) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }

}
