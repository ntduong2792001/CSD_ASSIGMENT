/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.ReaderBO;

/**
 *
 * @author GHC
 */
public class ReaderGUI {
    ReaderBO bo = new ReaderBO();
    public void readFileReader(){
        bo.readFileReader();
    }
    
    public void writeFileReader(){
        bo.writeFileReader();
    }
    
    public void add(){
        System.out.print("Enter rcode: ");
        String rcode = CheckInput.enterCode();
        System.out.print("Enter name: ");
        String name = CheckInput.enterName();
        System.out.print("Enter byear: ");
        int byear = CheckInput.enterByear();
        if(bo.checkExist(rcode)){
            System.out.println("Reader already exist!");
        }else{
            bo.add(rcode, name, byear);
        }
    }
    
    public void displayData(){
        bo.data();
    }
    
    public void searchByCode(){
        System.out.print("Enter Rcode: ");
        String rcode = CheckInput.enterCode();
        bo.getReader(rcode);
    }
    
    public void deleteByCode(){
        System.out.print("Enter Rcode: ");
        String rcode = CheckInput.enterCode();
        bo.deleteReader(rcode);
    }
}
