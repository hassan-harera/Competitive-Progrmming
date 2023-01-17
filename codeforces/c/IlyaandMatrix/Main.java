package Codeforces.C.IlyaandMatrix;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int a = Integer.parseInt(in.readLine());
        int arr[] = new int[a];
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

//        if (a == 1) {
//            System.out.println(arr[0]);
//            return;
//        }

        Arrays.sort(arr);
        
        long sum = 0;
        int cur = a;
        while (cur > 0) {
            for (int i = a - 1; i > a - 1 - cur; i--) {
                sum += arr[i];
            }
            cur /= 4;
        }

        System.out.println(sum);
    }
}
