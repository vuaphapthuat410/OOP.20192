/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

/**
 *
 * @author vuaphapthuat410
 */
public class BookTest {
    public static void main(String[] args) {
        Book tempBook = new Book("Fuck this shiet i'm out", "adult", 10);
        tempBook.addAuthor("Manh");
        tempBook.addAuthor("A fuck guy");
        tempBook.addAuthor("Gay guy");
        tempBook.setContent("Hello, it's me\n"
                + "I was wondering if after all these years you'd like to meet\n"
                + "To go over everything\n"
                + "They say that time's supposed to heal ya, but I ain't done much healing\n"
                + "Hello, can you hear me?\n"
                + "I'm in California dreaming about who we used to be\n"
                + "When we were younger and free\n"
                + "I've forgotten how it felt before the world fell at our feet");
        tempBook.processContent();
        System.out.println(tempBook.toString());
    }
}
