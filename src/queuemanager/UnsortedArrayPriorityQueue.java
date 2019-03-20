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

    @Override
    public T head() throws QueueUnderflowException {
       
        T item = null;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
               for (int i = 0; i < capacity; i++) {
                if(storage[i] == null){
                break;
                }else{
                int gPriority =  ((PriorityItem<T>) storage[i]).getPriority();
                T titem =  ((PriorityItem<T>) storage[i]).getItem(); 
                int p=0;
                  if( tailIndex < gPriority){
                    tailIndex = gPriority;
                            
                  item = titem;
                  
                    } 
                     
                }
            }
            
            
           
        }
         return item;
    }

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
        
            storage[i] = new PriorityItem<>(item, priority);
        }
    }

      @Override
    public void remove() throws QueueUnderflowException {
       int hv=0;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else { 
       
            for (int i = 0; i <= capacity; i++) {
                 if(storage[i] != null){
           
                 hv =  ((PriorityItem<T>) storage[i]).getPriority(); 
                 
                 
               if(pitem < hv){
                     pitem = hv;
                 }
                
                   
    
               if(tailIndex <= pitem){       
                        storage[i] = storage[i + 1];                              
                }
                 
               
                 }else{
              break;
                 }
               
                } tailIndex = tailIndex - 1; 
               
            }          
        }
      
    

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
         
        for (int i = 0; i <= tailIndex; i++) {
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
