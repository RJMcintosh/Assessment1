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
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T>  {
       /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    
    private int pitem;
    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
//Head is used to find the highest value
    @Override
    public T head() throws QueueUnderflowException {
       
        T item = null;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            //loops through the capacity of the array
               for (int i = 0; i < capacity; i++) {
                   //if any null values in the storage it will do a break 
                if(storage[i] == null){
                break;
                //if no null values then fines the highest vaule
                }else{
                    //gets priority
                int gPriority =  ((PriorityItem<T>) storage[i]).getPriority();
                //gets the object getitem and stores in node titem
                T titem =  ((PriorityItem<T>) storage[i]).getItem(); 
               //does if statement, looks if priority is left than tailIndex
                  if( tailIndex < gPriority){
                      //If item is less than then sets tailindex to priority
                    tailIndex = gPriority;
                        //Sets item to titem    
                  item = titem;
                  
                    } 
                     
                }
            }
     
        }
        //returns the highest value
         return item;
    }
    //Used to add the object into the array 
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
        //adds the object into the array called storage
            storage[i] = new PriorityItem<>(item, priority);
        }
    }
    //Used to remove an object
      @Override
    public void remove() throws QueueUnderflowException {
        //creates a varible called hv which value is set to 0
       int hv=0;
       //sees if any array is empty if it is it will throw a QueueUnderflowException
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else { 
                //fixed loop to loop through the capacity untill its equal to or less than the i value
            for (int i = 0; i <= capacity; i++) {
                //checks if any null values are present and breaks if there is
                 if(storage[i] != null){
           //gets the priority and sets the hv varible to the result
                 hv =  ((PriorityItem<T>) storage[i]).getPriority(); 
                 
                 //does an if statement to check if the priority item is less than hv
               if(pitem < hv){
                   //if it is less than then sets the priority item to the hv value 
                     pitem = hv;
                 }
                
                   
                    //if the tailIndex is less than or equal to priority item then does the following
               if(tailIndex <= pitem){       
                   //adds one to the storage so moves the objects left by 1
                        storage[i] = storage[i + 1];                              
                }
                 
               
                 }else{
              break;
                 }
               //removes 1 to the tailIndex
                } tailIndex = tailIndex - 1; 
               
            }          
        }
      
    
//checks if its empty
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    //Displays the values  
    @Override
    public String toString() {
        String result = "[";
         //loops through the tailIndex
        for (int i = 0; i <= tailIndex; i++) {
            //checks if any null values are present
            if(storage[i] != null){
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        
        result = result + "]";
            }
         }
        return result;
    }
    
}
