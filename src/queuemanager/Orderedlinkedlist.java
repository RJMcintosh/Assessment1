/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Rossspc
 * Used this for some help for adding https://github.com/gautham20/geeksforgeeks/blob/master/linked_list/insertSorted.java
 */

    
public class Orderedlinkedlist<T> implements PriorityQueue<T> {
//creates a private listnode called head
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
        //gets the head 
        head = head.getNext();
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException{
        //Created a listnode called Prv which stores the head which is the previous value 
          ListNode Prv=head;
        //Created a listnode called Cur which stores the head which is the current value
          ListNode Cur=head;
          //Created a listnode called newnode which stores the item,priority and the head
          ListNode newnode = new ListNode<T>(item, priority, head);
      //if head is null or less than or equal to priority
        if(head == null || head.priority<=priority){
            //sets newnode.next to the head
            newnode.next = head;
            //changes the head to newnode
	head = newnode;
	//if head is not null or less than or equal to priority
            }else{
            //a while loop is used to loop through till the Cur is not null and the cur priority is above the priority
     while(Cur!=null && Cur.priority>priority){
         //Changes the Prv to Cur
                 Prv = Cur;  
                 //Changes the Cur to Curwhich calls next to get next item
                 Cur = Cur.next;
            
      
        }
     //Changes the previous value to newnode
       Prv.next=newnode;
     //Changes the newnode to Current value
       newnode.next=Cur;
      
      
    }

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
