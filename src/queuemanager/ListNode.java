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
public class ListNode<T> {
    private T item;
    public ListNode<T> next;
    public int priority;
    public ListNode(T item, int priority, ListNode<T> next) {
        this.item = item;
        this.priority = priority;
        this.next = next;
    }
    
    public T getItem() {
        return item;
    }
    
    public ListNode<T> getNext() {
        return next;
    }
}
