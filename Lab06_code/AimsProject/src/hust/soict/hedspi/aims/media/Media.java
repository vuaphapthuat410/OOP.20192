/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vuaphapthuat410
 */
public class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected int id;
    public Media() {
    }

    public Media(String title) {
        this.title = title;
        id = new Random().nextInt();
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        id = new Random().nextInt();
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        id = new Random().nextInt();
    }
    
    /*protected void getInstance() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the title:  ");
            this.title = keyboard.nextLine();

        System.out.println("Enter the category: ");
            this.category = keyboard.nextLine();

        System.out.println("Enter the price: ");
            String temp = keyboard.nextLine();
            if(!temp.isEmpty())
                this.cost = Float.parseFloat(temp);

        keyboard.close();
    }*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public int getId() {
        return id;
    }
    
    public void print() {
        System.out.printf("Title: %s.\nCategory: %s.\nCost: %s.\n");
    }
}
