/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;
import static hust.soict.hedspi.aims.order.Order.MAX_LIMITTED_ORDERS;
import java.util.Scanner;

/**
 *
 * @author vuaphapthuat410
 */
public class Aims {
    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("________________________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("________________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void main(String[] args) {
        int choice;
        int n = 0;
        int orderId;
        int itemId;
        Scanner keyboard = new Scanner(System.in);
        Order[] orderList = new Order[Order.MAX_LIMITTED_ORDERS];
        do {            
            showMenu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch(choice) {
                case 1: 
                    orderList[n++] = Order.getInstanceOrder();
                    break;
                case 2:
                    do {            
                        System.out.println("Choose order id: ");
                        Order.listOrder();
                        orderId = Integer.parseInt(keyboard.nextLine());
                    } while (orderId < 1 || orderId > Order.size());
                    
                    orderList[orderId-1].addMedia(); //cuz print id is real id + 1
                    break;
                case 3:
                    do {            
                        System.out.println("Choose order id: ");
                        Order.listOrder();
                        orderId = Integer.parseInt(keyboard.nextLine());
                    } while (orderId < 1 || orderId > Order.size() );
                    
                    orderList[orderId-1].printOrder();
                    
                    do {
                        System.out.println("Choose the item you want to delete: ");
                        itemId = Integer.parseInt(keyboard.nextLine());
                    } while(itemId < 1 || itemId > orderList[orderId-1].listSize());
                    
                    orderList[orderId-1].removeMedia(itemId-1); //cuz id count from 1 but array index from 0
                    break;
                case 4:
                    do {            
                        System.out.println("Choose order id: ");
                        Order.listOrder();
                        orderId = Integer.parseInt(keyboard.nextLine());
                    } while (orderId < 1 || orderId > Order.size() );
                    
                    orderList[orderId-1].printOrder();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        
    }
}
