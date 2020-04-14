package SparseArrays;


import java.util.Scanner;

public class Solution {
    
    public static void main(String [] arg)
    {
        Scanner in = new Scanner(System.in);
        int n ,q ;
        
        
        n= in.nextInt();
        String [] ArrayOfString = new String[n];
        for (int i = 0 ; i<n ; i++)
        {
            ArrayOfString[i] = in.next();
        }
        
        
        q=in.nextInt();
        String [] ArrayOfQuerry = new String [q];
        for(int i = 0 ; i < q ; i++)
        {
            ArrayOfQuerry[i] = in.next();
        }
        
        int [] frequency = new int [q];
        
        for(int i = 0 ; i < q ; i++)
        {
        for(int j = 0 ; j < n ; j++)
        {
            if (ArrayOfQuerry[i].equals(ArrayOfString[j]))
                frequency[i]++;
        }
        }
        for (int i =0 ; i<q ; i++)
        {
            System.out.println(frequency[i]);
        }
    }
}
