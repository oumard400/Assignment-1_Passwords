package DataStructures;

import java.util.NoSuchElementException;

import Exceptions.RecipientException;

/**
*The RecipientLine class holds the relevant information to simulate adding recipients to a queue, and removing them.  
*@author Oumar Diallo
*/
public class RecipientLine<T> implements RecipientLineInterface {
	
	private MyQueue<Recipient> node = new MyQueue<Recipient>();


	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully , false if queue is full
	 */
	
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		// TODO Auto-generated method stub
		if(node.size() < 5)
		{
			node.enqueue(rc);
			
			return true;	
		}
		else{
			return false;	
		}
	}
	
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws NoSuchElementException if there is no Recipient in the line
	 */
	public Recipient recipientTurn() throws NoSuchElementException {
		
		if(node.isEmpty() == true)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return node.dequeue();
			
		}
	}

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean recipientLineEmpty() {
		if(node.isEmpty() == true)
		{
			return true;
		}
		else{
			return false;	
		}
	}

	/**
	 * Returns an array of the Recipients in the queue
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient() {
		
		return node.toArray();
	}

	

}
