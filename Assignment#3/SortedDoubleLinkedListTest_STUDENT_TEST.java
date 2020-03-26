package Tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LinkedList.SortedDoubleLinkedList;


/**
 * Student JUnit for testing sorted doubly-linked list
 * @author Oumar Diallo
 */
public class SortedDoubleLinkedListTest_STUDENT_TEST {
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;


	@Before
	public void setUp() throws Exception {

		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparatorD = null;
		sortedLinkedDouble = null;
	}

	@Test
	public void testAddToEndSTUDENT() {
		try {
			sortedLinkedDouble.addToEnd(17.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFrontSTUDENT() {
		try {
			sortedLinkedDouble.addToFront(10.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}


	@Test
	public void testIteratorSuccessfulDoubleNext_STUDENT() {
		sortedLinkedDouble.add(45.0);
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(19.0);
		sortedLinkedDouble.add(21.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulDoublePrevious_STUDENT() {
		sortedLinkedDouble.add(45.0);
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(19.0);
		sortedLinkedDouble.add(21.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(52.0), iterator.previous());
		assertEquals(new Double(45.0), iterator.previous());
		assertEquals(new Double(21.0), iterator.previous());
	}

	@Test
	public void testIteratorNoSuchElementException_STUDENT() {
		sortedLinkedDouble.add(45.0);
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(19.0);
		sortedLinkedDouble.add(21.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(52.0), iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}


	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedDouble.add(45.0);
		sortedLinkedDouble.add(59.0);
		sortedLinkedDouble.add(18.0);
		sortedLinkedDouble.add(21.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAdd_STUDENT() {
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(18.0);
		sortedLinkedDouble.add(45.0);
		assertEquals(new Double(18.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(21.0);
		sortedLinkedDouble.add(38.0);
		assertEquals(new Double(18.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		assertEquals(new Double(52.0),sortedLinkedDouble.retrieveLastElement());
		assertEquals(new Double(45.0), sortedLinkedDouble.getLast());
	}


	@Test
	public void testRemoveFirst_STUDENT() {
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(18.0);
		assertEquals(new Double(18.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(12.0);
		assertEquals(new Double(12.0), sortedLinkedDouble.getFirst());
		sortedLinkedDouble.remove(12.0, comparatorD);
		assertEquals(new Double(18.0), sortedLinkedDouble.getFirst());
	}

	@Test
	public void testRemoveEnd_STUDENT() {
		sortedLinkedDouble.add(45.0);
		sortedLinkedDouble.add(21.0);
		assertEquals(new Double(21.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(45.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(76.0);
		assertEquals(new Double(76.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.remove(76.0, comparatorD);
		assertEquals(new Double(45.0), sortedLinkedDouble.getLast());
	}

	@Test
	public void testRemoveMiddle_STUDENT() {
		sortedLinkedDouble.add(52.0);
		sortedLinkedDouble.add(18.0);
		assertEquals(new Double(18.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(12.0);
		assertEquals(new Double(12.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		assertEquals(3,sortedLinkedDouble.getSize());
		//remove from middle of list
		sortedLinkedDouble.remove(18.0, comparatorD);
		assertEquals(new Double(12.0), sortedLinkedDouble.getFirst());
		assertEquals(new Double(52.0), sortedLinkedDouble.getLast());
		assertEquals(2,sortedLinkedDouble.getSize());
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
