package edu.iastate.coms3110.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryMinHeap<T> extends PurePriorityQueue<T> {
    private ArrayList<T> heap = new ArrayList<T>();
    /**
     * Key is the item, Value is the index in heap of the item
     */
    private HashMap<T, Integer> location = new HashMap<T, Integer>();

    public BinaryMinHeap(Comparator<T> comp) {
        super(comp);
    }

    /**
     * 
     *
     * @return The number of elements in the heap
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Adds an element to the heap.
     *
     * @param item An element not in the heap that will be added to it.
     */
    @Override
    public void add(T item) {
        /* TODO */ //done
    	heap.add(item); //adds item to heap, need to heapify up
    	location.put(item, this.size() - 1); //location of item before heapify
    	//System.out.println(location.get(item));
    	
    	heapifyUp(location.get(item)); // heapify on item which is at location.get(item)
    }

    /**
     * 
     *
     * @return Returns the minimum element of the heap without removing it.
     */
    @Override
    public T getMin() {
        return heap.get(0);
    }

    /**
     * Removes the minimum element from the heap and returns it.
     *
     * @return The minimum element that was in the heap when the method was invoked.
     */
    @Override
    public T extractMin() {
        /* TODO */ //done
    	swap(0, heap.size() - 1);
    	T toReturn = heap.get(heap.size() - 1);
    	location.remove(heap.get(heap.size() - 1));
    	heap.remove(heap.size() - 1);
    	
    	//heapify down on root
    	heapifyDown(0); 
    	
        return toReturn;
    }

    /**
     * Anytime the key decreases for an element in the heap, this method must be
     * invoked to restored the heap property. Here, key refers to the value
     * determining the ordering of heap elements as used in the Comparator.
     *
     * @param item An item in the heap that has had its key decreased.
     */
    @Override
    public void keyDecreased(T item) {
        /* TODO */
    	heapifyUp(location.get(item));
    }
    
    /**
     * Helper method, called when an element is added or a key is decreased. 
     * Restores the heap property. 
     * 
     * @param i Index of the item to perform heapify up on
     */
    private void heapifyUp(int i) { 
    	if (i > 0) {
    		int j = (i - 1)/ 2; //j is parent. 
    		if (comp.compare(heap.get(i), heap.get(j)) < 0){
    			swap(i, j);
    			heapifyUp(j);
    		}
    	}
    }
    
    /**
     * Helper method, called when min element is removed.
     * Restores the min heap property.
     * 
     * @param i Index of the item to perform heapify down on
     */
    private void heapifyDown(int i) {
    	int n = heap.size() - 1;
    	T j= null;
    	if ((2 * i) + 1 > n) { //if leaf node 
    		return;
    	} else if ((2 * i) + 2 <= n) { // has two children nodes
    		int left = (2 * i) + 1;
    		int right = (2 * i) + 2;
    		if (comp.compare(heap.get(left), heap.get(right)) <= 0) {
    			j = heap.get(left);
    		} else if (comp.compare(heap.get(left), heap.get(right)) > 0) {
    			j = heap.get(right);
    		}
    	} else if ((2 * i) + 1== n) { // only has left child
    		j = heap.get((2 * i) + 1);
    	}
    	
    	if (comp.compare(j, heap.get(i)) < 0) {
    		swap(i, location.get(j));
    		heapifyDown(location.get(j));
    	}
    }
    
    /**
     * Helper method: swaps items in heap at indexes i and j
     * 
     * @param i Index of item to be swapped
     * @param j Index of item to be swapped
     */
    private void swap(int i, int j) {    	
    	T item1 = heap.get(i); //first item to be swapped
    	T item2 = heap.get(j); //second item to be swapped
    	
    	//swap locations first
    	//location of item1 is location of item2 and temp is the original location of item1 
    	//int locationTemp = location.replace(item1, j);
    	location.replace(item1, j);
    	//location of item2 is temp
    	location.replace(item2, i);
    	
    	//System.out.println("a location: " + location.get(item1) + "\nb location: " + location.get(item2));
    	//then swap places in heap 
    	T heapTemp = heap.get(i);
    	heap.set(i, heap.get(j));
    	heap.set(j, heapTemp);
    	
    }
}
