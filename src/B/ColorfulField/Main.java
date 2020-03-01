package B.ColorfulField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        String[] words = {"Carrots", "Kiwis", "Grapes"};
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int nW = Integer.parseInt(stk.nextToken());
        int nQ = Integer.parseInt(stk.nextToken());
        List<Integer> Wests = new ArrayList<>();
        while (nW-- > 0) {
            stk = new StringTokenizer(bf.readLine());
            int add = (Integer.parseInt(stk.nextToken()) - 1) * m + Integer.parseInt(stk.nextToken());
            Wests.add(add);

        }
        Collections.sort(Wests);
        while (nQ-- > 0) {
            int Nofw = 0;
            stk = new StringTokenizer(bf.readLine());
            int add = (Integer.parseInt(stk.nextToken()) - 1) * m + Integer.parseInt(stk.nextToken());
            if (Wests.contains(add)) {
                System.out.println("Waste");
            } else {
                for (Integer West : Wests) {
                    if (West < add) {
                        ++Nofw;
                    } else {
                        break;
                    }
                }

                add -= Nofw;
                add %= 3;
                add += 2;
                add %= 3;
                System.out.println(words[add]);
            }

        }
    }

}
