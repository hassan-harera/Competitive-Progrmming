package UVA.UVA122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        List<node> list = new ArrayList<>();
        node root;
        Boolean notCompleted = false;
        String line;
        while (!(line = in.readLine()).equals("")) {
            stk = new StringTokenizer(line);
            String token;
            f:
            while (stk.hasMoreElements()) {
                if ((token = stk.nextToken()).equals("()")) {
                    if (notCompleted) {
                        sb.append("not completed\n");
                        break;
                    }
                    Collections.sort(list);
                    if (list.get(0).level != 0) {
                        sb.append("not completed\n");
                        break;
                    }
                    for (String st : map.keySet()) {
                        if (st.length()>=2 && !map.containsKey(st.substring(0,st.length() - 1))) {
                            sb.append("not completed\n");
                            break f;
                        }
                    }
                    Collections.sort(list);
                    for (node object : list) {
                        sb.append(object.val+" ");
                    }
                    sb.append("\n");
                }
                if (token.charAt(1) == ',') {
                    notCompleted = true;
                    continue;
                }
                token = token.replaceAll("[(,)]", " ");
                StringTokenizer stk2 = new StringTokenizer(token);
                if (stk2.countTokens() == 1) {
                    int val = Integer.parseInt(stk2.nextToken());
                    root = new node(0, val, "R");
                    list.add(root);
                    map.put("R", val);
                } else {
                    while (stk2.hasMoreElements()) {
                        int val = Integer.parseInt(stk2.nextToken());
                        String node = stk2.nextToken();
                        if (map.containsKey(node)) {
                            notCompleted = true;
                        } else {
                            node curr = new node(node.length(), val, node);
                            map.put(node, val);
                            list.add(curr);
                        }
                    }
                }
            }
        }
        System.out.print(sb);
    }
}

class node implements Comparable<node> {

    int val;
    int level;
    String seq;

    public node(int l, int v, String seq) {
        level = l;
        val = v;
        this.seq = seq;
    }

    @Override
    public int compareTo(node o) {
        if (o.level != level) {
            return level - o.level;
        }
        for (int i = 0; i < seq.length(); i++) {
            if (this.seq.charAt(i) != o.seq.charAt(i)) {
                if (this.seq.charAt(i) == 'R') {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
}
