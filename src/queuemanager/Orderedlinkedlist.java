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
    
    private PriorityItem<T> top;
    
    public Orderedlinkedlist() {
        top = null;
        
    }
    
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return top.getItem();
    }
    
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        top = top.getPriority();
    }
    
    @Override
    public void add(T item) {
        top = new PriorityItem<>(item, top);
    }
    
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
        for (PriorityItem<T> node = top; node != null; node = node.((PriorityItem<T>) storage[i]).getPriority()) {
            if (node != top) {
                result += ", ";
            }
            result += node.getItem();
        }
        result += "], isEmpty() = " + isEmpty();
        if (!isEmpty()) {
            result += ", top() = " + head();
        }
        return result;
    }
    
    private int size() {
        PriorityItem<T> node = top;
        int result = 0;
        while (node != null) {
            result = result + 1;
            node = node.getItem();
        }
        return result;
    }
}
