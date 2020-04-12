/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.lab02;
import java.util.Scanner;
/**
 *
 * @author vuaphapthuat410
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int i,j;
        
        System.out.println("Enter the number of stars: ?");
        int n = keyboard.nextInt();
        for(i=1;i<=n;i++)
        {
            for(j=0;j<n-i+1;j++)
                System.out.print(" ");
            for(j=0;j<2*i-1;j++)
                System.out.print("*");
            System.out.println("");
        }
    }
}
