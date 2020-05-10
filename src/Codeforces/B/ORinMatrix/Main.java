package Codeforces.B.ORinMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] B = new int[n][m];
        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        Boolean one = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 1) {
                    one = true;
                    Boolean flag = false;
                    for (int k = 0; k < n; k++) {
                        if (k != i && B[k][j] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        if (k != j && B[i][k] == 1) {
                            flag = true;
                            break;
                        }

                    }
                    if (!flag) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (A[k][j] != 1) {
                            A[k][j] = 1;
                        } else {
                            break;
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        if (A[i][k] != 1) {
                            A[i][k] = 1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        Boolean isZero = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        A[k][j] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        A[i][k] = 0;
                    }

                }

            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    isZero = false;
                }
            }
        }

        if (isZero && one) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
