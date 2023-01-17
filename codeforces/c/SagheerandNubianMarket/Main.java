package Codeforces.C.SagheerandNubianMarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
    static Pair arr[];
    static int totalPrice[];
    static int b, n;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
 
        n = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
 
        arr = new Pair[n + 1];
        arr[0] = new Pair(0, 0);
 
        totalPrice = new int[n + 1];
 
        stk = new StringTokenizer(in.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new Pair(i, Integer.parseInt(stk.nextToken()));
        }
 
        binarySearch(0, n);
    }
 
    private static void binarySearch(int l, int r) {
        long total = 0;
        int number = 0;
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            for (int i = 1; i < totalPrice.length; i++) {
                totalPrice[i] = arr[i].price + i * mid;
            }
            Arrays.sort(totalPrice);
            long totalCost = totalCost(mid);
            if (totalCost > 0 && totalCost <= b) {
                l = mid;
                number = mid;
                total = totalCost;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(number + " " + total);
    }
 
    private static long totalCost(int K) {
        long total = 0;
        for (int i = 1; i <= K; i++) {
            total += totalPrice[i];
        }
        return total;
    }
}
 
class Pair {
 
    int idx, price;
 
    public Pair(int idx, int price) {
        this.idx = idx;
        this.price = price;
    }
}
