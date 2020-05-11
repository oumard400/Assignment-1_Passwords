package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author Oumar Diallo
 */
public class TownGraphManager implements TownGraphManagerInterface {

	//map representation
	private Graph graph = new Graph();

	//Gets a town with a given name
	//return the Town specified by the name, or null if town does not exist
	@Override
	public Town getTown(String name) {
		Town town = null;
		for (Town t : graph.vertexSet()) {
			if (t.getName().equals(name)) {
				town = t;
			}
		}
		return town;
	}

	//Creates an arraylist of all road titles in sorted order by road name
	//return an arraylist of all road titles in sorted order by road name
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		for (Road r : graph.edgeSet()) {
			roads.add(r.getName());
		}
		Collections.sort(roads);
		return roads;
	}

	//Creates an arraylist of all towns in alphabetical order (last name, first name)
	//returns an arraylist of all towns in alphabetical order (last name, first name)
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		for (Town t : graph.vertexSet()) {
			towns.add(t.getName());
		}
		Collections.sort(towns);
		return towns;
	}

	//Returns the shortest path from town 1 to town 2
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	//Adds a road with 2 towns and a road name
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		return graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null;
	}

	//Returns the name of the road that both towns are connected through
	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	//Adds a town to the graph
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	//Determines if a town is already in the graph
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(getTown(v));
	}

	//Determines if a road is in the graph
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	//Deletes a town from the graph
	//return true if the town was successfully deleted, false if not
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(getTown(v));
	}

	//Deletes a road from the graph
	//return true if the road was successfully deleted, false if not
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		int weight = 0;
		for (Road r : graph.edgeSet()) {
			if (r.getName().equals(getRoad(town1, town2))) {
				weight = r.getWeight();
			}
		}
		return graph.removeEdge(new Town(town1), 
				new Town(town2), weight, road) != null;
	}

	//Populate town graph with roads from file
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {

		Scanner sc = new Scanner(file);
		String[] roads;
		String inText;

		//loop to read file
		while (sc.hasNextLine()) {

			inText = sc.nextLine();
			roads = inText.split(";|,");

			graph.addVertex(new Town(roads[2]));
			graph.addVertex(new Town(roads[3]));
			graph.addEdge(new Town(roads[2]), new Town(roads[3]), Integer.parseInt(roads[1]), roads[0]);
		}

		sc.close();

	}

}