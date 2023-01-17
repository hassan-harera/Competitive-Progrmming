package UVA.UVA11573;


import java.util.Scanner;

public class Main {

    static int[][] flow;
    static int[][] cost;
    static int[] moveR = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] moveC = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    static int r, c;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        r = in.nextInt();
        c = in.nextInt();

        flow = new int[r + 1][c + 1];
        cost = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            String st = in.next();
            for (int j = 1; j <= c; j++) {
                flow[i][j] = Integer.parseInt("" + st.charAt(j-1));
            }
        }

        int p = in.nextInt();
        for (int i = 0; i < p; i++) {
            int cr = in.nextInt(), cc = in.nextInt(), dr = in.nextInt(), dc = in.nextInt();

            for (int k = 0; k <= r; k++) {
                for (int t = 0; t <= c; t++) {
                    cost[k][t] = Integer.MAX_VALUE;
                }
            }
            cost[cr][cc] = 0;
            search(cr, cc);
            System.out.println(cost[dr][dc]);
        }
    }

    private static void search(int cr, int cc) {
        for (int i = 0; i < 8; i++) {
            int nr = cr + moveR[i];
            int nc = cc + moveC[i];
            if (nr > r || nc > c || nr < 0 || nc < 0) {
                continue;
            }

            if (flow[cr][cc] == i) {
                if (cost[nr][nc] > cost[cr][cc]) {
                    cost[nr][nc] = cost[cr][cc];
                    search(nr, nc);
                }
            } else if (cost[nr][nc] > cost[cr][cc] + 1) {
                cost[nr][nc] = cost[cr][cc] + 1;
                search(nr, nc);
            }
        }
    }
}