package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LinkedList.BasicDoubleLinkedList;

/**
 * 
 * @author Oumar Dialllo
 */
public class BasicDoubleLinkedListTest_STUDENT_TEST {
	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparator;

	@Before
	public void setUp() throws Exception {

		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(52.0);
		linkedDouble.addToEnd(45.0);

		comparator = new DoubleComparator();

	}

	@After
	public void tearDown() throws Exception {
		linkedDouble = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedDouble.getSize());
	}
	/**
	 * To test addToEnd for the linkedDouble
	 */
	@Test
	public void testAddToEnd(){

		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
	}

	/**
	 * To test addToFront for the linkedDouble
	 */
	@Test
	public void testAddToFront(){

		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
	}

	/**
	 * To test getFirst for the linkedDouble
	 */
	@Test
	public void testGetFirstSTUDENT(){

		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(12.0);
		assertEquals(new Double(12.0), linkedDouble.getFirst());
	}

	/**
	 * To test getLast for the linkedDouble
	 */
	@Test
	public void testGetLast(){

		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(78.0);
		assertEquals(new Double(78.0), linkedDouble.getLast());
	}

	/**
	 * To test toArray for the linkedDouble
	 */
	@Test
	public void testToArray(){

		ArrayList<Double> list;
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		list = linkedDouble.toArrayList();
		assertEquals(new Double(21.0), list.get(0));
		assertEquals(new Double(52.0), list.get(1));
		assertEquals(new Double(45.0), list.get(2));
		assertEquals(new Double(19.0), list.get(3));
	}

	/**
	 * To test the iterator for the linkedDouble
	 */
	@Test
	public void testIteratorSuccessfulNext(){

		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
	}

	@Test
	public void testIteratorSuccessfulPrevious(){

		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(45.0), iterator.previous());		
		assertEquals(new Double(52.0), iterator.previous());
	}


	@Test
	public void testIteratorNoSuchElementExceptionNext(){

		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
		try {

			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException",true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}

	@Test
	public void testIteratorNoSuchElementExceptionPrevious(){

		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(new Double(19.0), iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(19.0), iterator.previous());
		assertEquals(new Double(45.0), iterator.previous());
		assertEquals(new Double(52.0), iterator.previous());
		assertEquals(new Double(21.0), iterator.previous());
		try {

			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException",true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}	
	}

	@Test
	public void testIteratorUnsupportedOperationException(){

		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
		try {

			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	/**
	 * To test the remove method for the linkedDouble
	 */
	@Test
	public void testRemove(){

		assertEquals(new Double(52.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
		linkedDouble.remove(21.0, comparator);
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		//remove from the end of the list
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
		linkedDouble.remove(19.0, comparator);
		assertEquals(new Double(45.0), linkedDouble.getLast());
		//remove from middle of list
		linkedDouble.addToFront(38.0);
		assertEquals(new Double(38.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.remove(52.0, comparator);
		assertEquals(new Double(38.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
	}

	/**
	 * To test retrieveLastElement for linkedDouble
	 */
	@Test
	public void testRetrieveFirstElement(){

		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
		assertEquals(new Double(21.0), linkedDouble.retrieveFirstElement());
		assertEquals(new Double(52.0),linkedDouble.getFirst());
		assertEquals(new Double(52.0), linkedDouble.retrieveFirstElement());
		assertEquals(new Double(45.0),linkedDouble.getFirst());
	}

	/**
	 * To test retrieveLastElement for linkedDouble
	 */
	@Test
	public void testRetrieveLastElement(){

		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
		assertEquals(new Double(19.0), linkedDouble.retrieveLastElement());
		assertEquals(new Double(45.0),linkedDouble.getLast());
	}

	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

}