/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dal.DBWrapper;
import model.Reader;
import structure.MyList;

/**
 *
 * @author GHC
 */
public class ReaderBO {
    
    public void readFileReader(){
        DBWrapper.db.readFileReader();
    } 
    
    public void writeFileReader(){
        DBWrapper.db.writeFileReader();
    }
    
    public void add(String rcode, String name, int byear){
        Reader r = new Reader(rcode, name, byear);
        DBWrapper.db.addReader(r);
    }
    
    public boolean checkExist(String code){
        return DBWrapper.db.checkExistReader(code);
    }
    
    public void data(){
        MyList<Reader> list = DBWrapper.db.getListR();
        if(list.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        System.out.printf("%5s|%8s|%7s\n", "Code", "Name", "Byear");
        System.out.println("----------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%5s|%8s|%7d\n", list.get(i).getRcode(),
                    list.get(i).getName(), list.get(i).getByear());
        }
    }
    
    public void getReader(String Rcode){
        Reader r = DBWrapper.db.getReader(Rcode);
        if(r == null){
            System.out.println("Rcode not exist!!");
        }else{
            r.print();
        }
    }
    
    public void deleteReader(String code){
        DBWrapper.db.deleteReader(code);
    }
}
