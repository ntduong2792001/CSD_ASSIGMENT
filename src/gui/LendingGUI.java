/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.LendingBO;

/**
 *
 * @author GHC
 */
public class LendingGUI {
    LendingBO bo = new LendingBO();
    public void add(){
        System.out.print("Enter Bcode: ");
        String bcode = CheckInput.enterCode();
        System.out.print("Enter Rcode: ");
        String rcode = CheckInput.enterCode();
        bo.add(bcode, rcode);
    }
    
    public void displayData(){
        bo.data();
    }
    
    public void sort(){
        bo.sort();
    }
}
