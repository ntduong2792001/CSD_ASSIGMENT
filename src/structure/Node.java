/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

/**
 *
 * @author GHC
 */
public class Node <V>{
    V info;
    Node<V> next;

    public Node() {
    }

    public Node(V info) {
        this.info = info;
    }

    public Node(V info, Node next) {
        this.info = info;
        this.next = next;
    }
  
}
