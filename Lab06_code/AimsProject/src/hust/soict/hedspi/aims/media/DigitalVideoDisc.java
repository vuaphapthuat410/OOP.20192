/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author vuaphapthuat410
 */
public class DigitalVideoDisc extends Media{
    private String director;
    private int length;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }
    
    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    public static DigitalVideoDisc getDisc() {
        DigitalVideoDisc newDisc = new DigitalVideoDisc(); 
        Scanner keyboard = new Scanner(System.in);
        String temp;
        System.out.println("Enter the title:  ");
            newDisc.setTitle(keyboard.nextLine());

        System.out.println("Enter the category: ");
            newDisc.setCategory(keyboard.nextLine());

        System.out.println("Enter the price: ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                newDisc.setCost(Float.parseFloat(temp));   
            } catch (NumberFormatException e) {
                    System.err.println("Error occurs.");
            }        
            
        System.out.println("Enter the director name (enter to skip): ");
            temp = keyboard.nextLine();
            if(!temp.isEmpty())
                newDisc.setDirector(temp);

        System.out.println("Enter the lenght of disc (enter to skip): ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                newDisc.setLength(Integer.parseInt(temp));
            } catch (NumberFormatException e) {
                    System.err.println("Error occurs.");
            }
            
            
        return newDisc;
    }
    
    public boolean search(String title) {
        Scanner scanStr = new Scanner(title);
        String tmp;
        String lowerTitle = this.title.toLowerCase();
        while(scanStr.hasNext()) {
            tmp = scanStr.next().toLowerCase();
            if(!lowerTitle.contains(tmp))
                return false;
        }
        scanStr.close();
        
        return true;
    }
    
    @Override
    public void print() {
        if(getCost() == 0)
                System.out.printf("DVD - " + getTitle() + " - " + getCategory() +
                    " - " + getDirector() + " - %d: Free\n",getLength());
            else
                System.out.printf("DVD - " + getTitle() + " - " + getCategory() +
                    " - " + getDirector() + " - %d: %.2f $\n",getLength(), getCost());
    }
}
