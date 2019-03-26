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
    public int priority=0;
    public int counter=0;
    
  
    public Unsortedlinkedlist() {
        head = null;
        
    }
      
       
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
         ListNode<T> Cur=head;
          ListNode<T> item = null;
        if (isEmpty()) {
         throw new QueueUnderflowException();   
        }
           for (int i = 0; i <= counter; i++) {
         
             if(priority < Cur.priority){
                if(Cur == null){
                break;
                }else{
              item = Cur;   
               priority=Cur.priority;
            }
            Cur = Cur.next;
          
          }
       }
             
      return item.getItem();
    }
  
    
    @Override
    public void remove() throws QueueUnderflowException{
             
   
        ListNode<T> Prv=head;
        ListNode<T> Cur = head;
       
        if (isEmpty()) {
         throw new QueueUnderflowException();   
        }else if(head.priority == priority){
        head = head.getNext(); 
        }
         
        for (int i = 0; i < counter; i++) {             
                   if(Prv != null){
                     Prv=Prv;
                    }else{
                       break;
                    }                        
             }
                
            Cur=Prv.next;
            Prv.next = Cur.next;
            Cur.next = null;
   
    }

    
    @Override
    public void add(T item,int priority) {
        
    counter = counter+1;
    head = new ListNode<>(item, priority, head);
        
    }     

  
    
    
    
    
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
        for (ListNode<T> node = head; node != null; node = node.getNext()) {
            if (node != head && node != null) {
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

