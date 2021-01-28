/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dal.DBWrapper;
import model.Book;
import model.Lending;
import structure.MyList;

/**
 *
 * @author GHC
 */
public class LendingBO {

    public void add(String bcode, String rcode){
        if(DBWrapper.db.checkExistBook(bcode) && DBWrapper.db.checkExistReader(rcode)){
            if(DBWrapper.db.checkExistLending(bcode, rcode) == -1){
                Book b = DBWrapper.db.getBook(bcode);
                if(b.getQuantity() == b.getLended()){
                    Lending l = new Lending(bcode, rcode, 0);
                    DBWrapper.db.addLending(l);
                }else{
                    Lending l = new Lending(bcode, rcode, 1);
                    DBWrapper.db.updateLended(bcode);
                    DBWrapper.db.addLending(l);
                }
            }else if(DBWrapper.db.checkExistLending(bcode, rcode) == 1){
                System.out.println("This reader borrowed this book");
            }
        }else{
            System.out.println("Book or Reader not found!");
        }
    }
    
    public void data(){
        MyList<Lending> list = DBWrapper.db.getListL();
        System.out.printf("%5s|%5s|%5s\n", "Bcode", "Rcode", "Status");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%5s|%5s|%5d\n", list.get(i).getBcode(), list.get(i).getRcode(), 
                    list.get(i).getState());
        }
    }
    
    public void sort(){
        DBWrapper.db.sortLending();
    }
    
}
