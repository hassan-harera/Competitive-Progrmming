package A.AntonandDanik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine()), A = 0, D = 0;
        String str = in.readLine();

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'A') {
                A++;
            } else {
                D++;
            }
        }
        if (A > D) {
            System.out.println("Anton");
        } else if (D > A) {
            System.out.println("Danik");
        } else {
            System.out.println("Friendship");
        }
    }

}
