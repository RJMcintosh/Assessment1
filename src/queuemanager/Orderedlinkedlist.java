/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Rossspc
 */

    
public class Orderedlinkedlist<T> implements PriorityQueue<T> {

    private ListNode<T> head;


  
    public Orderedlinkedlist() {
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
    public void add(T item, int priority) throws QueueOverflowException{
          ListNode Prv=head;
          ListNode Cur=head;
          ListNode newnode = new ListNode<T>(item, priority, head);
      
        if(head == null || head.priority>priority){
            newnode.next = head;
	head = newnode;
	
            }else{
     while(Cur!=null && Cur.priority<priority){
                 Prv = Cur;  
                 Cur = Cur.next;
            
      
        }
       Prv.next=newnode;
       newnode.next=Cur;
      
      
    }

    } 
        
        /*
             tailIndex = tailIndex + 1;
        if (tailIndex >= result) {
  
            tailIndex = tailIndex - 1;
           
        } else {
          
          
            int i = tailIndex;
            while (head != null ) {
               if(head.result > result){
                   head = head.getNext();
               }else{
               
               }
            }
           
        }*/
    
    
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
