/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

/**
 *
 * @author vuaphapthuat410
 */
public abstract class Media implements Comparable {     //need change to generic class like slides
    protected String title;
    protected String category;
    protected float cost;
    protected int id;
    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }
    
    public int getId() {
        return id;
    }
    
    public abstract void print();
    
    @Override
    public int hashCode() {
        return title.hashCode() + category.hashCode() + (int)cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) { //alternative for obj instanceof media
            return false;
        }
        final Media other = (Media) obj;
        return this.getId() == other.getId(); //check id, if equal -> same obj
    }
    
    @Override
    public int compareTo(Object obj) { //need to check this and obj != null before compare 
        if (getClass() != obj.getClass()) { 
            throw new ClassCastException("Not a media type.");
        }
        final Media other = (Media) obj;
        return this.getTitle().compareTo(other.getTitle());
    }
}