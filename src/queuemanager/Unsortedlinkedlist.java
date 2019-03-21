/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author 16001551
 */

public class Unsortedlinkedlist<T> implements PriorityQueue<T> {

    private ListNode<T> head;
    
  
    public Unsortedlinkedlist() {
        head = null;
        
    }
      
       
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            
        }
        return head.getItem();
    }
  
    
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        head = head.getNext();
    }
    
    @Override
    public void add(T item,int priority) {
         head = new ListNode<>(item, priority, null);
    }
    
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
        for (ListNode<T> node = head; node != null; node = node.getNext()) {
            if (node != head) {
                result += ", ";
            }
            result += node.getItem();
        }
        result += "], isEmpty() = " + isEmpty();
        if (!isEmpty()) {
           // result += ", head() = " + head();
        }
        return result;
    }
    
    private int size() {
        ListNode<T> node = head;
        int result = 0;
        while (node != null) {
            result = result + 1;
            node = node.getNext();
        }
        return result; 
    }

   
}

