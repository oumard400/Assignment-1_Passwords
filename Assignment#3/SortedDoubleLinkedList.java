package LinkedList;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Oumar Diallo
 * @param <T> data type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
   
    
    //Comparator interface to sort the doubly-linked list  
    protected Comparator<T> comparator = null;
        
    /**
     * 
     * @param comparator sorting tool 
     */
    public SortedDoubleLinkedList(Comparator<T> comparator2) {
       this.comparator = comparator2;
    }
    
    /**
     *
     * @param data data to be entered
     * @return instance of sorted doubly-linked list
     */
    public SortedDoubleLinkedList<T> add(T data) {
    	
        Node newNode = new Node(data);
        
        if (size == 0) {
            first = last = newNode;
        } 
        else if (comparator.compare(first.data, data) > 0) {
        	
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        } 
        else if (comparator.compare(last.data, data) < 0) {
        	
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        } 
        else {
            Node search = first;
            
            while (search != null) {
            	
                if (comparator.compare(search.data, data) <= 0) {
                	
                    Node before = search;
                    Node after = search.next;
                    after.previous = before.next = newNode;
                    newNode.next = after;
                    newNode.previous = before;   
                }
                search = search.next;
            }
        }   
        size++;
        return this;
    }
    
    /**
     * 
     * @param data data to be inserted at the end of list
     * @return instance of doubly-linked list
     */    
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
    	
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    /**
     * 
     * @param data data to be inserted at the beginning of list
     * @return instance of doubly-linked list
     */
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
    	
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    /**
     *
     * @return Instance of iterator inner class in basic doubly-linked list
     * @throws UnsupportedOperationException method has not been implemented yet
     * @throws NoSuchElementException element does not exist
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
    	
        return super.iterator();
    }
 
    /**
   	 *
     * @param data data to be deleted in list
     * @param comparator interface to compare data of elements
     * @return instance of sorted doubly-linked list
     */
    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
    	
        super.remove(data, comparator);
        return this;
    }   
}

