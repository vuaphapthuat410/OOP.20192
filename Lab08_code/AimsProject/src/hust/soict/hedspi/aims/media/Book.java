/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author vuaphapthuat410
 */
public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();
    private String content;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();
    
    public Book() {
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public Book(String title, String category, ArrayList<String> authors) {
        super(title, category);
        this.authors = authors;
        //TODO: check author contition
    }
    
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    
    public void setId() {
        this.id = this.hashCode(); 
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void addAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) 
            if(authors.get(i).equals(authorName)) {
                System.out.println("Duplicated name.");
                return;
            }
        authors.add(authorName);
    }
    
    public void removeAuthor(String authorName) {
        for (int i = 0; i< authors.size(); i++)
            if(authors.get(i).equals(authorName)) {
                authors.remove(i);
                System.out.println("Name has been deleted.");
                return;
            }
    }
    
    public static Book getBook() {
        Scanner keyboard = new Scanner(System.in);
        String temp;
        String titleTemp,categoryTemp;
        float costTemp = 0;
        System.out.println("Enter the title:  ");
            //newBook.setTitle(keyboard.nextLine());
            titleTemp = keyboard.nextLine();

        System.out.println("Enter the category: ");
            //newBook.setCategory(keyboard.nextLine());
            categoryTemp = keyboard.nextLine();

        System.out.println("Enter the price: ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                //newBook.setCost(Float.parseFloat(temp));
                    costTemp = Float.parseFloat(temp);
                if(costTemp < 0) costTemp = 0; //not accept negative value
            } catch (NumberFormatException e) {
                System.err.println("Error occurs.");
            }
           
        Book newBook = new Book(titleTemp, categoryTemp, costTemp);
        newBook.setId();
        
        do {            
                System.out.println("Enter the author name (enter to skip): ");
                temp = keyboard.nextLine();
                if(!temp.isEmpty())
                    newBook.addAuthor(temp);
                else 
                    return newBook;  
        } while (true);
    }
    
    @Override
    public void print() {
        StringBuilder authorsList = new StringBuilder();
        if(!authors.isEmpty()) {
            authorsList.append(authors.get(0));
            for(int i = 1; i < authors.size(); i++) {
                authorsList.append(",");
                authorsList.append(authors.get(i));
            }        
        }
        System.out.printf("ID: " + getId() + " - Book - " + getTitle() + " - " + getCategory() + " - " + authorsList + " : %.2f $\n", getCost());
        
    }
    
    public void processContent() {
        int n;
        int count  = 1;
        String[] tempStr = content.split("[\\p{Punct}\\s]+", 0); //hard to understand regex here
        for(String tmp : tempStr)
            if(!tmp.isEmpty())
                contentTokens.add(tmp);
        Collections.sort(contentTokens);
        n = contentTokens.size();
        if(contentTokens.isEmpty()) {
            System.out.println("No content.");
            return;
        }
        if(n == 1) {
            wordFrequency.put(contentTokens.get(0), 1);
            return;
        }
        for(int i = 1; i < n ; i++) {
            if(!contentTokens.get(i-1).equals(contentTokens.get(i))) {
                wordFrequency.put(contentTokens.get(i-1), count);
                count = 1;
            }
            else if(i == n - 1) {// check last element.
                wordFrequency.put(contentTokens.get(i), count + 1);
            }
            count++;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String temp;
        temp = Integer.toString(id) + "\n" + title + "\n" + category + "\n" + Float.toString(cost) + "\n";
        str.append(temp);
        str.append(content);
        temp = ("\n" + contentTokens.size() + " word.\n");
        str.append(temp);
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            temp = "[" + entry.getKey() + "," + entry.getValue() + "]" + "\n";
            str.append(temp);
        }
        
        return str.toString();
    }
}
