package jUnitTests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DataStructures.Container;
import DataStructures.DonationPackage;
import Exceptions.ContainerException;

/**
 * 
 * @author revised by Professor Kartchner
 *
 */
public class ContainerTest {
	Container aContainer;
	DonationPackage dpk1, dpk2 ,dpk3,dpk4,dpk5,dpk6;
	@Before
	public void setUp() throws Exception {
		dpk1 = new DonationPackage("Pens", 10);
		dpk2 = new DonationPackage("Books", 12);
		dpk3 = new DonationPackage("Papers", 5);
		dpk4 = new DonationPackage("Folders", 9);
		dpk5 = new DonationPackage("Erasers", 10);
		dpk6 = new DonationPackage("Miscellaneous", 10);
		aContainer = new Container(5);
	}

	@After
	public void tearDown() throws Exception {
		dpk1=dpk2=dpk3=dpk4=dpk5=dpk6=null;
		aContainer=null;
	}

	@Test
	public void testLoadContainer() {
		 
		assertTrue(aContainer.loadContainer(dpk1));
		assertTrue(aContainer.loadContainer(dpk2));
		assertTrue(aContainer.loadContainer(dpk3));
		assertTrue(aContainer.loadContainer(dpk4));
		assertTrue(aContainer.loadContainer(dpk5));
		
		assertTrue(aContainer.loadContainer(dpk6));
		 
	}
	@Test
	public void tesRemovePackageFromContainer() {
		DonationPackage temp;
		 
		aContainer.loadContainer(dpk1);
		aContainer.loadContainer(dpk2);
		temp= aContainer.removePackageFromContainer();
		assertEquals(temp.getDescription(), "Books");
		temp= aContainer.removePackageFromContainer();
		assertEquals(temp.getDescription(), "Pens");
		aContainer.removePackageFromContainer();

	}
	@Test
	public void testToArrayPackage() {
		aContainer.loadContainer(dpk1);


		aContainer.loadContainer(dpk2);
		aContainer.loadContainer(dpk3);
		aContainer.loadContainer(dpk4);
		aContainer.loadContainer(dpk5);
		try {
			assertEquals(aContainer.toArrayPackage()[0].getDescription(), "Pens");
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(aContainer.toArrayPackage()[1].getDescription(), "Books");
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(aContainer.toArrayPackage()[2].getDescription(), "Papers");
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(aContainer.toArrayPackage()[3].getDescription(), "Folders");
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(aContainer.toArrayPackage()[4].getDescription(), "Erasers");
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}