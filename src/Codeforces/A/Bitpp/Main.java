package Codeforces.A.Bitpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(in.readLine());
        int x = 0;
        while(n-->0){
            String str = in.readLine();
            
            if(str.charAt(0) == '+' || str.charAt(2) == '+'){
                ++x;
            }else{
                --x;
            }
            
        }
        System.out.println(x);

    }

}
