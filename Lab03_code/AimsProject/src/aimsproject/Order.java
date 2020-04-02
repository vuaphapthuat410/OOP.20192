/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;

/**
 *
 * @author vuaphapthuat410
 */
public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private int qtyOrdered = 0;
    private float ttCost;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            this.itemsOrdered[this.qtyOrdered++] = disc;
            System.out.printf("The disc %s has been added.\n",disc.getTitle());
        }
        else System.out.println("The order is almost full.");
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered > 0 ){
            for(int i=0; i<qtyOrdered; i++){
                if(itemsOrdered[i] == disc) 
                {
                    for(int j=i; j<qtyOrdered-1; j++)
                        itemsOrdered[j] = itemsOrdered[j+1];
                    itemsOrdered[--qtyOrdered] = null;
                    break;
                }
            }
            System.out.printf("The disc %s has been removed.\n",disc.getTitle());
        }
        else System.out.println("The order is almost empty.");
    }
    
    public float totalCost() {
        ttCost = 0;
        for(int i = 0; i < qtyOrdered; i++){
            ttCost += itemsOrdered[i].getCost(); //this function can create precision number that affect the last result.
        }
        return ttCost;
    }
}
