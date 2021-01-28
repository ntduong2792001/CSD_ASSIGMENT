/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.BookGUI;
import gui.LendingGUI;
import gui.MainGUI;
import gui.ReaderGUI;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author GHC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainGUI mg = new MainGUI();
        ReaderGUI rg = new ReaderGUI();
        BookGUI bg = new BookGUI();
        LendingGUI lg = new LendingGUI();
        Scanner sc = new Scanner(System.in);
        String choice = null;
        do{
            mg.displayAdvertise();
            choice = sc.nextLine();
            switch(choice){
                case "1.1": bg.readFile(); break;
                case "1.2": bg.add(); break;
                case "1.3": bg.displayData(); break;
                case "1.4": bg.writeFile(); break;
                case "1.5": bg.searchByCode(); break;
                case "1.6": bg.deleteBook(); break;
                case "1.7": bg.sortByBcode(); break;
                case "1.8": bg.addFirst(); break;
                case "1.9": bg.addIndex(); break;
                case "1.10": bg.deleteBookIndex(); break;
                case "2.1": rg.readFileReader(); break;
                case "2.2": rg.add(); break;
                case "2.3": rg.displayData(); break;
                case "2.4": rg.writeFileReader(); break;
                case "2.5": rg.searchByCode(); break;
                case "2.6": rg.deleteByCode(); break;
                case "3.1": lg.add(); break;
                case "3.2": lg.displayData(); break;
                case "3.3": lg.sort(); break;
            }
        }while(!choice.equals("0"));
        
    }
    
}
