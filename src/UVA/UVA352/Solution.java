package UVA.UVA352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while (!(str = in.readLine()).equals("")) {
            int ans = 0;

            int n = Integer.parseInt(str);
            Boolean img[][] = new Boolean[n][n];
            for (int i = 0; i < n; i++) {
                String newString = in.readLine();

                for (int j = 0; j < n; j++) {
                    if (newString.charAt(j) == '1') {
                        img[i][j] = true;
                    } else {
                        img[i][j] = false;
                    }
                }
                if (i >= 1) {
                    for (int j = 0; j < n - 1; j++) {
                        if (j >= 1 && img[i - 1][j] && img[i][j - 1]) {
                            if (j < n - 1 && img[i - 1][j] && img[i][j + 1]) {
                                img[i - 1][j] = img[i][j + 1] = false;
                            }
                            img[i - 1][j] = img[i][j - 1] = false;
                            ans++;
                        } else if (j < n - 1 && img[i - 1][j] && img[i][j + 1]) {
                            if (j >= 1 && img[i - 1][j] && img[i][j - 1]) {
                                img[i - 1][j] = img[i][j - 1] = false;
                            }
                            img[i - 1][j] = img[i][j + 1] = false;
                            ans++;
                        } else if (j >= 1 && j < n - 1 && img[i - 1][j - 1] && img[i - 1][j + 1]) {
                            img[i - 1][j - 1] = img[i - 1][j + 1] = false;
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
