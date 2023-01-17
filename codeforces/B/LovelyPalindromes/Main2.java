package Codeforces.B.LovelyPalindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int arr [] = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0, end = 0;
        Boolean isSorted = true;
        
        for (int i = 0; i < n-1; i++) {
            if(!isSorted && arr[i] < arr[i+1]){
                break;
            }
            else if(arr[i] > arr[i+1]){
                if(isSorted){
                    start = i;
                }
                isSorted = false;
                end = i + 1;
            }
        }
        
        for (int i = start, j = end; i < n && j < n &&i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        for (int i = 0; i < n-1; i++) {
             if(arr[i] > arr[i+1]){
                 System.out.println("no");
                 return;
             }
        }
        
        System.out.println("yes");
        System.out.println((start+1)+ " " + (end+1));
    }   
}