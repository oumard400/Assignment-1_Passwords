package DataStructures;

public class MyQueue<T> implements QueueInterface<T>{
	
	private Class<T> type;
	private T[] data;       // Declares a generic array, which will be used to hold the contents of a type to be specified, in the queue.  
	private int size;       // Declares variable to hold the size of the queue
	private int maxItems; // Declares variable to hold the number of elements in the queue. 
	private int front;      // Declares variable to hold the position of the first element thats in queue
	private int rear;       //  Declares variable to hold the position of the last element thats in queue
	
	@SuppressWarnings("unchecked")
	public MyQueue() {
		this.type = type;
		
		size = 5;      	 
		maxItems = 0;	
		front = 0;
		rear = 0;
		data = (T[]) new Object[size];
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(maxItems == 0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(maxItems == size)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		int frontLocation;
		if(maxItems == 0)
		{
			return null;
		}
		else
		{
			frontLocation = front;
			front = (front + 1) % size;
			maxItems = maxItems - 1;
			
			return data[frontLocation];
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return maxItems;
	}
	@Override
	public boolean enqueue(T e) {
		// TODO Auto-generated method stub
		if(maxItems == size)
		{
			return false;  // ** overflow error **
		}
		else
		{
			maxItems = maxItems + 1;
			data[rear] = e;
			rear = (rear + 1) % size; // % keeps rear in bounds
			return true;  // Enqueue operation successful
		}
	}
	@Override
	public Recipient[] toArray() {
		// TODO Auto-generated method stub
		// Initialize the array to hold 5 empty elements to begin with. 
				Object[] elements =  {" ", " ", " ", " ", " "};

				for(int i = 0; i < maxItems ; i++)
				{	
					elements[i] = data[(front + i) % size];	// Use the % size, to keep the array from going out of bounds
				}
				return (Recipient[]) elements;
			}
	}
	