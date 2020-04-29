/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import java.util.Collection;
import java.util.ArrayList;
/**
 *
 * @author vuaphapthuat410
 */
public class TestMediaCompareTo {
    public static void main(String[] args) {
        Collection<DigitalVideoDisc> collection = new ArrayList<DigitalVideoDisc>();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", 87, "The Lion King", "Animation", 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Geogre Lucas", 124, "Star Wars", "Science Fiction", 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", 90, "Aladdin", "Animation", 18.99f);
        CompactDisc cd1 = new CompactDisc("Unknown", "IBM Symphony","music", 10f);
        //playDVD
        dvd1.play();
        dvd2.play();
        dvd3.play();
        cd1.play();
        //Add the DVD objects to the ArrayList
        collection.add(dvd2);
        collection.add(dvd1);
        collection.add(dvd3);
        
        //Iterate through the ArrayList and output thier titles (unsorted order)
        java.util.Iterator iterator = collection.iterator();
        
        System.out.println("-------------------------------------");
        System.out.println("The DVDs currently in the order are: ");
        
        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
        //Sort the collection of DVDs - based on the compareTo() method
        java.util.Collections.sort((java.util.List)collection);
        
        //Iterate through the ArrayList and output their titles in sorted order
        iterator = collection.iterator();
        
        System.out.println("-------------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        
        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
        
        System.out.println("--------------------------------------");
    }
}
