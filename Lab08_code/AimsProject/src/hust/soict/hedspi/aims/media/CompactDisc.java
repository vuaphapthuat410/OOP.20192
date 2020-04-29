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
import java.util.ArrayList;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        this.length = 0;
    }
    
    public CompactDisc(String artist) {
        this.artist = artist;
        this.length = 0;
    }

    public CompactDisc(String artist, String title) {
        super(title);
        this.artist = artist;
        this.length = 0;
    }

    public CompactDisc(String artist, String title, String category) {
        super(title, category);
        this.artist = artist;
        this.length = 0;
    }

    public CompactDisc(String artist, String title, String category, float cost) {
        super(title, category, cost);
        this.artist = artist;
        this.length = 0;
    }
    
    public String getArtist() {
        return artist;
    }
    
    @Override
    public int getLength() {
        return length;
    }
    
    public void setId() {
        this.id = this.hashCode() + artist.hashCode();
    }
    
    public void addTrack(Track track) {
        for(int i = 0; i < tracks.size(); i++)
            if(tracks.get(i).equals(track)) {
                System.out.println("Duplicated track.");
                return;
            }
        
        tracks.add(track);
        this.length += track.getLength();
        System.out.println("Add track successful.");
    }
    
    public void removeTrack(Track track) {
        for(int i = 0; i < tracks.size(); i++)
            if(tracks.get(i).equals(track)) {
                this.length -= track.getLength();
                tracks.remove(track);
                System.out.println("Remove track successful.");
                return;
            }
        
        System.out.println("Track does not exist.");       
    }
    
    public int getNumberOfTrack() {
        return this.tracks.size();
    }
    
    public static CompactDisc getCD() {
        Scanner keyboard = new Scanner(System.in);
        String temp;
        String titleTemp,categoryTemp,artistTemp;
        float costTemp = 0;
        Track trackTemp ;
        System.out.println("Enter the title:  ");
            titleTemp = keyboard.nextLine();
            //newDisc.setTitle(keyboard.nextLine());

        System.out.println("Enter the category: ");
            categoryTemp = keyboard.nextLine();
            //newDisc.setCategory(keyboard.nextLine());

        System.out.println("Enter the price: ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                    costTemp = Float.parseFloat(temp);
                if(costTemp < 0) costTemp = 0;
                //newDisc.setCost(Float.parseFloat(temp));   
            } catch (NumberFormatException e) {
                    System.err.println("Error occurs.");
            }        
            
        System.out.println("Enter the artist name (enter to skip): ");
                artistTemp = keyboard.nextLine();
            
        CompactDisc newCD = new CompactDisc(artistTemp, titleTemp, categoryTemp, costTemp);
        newCD.setId();
        //from now will be track info
        do {            
                System.out.println("Do you want to add track(Y/n): ");
                temp = keyboard.nextLine();
                if(temp.equals("Y") || temp.equals("y")) {
                    trackTemp = Track.getTrack();
                    if(newCD.tracks.contains(trackTemp)) {
                        trackTemp = null;
                        System.out.println("Duplicated item. Please try again.");
                        continue;
                    }
                    newCD.addTrack(trackTemp);
                }
                else 
                    break;
        } while (true);
        
        System.out.println("Do you want to play CD(Y/n): ");
        temp = keyboard.nextLine();
        if(temp.equals("Y") || temp.equals("y")) 
            newCD.play();
              
        return newCD;
    }
    
    @Override
    public void print() {
        if(getCost() == 0)
                System.out.printf("ID: " + getId() + " - CD - " + getTitle() + " - " + getCategory() +
                    " - " + getArtist()+ " - %d: Free\n",getLength());
            else
                System.out.printf("ID: " + getId() + " - CD - " + getTitle() + " - " + getCategory() +
                    " - " + getArtist()+ " - %d: %.2f $\n",getLength(), getCost());
        if(tracks.isEmpty()) 
            System.out.println("No track.");
        else
            for(int i = 0; i< tracks.size(); i++)
                tracks.get(i).play();
    }
    
    @Override
    public void play() {
        System.out.println("Title: " + getTitle());
        System.out.println("Artist : " + getArtist());
        System.out.println("Length : " + getLength());
        if(tracks.isEmpty()) 
            System.out.println("No track.");
        else
            for(int i = 0; i< tracks.size(); i++)
                tracks.get(i).play();
    }
    
    @Override
    public int compareTo(Object obj) {
        if(getClass() != obj.getClass()) { // if not same type, upcasting to media to compare(rare to meet but careness is good)
            return ((Media)this).compareTo(obj);
        }
        final CompactDisc other = (CompactDisc) obj;
        if(this.getNumberOfTrack() > other.getNumberOfTrack())
            return 1;
        else if(this.getNumberOfTrack() < other.getNumberOfTrack())
            return -1;
        else {
            if(this.getLength() > other.getLength())
                return 1;
            else if(this.getLength() < other.getLength())
                return -1;
            else 
                return 0;
        }
    } 
}
