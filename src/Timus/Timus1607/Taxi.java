package Timus.Timus1607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Taxi {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(in.readLine());

        int num1 = Integer.parseInt(stk.nextToken());
        int num2 = Integer.parseInt(stk.nextToken());
        int num3 = Integer.parseInt(stk.nextToken());
        int num4 = Integer.parseInt(stk.nextToken());

        if (num1 >= num3) {
            System.out.println(num1);
            return;
        }
        int i = 0;
        while (true) {

            if (num1 + (i * num2) >= num3 - (num4 * i)) { //if the guys offer is greater than or equal to the taxis then take it
                System.out.println(num1 - (i * num2));
                break;
            }

            if (num1 + ((i + 1) * num2) >= num3 - (num4 * i)) { //if the guys next offer will be more than the current taxis then take the taxis
                System.out.println(num3 - (num4 * i));
                break;
            }
            i++;
        }
    }
}
