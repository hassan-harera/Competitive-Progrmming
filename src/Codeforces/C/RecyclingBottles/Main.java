/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.C.RecyclingBottles;

import java.util.Scanner;

/**
 *
 * @author Harera
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ax = in.nextInt(), ay = in.nextInt(), bx = in.nextInt(), by = in.nextInt(), tx = in.nextInt(), ty = in.nextInt();
        
        int n = in.nextInt();
        int [][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = in.nextInt();
            mat[i][1] = in.nextInt();
        }
        
        double l = dis(ax, ay, tx, ty) + 
        double disa = dis(ax, ay, tx, ty) + 
    }
    
    private static double dis(int ax, int ay, int bx, int by) {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

}
