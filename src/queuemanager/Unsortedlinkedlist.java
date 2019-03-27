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
    private int priority=0;
    private int counter=0;
    
  
    public Unsortedlinkedlist() {
        head = null;
        
    }
      
       
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        //Created a current node which is set to head
         ListNode<T> Cur=head;
         //Created a item node which is set to null
          ListNode<T> item = null;
        if (isEmpty()) {
         throw new QueueUnderflowException();   
        }
         //does a for loop for amount of item that have been added 
           for (int i = 0; i <= counter; i++) {
         //if current priority is less than the priority value 
             if(priority < Cur.priority){
                 //checks if there is any null values in Cur 
                if(Cur == null){
                    //breaks if there is
                break;
                //if no nulls then does this else
                }else{
                  //which sets item to current  
              item = Cur;   
              //also sets priority to the current priority
               priority=Cur.priority;
            }
                //calls current
            Cur = Cur.next;
          
          }
       }
             //returns item from the if statement done at line 51
      return item.getItem();
    }
  
    
    @Override
    public void remove() throws QueueUnderflowException{
             
        //Creates a node varible called Prv and chages the vaule to the head
        ListNode<T> Prv=head;
        //Creates a node varible called Cur and chages the vaule to the head
        ListNode<T> Cur = head;
       
        if (isEmpty()) {
         throw new QueueUnderflowException(); 
        //Checks if the head priority is the same as the priority item 
        }else if(head.priority == priority){
        //if it is it removes the head
        head = head.getNext(); 
        //else
        }
        //does a for loop for amount of item that have been added 
        for (int i = 0; i < counter; i++) {     
            //Checks if the Prv item is not null to stop it crashing 
                   if(Prv != null){
                      //If not null then sets previous to previous
                     Prv=Prv;
                    }else{
                       //if Prv is null then breaks
                       break;
                    }                        
             }
               
             //Sets the Current node to the Previous node
            Cur=Prv.next;
            //Sets the previous node to the current node
            Prv.next = Cur.next;
            //sets the current value to null
            Cur.next = null;
   
    }

    
    @Override
    public void add(T item,int priority) {
    //chnages the counter vaule of each item added, this is used to loop through the amount of items added for the head and remove
    counter = counter+1;
    //changes the head value to a new listnode
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

