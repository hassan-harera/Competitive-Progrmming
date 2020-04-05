package UVA.UVA374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = 2147483647;
        System.out.println(new BigInteger("2147483647").pow(k/1000000));
        
        String str;
        while (!(str = in.readLine()).equals("")) {

            int B = Integer.parseInt(str);
            int P = Integer.parseInt(in.readLine());
            int M = Integer.parseInt(in.readLine());
            

            BigInteger res = mod(B, P, M);

            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
    
    static BigInteger mod(int a,int b,int c){
        
        if(b == 0){
            return new BigInteger("1");
        }
        if(b%2 == 0){
            BigInteger val = mod(a, b/2, c);
            return val.multiply(val).mod(new BigInteger(c+""));
        }else{
            BigInteger x = new BigInteger(a%c +"");
            return mod(a, b-1, c).multiply(x);
        }
    }
    
}
