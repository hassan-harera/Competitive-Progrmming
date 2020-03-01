package QueueusingTwoStacks;

import java.util.Stack;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Stack<Integer> s = new Stack<>();
        Stack<Integer> q = new Stack<>();

        int x = 0, n, Q;

        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            Q = in.nextInt();
            if (Q == 1) {
                x = in.nextInt();
                s.push(x);
            } else if (Q == 2) {
                s.removeElement(s.firstElement());
            } else if (Q == 3) {
                System.out.println(s.firstElement());
            }
        }
    }
}
