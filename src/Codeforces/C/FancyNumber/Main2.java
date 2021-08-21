/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.FancyNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = in.nextInt();
        String s = in.next();
        int[] nums = new int[s.length()];
        int min = Integer.MAX_VALUE;
        int slou = 0;

        for (int i = 0; i < s.length(); i++) {
            nums[i] = Integer.parseInt(s.charAt(i) + "");
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }

        ArrayList<Num> sol = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int sum = 0, cnt = k;
            ArrayList<Num> temp = new ArrayList();
            ArrayList<Num> arrayList = new ArrayList();

            for (Integer key : map.keySet()) {
                arrayList.add(new Num(key, map.get(key), Math.abs(i - key)));
            }

            Collections.sort(arrayList);

            for (Num num : arrayList) {
                if (cnt <= 0) {
                    break;
                }
                int kk = Integer.min(cnt, num.freq);
                cnt -= kk;
                sum += kk * num.dif;
                temp.add(new Num(num.num, kk, num.dif));
            }

            if (sum < min) {
                min = sum;
                sol = (ArrayList<Num>) temp.clone();
                slou = i;
            }
        }

        System.out.println(min);
        for (Num num : sol) {
            while (num.freq > 0)
            for (int i = 0; i < nums.length; i++) {
                if(num.freq <= 0) {
                    break;
                }
                if (nums[i] == num.num) {
                    nums[i] = slou;
                    num.freq--;
                }
            }
        }
        for (int num : nums) {
            System.out.print(num);
        }
    }

    static class Num implements Comparable<Num> {

        int num, freq, dif;

        public Num(int num, int freq, int dif) {
            this.num = num;
            this.freq = freq;
            this.dif = dif;
        }

        @Override
        public int compareTo(Num o) {
            if (dif == o.dif) {
                return o.freq - freq;
            }
            return dif - o.dif;
        }
    }
}
