package A.Dubstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st = bf.readLine();
        String newstr = "";

        for (int i = 0; i < st.length();) {
            if (i < st.length() - 2 && st.substring(i, i + 3).equals("WUB")) {
                st = st.substring(i + 3, st.length());
                i = 0;
                newstr += " ";
            } else {
                newstr += st.charAt(i);
                ++i;
            }

        }
        StringBuilder out = new StringBuilder();
        out.append(newstr);
        System.out.println(out);

    }

}
