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
public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();
        
        System.out.println("Mr/Ms. " + strName + ", " + iAge + " years old. "
                            + "Your height is " + dHeight + ".");
        
    }
    
}
