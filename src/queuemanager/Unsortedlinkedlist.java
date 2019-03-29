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
        priority =0;
        //Created a current node which is set to head
         ListNode<T> Cur=head;
         //Created a item node which is set to null
          ListNode<T> item = null;
        if (isEmpty()) {
         throw new QueueUnderflowException();   
        }
         //does a for loop for amount of item that have been added 
           for (int i = 0; i <= counter; i++) {
                 //checks if there is any null values in Cur
                 if(Cur == null){ 
                   //breaks if there is any nulls to stop the program form crashing
                break;
                //if no nulls then does this else
                }else{   
                     
         //if current priority is less than the priority value 
             if(priority <= Cur.priority ){
               
             
                   
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
       int ifind = 1;
        int index=0;
        
       
        if (isEmpty()) {
         throw new QueueUnderflowException(); 
        //Checks if the head priority is the same as the priority item 
        }else if(head.priority == priority){
        //if it is it removes the head
        head = head.getNext(); 
       
        }else{
          
        int rcount=1;
        /*does a for loop for amount of items that have been added, 
        creates a listnode called node which then goes through to find
        the highest priority
        */
       for (ListNode<T> node = head; node != null; node = node.getNext(),ifind++) { 
             
              if(node.priority == priority){
               //if it is it removes the head
              index = ifind; 
                 }                            
             }
       //goes through the index to get the previous item
             while(rcount<index-1){
              
                      //sets the previous node to previous item
                     Prv=Prv.next;
                     rcount++;
                }  
                               
            //Creates a node varible called Cur and chages the vaule to the head
            ListNode<T> Cur = Prv.next;
            //Sets the previous node to the current node
            Prv.next = Cur.next;
            //sets the current value to null
            Cur.next = null;
   
  
        }
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
        String result = "Unsortedlinkedlist: size = " + size();
        result += "[";
        for (ListNode<T> node = head; node != null; node = node.getNext()) {
            if (node != head && node != null) {
                result += ", ";
            }
            result += "(";
            result += node.getItem();
            result += ", ";
            result += node.priority;
         result += ")";
        }
       
        if (!isEmpty()) {
           // result += ", head() = " + head();
        }   
        result += "]";
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

