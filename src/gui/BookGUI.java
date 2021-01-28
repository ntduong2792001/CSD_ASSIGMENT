/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.BookBO;
import java.util.Scanner;

/**
 *
 * @author GHC
 */
public class BookGUI {

    BookBO bo = new BookBO();

    public void readFile(){
        bo.readFileBook();
        System.out.println("Read data success!!");
    }
    
    public void add() {
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        System.out.print("Enter title: ");
        String name = CheckInput.enterName();
        System.out.print("Enter quantity: ");
        int quantity = CheckInput.enterQuantity();
        System.out.print("Enter lended: ");
        int lended = CheckInput.enterLended(quantity);
        System.out.print("Enter price: ");
        double price = CheckInput.enterPrice();
        if(bo.checkExist(bcode)){
            System.out.println("Bcode already exist!!");
        }else{
            bo.add(bcode, name, quantity, lended, price);
        }   
    }

    public void addFirst() {
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        System.out.print("Enter title: ");
        String name = CheckInput.enterName();
        System.out.print("Enter quantity: ");
        int quantity = CheckInput.enterQuantity();
        System.out.print("Enter lended: ");
        int lended = CheckInput.enterLended(quantity);
        System.out.print("Enter price: ");
        double price = CheckInput.enterPrice();
        if(bo.checkExist(bcode)){
            System.out.println("Bcode already exist!!");
        }else{
            bo.addFirst(bcode, name, quantity, lended, price);
        }  
    }
    
    public void addIndex(){
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        System.out.print("Enter title: ");
        String name = CheckInput.enterName();
        System.out.print("Enter quantity: ");
        int quantity = CheckInput.enterQuantity();
        System.out.print("Enter lended: ");
        int lended = CheckInput.enterLended(quantity);
        System.out.print("Enter price: ");
        double price = CheckInput.enterPrice();
        System.out.print("Enter index: ");
        int index = CheckInput.enterIndex();
        if(bo.checkExist(bcode)){
            System.out.println("Bcode already exist!!");
        }else{
            bo.addIndex(bcode, name, quantity, lended, price, index);
        }  
    }
    
    public void displayData() {
        bo.data();
    }

    public void writeFile(){
        bo.writeFileBook();
        System.out.println("Write success!");
    }
    
    public void searchByCode() {
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        bo.getBook(bcode);
    }
    
    public void deleteBook(){
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        bo.deleteBook(bcode);
    }
    
    public void deleteBookIndex(){
        System.out.print("Enter Index: ");
        int index = CheckInput.enterIndex();
        bo.deleteBookIndex(index);
        
    }
    
    public void sortByBcode(){
        bo.sortByBcode();
    }
}
