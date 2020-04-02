/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.garbage;
import java.util.*;
/**
 *
 * @author vuaphapthuat410
 */
public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0;i < 65536; i++) 
            s += r.nextInt(2);
        System.out.println(System.currentTimeMillis() - start); //This prints roughly big number(approximately 1600)
        
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 65536; i++) 
            sb.append(r.nextInt(2));
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start); //This prints small number (1,2,etc)
    }
}
