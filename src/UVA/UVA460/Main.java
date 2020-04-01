package UVA.UVA460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        for (int c = 1; c <= n; c++) {
            String str1 = in.readLine();
            String str2 = in.readLine();

            stk = new StringTokenizer(str1);

            int arr[] = new int[8];

            for (int i = 0; i < 8; i++) {
                if (i == 4) {
                    stk = new StringTokenizer(str2);
                }
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            int x1, y1, x2, y2;
            x1 = Integer.max(arr[0], arr[4]);
            y1 = Integer.max(arr[1], arr[5]);
            x2 = Integer.min(arr[2], arr[6]);
            y2 = Integer.min(arr[3], arr[7]);
            if (x1 < x2 && y1 < y2) {
                System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + "\n");
            } else {
                System.out.println("No Overlap\n");
            }
            if (c > 1) {
                System.out.println("\n");
            }
        }

    }
}
