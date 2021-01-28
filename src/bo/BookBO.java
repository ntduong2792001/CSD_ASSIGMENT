/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dal.DBContext;
import dal.DBWrapper;
import model.Book;
import structure.MyList;

/**
 *
 * @author GHC
 */
public class BookBO {
        
    public void readFileBook(){
        DBWrapper.db.readFileBook();
    }
    
    public void writeFileBook(){
        DBWrapper.db.writeFileBook();
    }
    
    public boolean checkExist(String code){
        return DBWrapper.db.checkExistBook(code);
    }
            
    
    public void add(String bcode, String title, int quantity, int lended, double price){
        Book b = new Book(bcode, title, quantity, lended, price);
        DBWrapper.db.addBook(b);
    }
    
    public void addFirst(String bcode, String title, int quantity, int lended, double price){
        Book b = new Book(bcode, title, quantity, lended, price);
        DBWrapper.db.addBookFirst(b);
    }
    
    public void addIndex(String bcode, String title, int quantity, int lended, double price, int index){
        Book b = new Book(bcode, title, quantity, lended, price);
        DBWrapper.db.addBookIndex(b, index);
    }
    
    public void data(){
        MyList <Book> list = DBWrapper.db.getListB();
        if(list.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        System.out.printf("%5s|%11s|%10s|%8s|%8s|%8s\n",
                "code", "Title", "Quantity", "Lended", "Price", "Value");
        System.out.println("--------------------------------------------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%5s|%11s|%10d|%8d|%8.2f|%8.2f\n",
            list.get(i).getBcode(), list.get(i).getTitle(), list.get(i).getQuantity(),
            list.get(i).getLended(), list.get(i).getPrice(), list.get(i).value());
        }
    }
    
    public void getBook(String bcode){
        Book b = DBWrapper.db.getBook(bcode);
        if(b == null){
            System.out.println("Bcode not exist!!");
        }else{
            b.print();
        }
    }
    
    public void deleteBook(String code){
        DBWrapper.db.deleteBook(code);
    }
    
    public void deleteBookIndex(int index){
        DBWrapper.db.deleteBookPos(index);
    }
    
    public void sortByBcode(){
        DBWrapper.db.sortByBcode();
    }
}
