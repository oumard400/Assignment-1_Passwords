package Tests;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Data.TownGraphManager;
import Data.TownGraphManagerInterface;

/**
 * @author Oumar Diallo
 * 
 */

public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface stuGraph;
	private String[] TownStu;

	@Before
	public void setUp() throws Exception {
		stuGraph = new TownGraphManager();
		TownStu = new String[12];

		for (int i = 1; i < 12; i++) {
			TownStu[i] = "Town" + i;
			stuGraph.addTown(TownStu[i]);
		}

		stuGraph.addRoad(TownStu[1], TownStu[2], 2, "Road9");
		stuGraph.addRoad(TownStu[1], TownStu[3], 4, "Road12");
		stuGraph.addRoad(TownStu[1], TownStu[5], 6, "Road7");
		stuGraph.addRoad(TownStu[3], TownStu[7], 1, "Road3");
		stuGraph.addRoad(TownStu[3], TownStu[8], 2, "Road8");
		stuGraph.addRoad(TownStu[4], TownStu[8], 3, "Road6");
		stuGraph.addRoad(TownStu[6], TownStu[9], 3, "Road2");
		stuGraph.addRoad(TownStu[9], TownStu[10], 4, "Road11");
		stuGraph.addRoad(TownStu[8], TownStu[10], 2, "Road10");
		stuGraph.addRoad(TownStu[5], TownStu[10], 5, "Road4");
		stuGraph.addRoad(TownStu[10], TownStu[11], 3, "Road1");
		stuGraph.addRoad(TownStu[2], TownStu[11], 6, "Road5");

	}

	@After
	public void tearDown() throws Exception {
		stuGraph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = stuGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road12", roads.get(3));
		stuGraph.addRoad(TownStu[4], TownStu[11], 1,"Road13");
		roads = stuGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road12", roads.get(3));
		assertEquals("Road13", roads.get(4));

	}

	@Test
	public void testGetRoad() {
		assertEquals("Road5", stuGraph.getRoad(TownStu[2], TownStu[11]));
		assertEquals("Road3", stuGraph.getRoad(TownStu[3], TownStu[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, stuGraph.containsTown("Town12"));
		stuGraph.addTown("Town12");
		assertEquals(true, stuGraph.containsTown("Town12"));
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, stuGraph.containsTown("Town2"));
		assertEquals(false, stuGraph.containsTown("Town12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, stuGraph.containsRoadConnection(TownStu[2], TownStu[11]));
		assertEquals(false, stuGraph.containsRoadConnection(TownStu[3], TownStu[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = stuGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road8", roads.get(10));
		assertEquals("Road9", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, stuGraph.containsRoadConnection(TownStu[2], TownStu[11]));
		stuGraph.deleteRoadConnection(TownStu[2], TownStu[11], "Road5");
		assertEquals(false, stuGraph.containsRoadConnection(TownStu[2], TownStu[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, stuGraph.containsTown("Town2"));
		stuGraph.deleteTown(TownStu[2]);
		assertEquals(false, stuGraph.containsTown("Town2"));
	}


	@Test
	public void testAllTowns() {
		ArrayList<String> roads = stuGraph.allTowns();
		assertEquals("Town1", roads.get(0));
		assertEquals("Town10", roads.get(1));
		assertEquals("Town11", roads.get(2));
		assertEquals("Town2", roads.get(3));
		assertEquals("Town8", roads.get(9));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = stuGraph.getPath(TownStu[1],TownStu[11]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town1 via Road9 to Town2 2 miles",path.get(0).trim());
		assertEquals("Town2 via Road5 to Town11 6 miles",path.get(1).trim());
		assertEquals("Total miles: 8 miles",path.get(2).trim());

	}

	@Test
	public void testGetPathA() {
		ArrayList<String> path = stuGraph.getPath(TownStu[1],TownStu[10]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town1 via Road12 to Town3 4 miles",path.get(0).trim());
		assertEquals("Town3 via Road8 to Town8 2 miles",path.get(1).trim());
		assertEquals("Town8 via Road10 to Town10 2 miles",path.get(2).trim());
		assertEquals("Total miles: 8 miles",path.get(3).trim());
	}

	@Test
	public void testGetPathB() {
		ArrayList<String> path = stuGraph.getPath(TownStu[1],TownStu[6]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town1 via Road12 to Town3 4 miles",path.get(0).trim());
		assertEquals("Town3 via Road8 to Town8 2 miles",path.get(1).trim());
		assertEquals("Town8 via Road10 to Town10 2 miles",path.get(2).trim());
		assertEquals("Town10 via Road11 to Town9 4 miles",path.get(3).trim());
		assertEquals("Town9 via Road2 to Town6 3 miles",path.get(4).trim());
		assertEquals("Total miles: 15 miles",path.get(5).trim());

	}
}