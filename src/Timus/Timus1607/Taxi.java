package Timus.Timus1607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Taxi {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        stk = new StringTokenizer(in.readLine());

        int num1 = Integer.parseInt(stk.nextToken());
        int num2 = Integer.parseInt(stk.nextToken());
        int num3 = Integer.parseInt(stk.nextToken());
        int num4 = Integer.parseInt(stk.nextToken());

        if (num1 >= num3) {
            System.out.println(num1);
            return;
        }
        int intialDiff = num3 - num1;

        int times = intialDiff / (num2 + num4);

        if ((num1 + num2 * times) >= (num3 - num4 * times)) {
            System.out.println((num1 + num2 * times));
            return;
        }
        if ((num3 - num4 * (times + 1)) == (num1 + num2 * (times))) {
            System.out.println((num3 - num4 * (times + 1)));
            return;
        }
        if ((num1 + num2 * (times + 1)) >= (num3 - num4 * times)) {
            System.out.println((num1 + num2 * (times + 1)));
            return;
        }

        System.out.println((num1 + num2 * (times + 1)));

    }
}
