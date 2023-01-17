package Codeforces.A.Football2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Map<String, Integer> map = new HashMap<>(2);

        List<String> teams[] = new List[2];
        teams[0] = new ArrayList<>();
        teams[1] = new ArrayList<>();

        int i = 0;

        while (n-- > 0) {
            String str = in.readLine();

            if (map.containsKey(str)) {
                teams[map.get(str)].add(str);
            } else {
                map.put(str, i);
                teams[i].add(str);
                i++;
            }
        }
        if (teams[0].size() > teams[1].size()) {
            System.out.println(teams[0].get(0));
        } else {
            System.out.println(teams[1].get(0));
        }
    }

}
