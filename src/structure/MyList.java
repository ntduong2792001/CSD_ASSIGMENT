/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.ArrayList;

/**
 *
 * @author GHC
 * @param <V>
 */
public class MyList <V>{
    Node <V> head, tail;
    int size = 0;

    public MyList() {
        head = tail;
    }

    //show linkedlist
    public void show() {
        if(isEmpty()){ 
            System.out.println("List is empty!");
        }
        else{
            Node p = head;
            while(p!= null){
                System.out.println(p.info + " ");
                p = p.next;
            }
        }
    }

    //check empty
    public boolean isEmpty() {
        return(head == null);
    }

    public void addLast(V i) {
        Node p = new Node(i);
        if(isEmpty()){
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
        size++;
    }

    public void addAll(ArrayList<V> arr) {
        for(int i = 0; i < arr.size(); i++){
            addLast(arr.get(i));
        }
    }

    public void addFirst(V i) {
        Node p = new Node(i);
        if(isEmpty()){
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
        size++;
    }

    public void delLast() {
        if(!isEmpty()){
            Node p = head;
            while(p.next.next != null){
                p = p.next;
            }
            tail = p;
            tail.next = null;
            size--;
        }
        
    }

    public void delFirst() {
        if(!isEmpty()){
             head = head.next;
             size--;
        }
        
    }

    public void addIndex(V x, int index) {
        Node p = head;
        int i = 0;
        if(i < 0){
            return;
        }
        if(index == 0){
            addFirst(x);
            return;
        }
        while(p != null){
            if(p.next == null && i == index - 1){
                addLast(x);
                return;
            }
            if(i == index - 1){
                Node n = new Node(x);
                n.next = p.next;
                p.next = n;
                size++;
                return;
            } else {
                p = p.next;
                i++;
            }
        }
        System.out.println("\nAdded fail!!");
    }

    public void delIndex(int index) {
        Node p = head;
        int i = 0;
        if(index < 0){
            System.out.println("Delete fail!");
            return;
        }
        //xoa dau
        if(index == 0){
            delFirst();
            return;
        }
        while(p != null){
            //xoa cuoi
            if(p.next == null && i == index - 1){
                delLast();
                return;
            }
            if(i == index - 1){
                p.next = p.next.next;
                size--;
                return;
            } else {
                p = p.next;
                i++;
            }
        }
        System.out.print("Delete fail!!");
    }
    
    public V get(int index){
        if(index >= size) return null;
        Node <V> p = head;
        int i = 0;
        while(p != null){
            if(i == index){
                return p.info;
            } else {
                p = p.next;
                i++;
            }
        }
        return null;
    }
    
    public void set(int index, V data){
        Node p = head;
        int i = 0;
        if(index < 0 || index >= size){
            return;
        }else{
            while(p != null){
                if(i == index){
                    p.info = data;
                    return;
                }else{
                    p = p.next;
                    i++;
                }
            }
        }
    }
    
    public int size(){
        return size;
    }
}
