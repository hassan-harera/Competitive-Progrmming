
package PetyaandStrings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
 
public class Main {
    
    public static void main(String [] args) throws IOException{
        
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = bf.readLine().toLowerCase();
        String str2 = bf.readLine().toLowerCase();
        
        for(int i = 0 ; i <str1.length() ; i++){
            if(str1.charAt(i)>str2.charAt(i)){              
                System.out.println("1"); return ;
            }
            else if(str1.charAt(i) < str2.charAt(i)){
                System.out.println("-1"); return ;
            }
        }
        System.out.println("0");
        
        
    }
    
}
