/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author vuaphapthuat410
 */
public class GarbageCreator {
    public static void main(String[] args) {
        String myStr = "";
        try {
            File myText = new File("/run/media/vuaphapthuat410/HDD/BK courses/OOP/OOLT.20192/Hands-on labs/Lab05_code/OtherProjects/src/hust/soict/hedspi/garbage/testfile.txt");
            Scanner myScanner = new Scanner(myText);
            while(myScanner.hasNext()) 
                myStr += myScanner.next();
            System.out.println(myStr);
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or can't read");
            e.printStackTrace();
        }
    }
}
