package UVA.UVA374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = in.readLine()).equals("")) {

            BigInteger B = new BigInteger(str);
            int P = Integer.parseInt(in.readLine());
            BigInteger M = new BigInteger(in.readLine());

            
            
//            String space = in.readLine();

            BigInteger res = B.pow(P);
            res = res.mod(M);

            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
