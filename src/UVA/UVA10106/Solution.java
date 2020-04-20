package UVA.UVA10106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        String str;
        while (!(str = in.readLine()).equals("")) {
            BigInteger s = new BigInteger(str);
            String str2 = in.readLine();
            BigInteger s2 = new BigInteger(str2);
            System.out.println(s.multiply(s2));

        }
    }

}
