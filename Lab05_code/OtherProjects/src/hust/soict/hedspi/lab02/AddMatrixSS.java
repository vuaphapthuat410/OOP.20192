/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.lab02;
import java.util.*;
/**
 *
 * @author vuaphapthuat410
 */
public class AddMatrixSS {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> arrli1 = new ArrayList<Integer>();
        ArrayList<Integer> arrli2 = new ArrayList<Integer>();
        int i, j, tmp;

        System.out.println("Enter the size of matrix: ");
        int iCount = keyboard.nextInt();
        
        for(i=0; i<iCount; i++){
            for(j=0; j<iCount; j++){
                System.out.println("Enter the [" + Integer.toString(i+1) + "]["+ Integer.toString(j+1) +"] element of first matrix: ");
                arrli1.add(keyboard.nextInt());
            }
        }
        
        for(i=0; i<iCount; i++){
            for(j=0; j<iCount; j++){
                System.out.println("Enter the [" + Integer.toString(i+1) + "]["+ Integer.toString(j+1) +"] element of second matrix: ");
                arrli2.add(keyboard.nextInt());
            }
        }
        
        for(i=0; i<iCount; i++){
            for(j=0; j<iCount; j++){
                tmp = arrli1.get(i*iCount+j) + arrli2.get(i*iCount+j);
                System.out.print(Integer.toString(tmp) + " ");
           }
            System.out.println("");
        }   
        
    }
}
