package Timus.Timus1349;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.print.attribute.HashAttributeSet;

public class Main {

    static int[] arr;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Map<Integer, Integer> map = new HashMap();
        for (int i = 1; i <= 100; i++) {
            map.put(i, i);
        }

        for (int i = 1; i <= 100; i++) {
            double cp = Math.pow(i, n);
            for (int j = 1; j < i; j++) {
                
                double bp = Math.pow(j, n);
                double ap = cp - bp;
                
                for (int k = 1; k < i; k++) {
                    if (Math.pow(k, n) == ap) {
                        System.out.println(k + " " + j + " " + i);
                        return;
                    }
                }
            }
        }

        System.out.println("-1");
    }

}
