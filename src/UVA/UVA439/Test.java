/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVA.UVA439;

/**
 *
 * @author harera
 */
public class Test {

    public static void main(String[] args) {

        String input = "e2 e4";
        int rs = input.charAt(0) - 'a' + 1;
        int cs = Integer.parseInt(input.charAt(1) + "");
        int rd = input.charAt(3) - 'a' + 1;
        int cd = Integer.parseInt(input.charAt(4) + "");
        
        System.out.println(rs + " " + cs + " " + rd + " " + cd);
    }

}
