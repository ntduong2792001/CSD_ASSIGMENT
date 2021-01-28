/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.Lending;
import model.Reader;
import structure.MyList;

/**
 *
 * @author GHC
 */
public class DBContext {
    private MyList<Book> listB = new MyList<>();
    private MyList<Reader> listR = new MyList<>();
    private MyList<Lending> listL = new MyList<>();
    private File fileB = new File("data\\Book");
    private File fileR = new File("data\\Reader");
    
    public MyList<Book> getListB() {
        return listB;
    }

    public void setListB(MyList<Book> listB) {
        this.listB = listB;
    }

    public MyList<Reader> getListR() {
        return listR;
    }

    public void setListR(MyList<Reader> listR) {
        this.listR = listR;
    }

    public MyList<Lending> getListL() {
        return listL;
    }

    public void setListL(MyList<Lending> listL) {
        this.listL = listL;
    }

    public void readFileBook(){
        FileReader reader = null;
        try{
            reader = new FileReader(fileB);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine().trim();
            while(line != null){
                String[] parts = line.split(",");
                String bcode = parts[0];
                String title = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int lended = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                Book b = new Book(bcode, title, quantity, lended, price);
                addBook(b);
                line = buffer.readLine();
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void readFileReader(){
        FileReader reader = null;
        try{
            reader = new FileReader(fileR);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine().trim();
            while(line != null){
                String[] parts = line.split(",");
                String rcode = parts[0];
                String name = parts[1];
                int byear = Integer.parseInt(parts[2]);
                Reader r = new Reader(rcode, name, byear);
                addReader(r);
                line = buffer.readLine();
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void writeFileBook(){
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileB, false);
            for(int i = 0; i < listB.size(); i++){
                writer.write(listB.get(i).toString()+"\n");
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void writeFileReader(){
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileR, false);
            for(int i = 0; i < listR.size(); i++){
                writer.write(listR.get(i).toString()+"\n");
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
    public Book getBook(String bcode){
        for(int i = 0; i < listB.size(); i++){
            if(listB.get(i).getBcode().equals(bcode)){
                return listB.get(i);
            }
        }
        return null;
    }
    
    public boolean checkExistBook(String code){
        for(int i = 0; i < listB.size(); i++){
            if(listB.get(i).getBcode().equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public void addBookFirst(Book b){
        listB.addFirst(b);
        System.out.println("Add success!");
    }
    
    public void addBook(Book b){
        if(b.getQuantity() < b.getLended()){
            System.out.println("Add fail!");
            return;
        }
        for(int i = 0; i < listB.size(); i++){
            if(listB.get(i).equals(b.getBcode())){
                System.out.println("Add fail!");
                return;
            }
        }
        listB.addLast(b);
        System.out.println("Add success!");
    }
    
    public void addBookIndex(Book b, int index){
        if(index > listB.size()){
            System.out.println("Index should be smaller or equal the size of the list!");
        }else{
            listB.addIndex(b, index);
            System.out.println("Add success!");
        }
    }
    
    public void deleteBook(String code){
        for(int i = 0; i < listB.size(); i++){
            if(listB.get(i).getBcode().equals(code)){
                listB.delIndex(i);
                System.out.println("Delete Success!");
                return;
            }
        }
        System.out.println("Book not found!!");
    }
    
    public void deleteBookPos(int index){
        if(index >= listB.size()){
            System.out.println("Index should be smaller than the size of the list!");
        }else{
            listB.delIndex(index);
            System.out.println("Delete Success!");
        }
    }
    
    public void sortByBcode(){
        for(int i = 0; i < listB.size() - 1; i++){
            for(int j = i + 1; j < listB.size(); j++){
                if(listB.get(i).getBcode().compareTo(listB.get(j).getBcode()) > 0){
                    Book temp = listB.get(i);
                    listB.set(i, listB.get(j));
                    listB.set(j, temp);
                }
            }
        }
        System.out.println("Sort success!!");
    }
    
    public void addReader(Reader r){
        if(r.getByear() < 1900 || r.getByear() > 2010){
            System.out.println("Add fail!");
            return;
        }
        for(int i = 0; i < listR.size(); i++){
            if(listR.get(i).getRcode().equals(r.getRcode())){
                System.out.println("Add fail!");
                return;
            }
        }
        listR.addLast(r);
        System.out.println("Add success!");
    }
    
    public boolean checkExistReader(String code){
        for(int i = 0; i < listR.size(); i++){
            if(listR.get(i).getRcode().equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public Reader getReader(String Rcode){
        for(int i = 0; i < listR.size(); i++){
            if(listR.get(i).getRcode().equals(Rcode)){
                return listR.get(i);
            }
        }
        return null;
    }
    
    public void deleteReader(String code){
        for(int i = 0; i < listR.size(); i++){
            if(listR.get(i).getRcode().equals(code)){
                listR.delIndex(i);
                System.out.println("Delete Success!");
                return;
            }
        }
        System.out.println("Reader not found!!");
    }
    
    public int checkExistLending(String bcode, String rcode){
        for(int i = 0; i < listL.size(); i++){
            if(listL.get(i).getBcode().equals(bcode) && listL.get(i).getRcode().equals(rcode)){
                return listL.get(i).getState();
            }
        }   
        return -1;   
    }
    
    public void addLending(Lending l){
        listL.addLast(l);
        System.out.println("Add success");
    }
    
    //update lended + 1
    public void updateLended(String bcode){
        for(int i = 0; i < listB.size(); i++){
            if(listB.get(i).getBcode().equals(bcode)){
                Book b = listB.get(i);
                listB.set(i, new Book(b.getBcode(), b.getTitle(), 
                b.getQuantity(), b.getLended()+1, b.getPrice()));
            }
        }
    }
    
    public void sortLending(){
        for(int i = 0; i < listL.size() - 1; i++){
            for(int j = i + 1; j < listL.size(); j++){
                if(listL.get(i).getBcode().compareTo(listL.get(j).getBcode()) > 0){
                    Lending temp = listL.get(i);
                    listL.set(i, listL.get(j));
                    listL.set(j, temp);
                }else if(listL.get(i).getBcode().compareTo(listL.get(j).getBcode()) == 0){
                    if(listL.get(i).getRcode().compareTo(listL.get(j).getRcode()) > 0){
                        Lending temp = listL.get(i);
                    listL.set(i, listL.get(j));
                    listL.set(j, temp);
                    }
                }
            }
        }
    }
}
