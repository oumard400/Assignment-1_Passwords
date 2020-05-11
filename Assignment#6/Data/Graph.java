package Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Oumar Diallo
 */
public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> towns = new HashSet<>();    //Towns in the graph

	private Set<Road> roads = new HashSet<>();    //Roads in the graph

	//List of shortest path from town A to town B    
	private ArrayList<String> shortestPath = new ArrayList<>();

	private Town destination;
	private int townZ;

	//Creates a new edge in this graph, going from the source vertex to the
	//target vertex, and returns the created edge.
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}

		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) { 
			throw new IllegalArgumentException();
		}

		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);

		return road;
	}

	//Returns an edge connecting source vertex to target vertex if such vertices 
	//and such edge exist in this graph. Otherwise returns null.
	//If any of the specified vertices is null returns null
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;

		for (Road r : roads) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				road = r;
			}
		}
		return road;
	}

	//Adds the specified vertex to this graph if not already present
	//return true if this graph did not already contain the specified vertex.
	@Override
	public boolean addVertex(Town v) {

		if (v == null) {
			throw new NullPointerException();
		}

		if (!towns.contains(v)) {
			towns.add(v);
			return true;
		}

		return false;
	}

	//Returns true if and only if this graph contains an edge going
	//from the source vertex to the target vertex
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		for (Road r : roads) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

	//Returns true if this graph contains the specified vertex
	@Override
	public boolean containsVertex(Town v) {
		return towns.contains(v);
	}

	//Returns a set of the edges contained in this grap
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	//Returns a set of all edges touching the specified vertex (also
	//referred to as adjacent vertices)
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<>();

		for (Road r : roads) {
			if (r.contains(vertex)) {
				edges.add(r);
			}
		}
		return edges;
	}

	//Removes an edge going from source vertex to target vertex, if such
	//vertices and such edge exist in this graph.
	//returns The removed edge, or null if no edge removed
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		if (sourceVertex == null || destinationVertex == null || description == null) {
			throw new NullPointerException();
		}

		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) { 
			throw new IllegalArgumentException();
		}

		Road road = null;
		for (Road r : roads) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex) &&
					r.getWeight() == weight && r.getName().equals(description)) {
				road = r;
			}
		}
		return roads.remove(road) ? road : null;
	}

	//Removes the specified vertex from this graph including all its touching edges if present
	//return true if the graph contained the specified vertex; false otherwise.
	@Override
	public boolean removeVertex(Town v) {
		return towns.remove(v);
	}

	//Returns a set of the vertices contained in this graph
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	//Find the shortest path from the sourceVertex to the destinationVertex
	//call the dijkstraShortestPath with the sourceVertex
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		destination = destinationVertex;
		dijkstraShortestPath(sourceVertex);
		String shortPath = "";
		int totalmiles = 0;

		ArrayList<String> arr = new ArrayList<String>();
		if(edgesOf(sourceVertex).size() == 0 || edgesOf(destinationVertex).size() == 0) {
			return arr;
		}

		for (int i = 0; i < shortestPath.size() - 1; i++) {

			Town source = new Town(shortestPath.get(i));
			Town destination = new Town(shortestPath.get(i + 1));
			Road road = getEdge(source, destination);
			totalmiles += road.getWeight();
			shortPath += source + " via " + road.getName() + " to " + destination 
					+ " " + road.getWeight() + " miles;";
		}

		shortestPath.clear();
		for (String step : shortPath.split(";")) {
			shortestPath.add(step);
		}

		shortestPath.add("Total miles: " + totalmiles + " miles");
		return shortestPath;
	}

	// Dijkstra's Shortest Path Method.  Internal structures are built which
	//hold the ability to retrieve the path, shortest distance from the
	//sourceVertex to all the other vertices in the graph, etc.
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {

		shortestPath.clear();
		Town[] rowsAndCols = new Town[towns.size()];
		int k = 0;

		for (Town t : towns) {
			rowsAndCols[k] = new Town(t);
			k++;
		}

		int[][] adjMatrix = new int[towns.size()][towns.size()];

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (i == j || !containsEdge(rowsAndCols[i], rowsAndCols[j])) {
					adjMatrix[i][j] = 0;
				}
				
				else {
					int weight = getEdge(rowsAndCols[i], rowsAndCols[j]).getWeight();
					adjMatrix[i][j] = adjMatrix[j][i] = weight;
				}
			}
		}

		int startTown = 0;
		for (Town t : rowsAndCols) {
			if (!t.equals(sourceVertex)) {
				startTown++;
			}
			
			else{
				break;
			}
		}

		townZ = 0;

		for (Town t : rowsAndCols) {
			if (!t.equals(destination)) {
				townZ++;
			} 
			
			else {
				break;
			}
		}

		int numOfTowns = adjMatrix[0].length; 
		int[] smallestWeights = new int[numOfTowns];
		boolean[] added = new boolean[numOfTowns];

		for (int townIndex = 0; townIndex < numOfTowns; townIndex++) {
			smallestWeights[townIndex] = Integer.MAX_VALUE;
			added[townIndex] = false;
		}

		smallestWeights[startTown] = 0;

		int[] parents = new int[numOfTowns];

		parents[startTown] = -1;

		for (int i = 1; i < numOfTowns; i++) {
			int nearestTown = -1;
			int smallestWeight = Integer.MAX_VALUE;

			for (int townIndex = 0; townIndex < numOfTowns; townIndex++) {

				if (!added[townIndex] && smallestWeights[townIndex] < smallestWeight) {

					nearestTown = townIndex;
					smallestWeight = smallestWeights[townIndex];
				}
			}

			added[nearestTown] = true;

			for (int townIndex = 0; townIndex < numOfTowns; townIndex++) {
				int roadDistance = adjMatrix[nearestTown][townIndex]; 

				if (roadDistance > 0 && 
						((smallestWeight + roadDistance) < smallestWeights[townIndex])) {

					parents[townIndex] = nearestTown;
					smallestWeights[townIndex] = smallestWeight + roadDistance;
				}
			}           
		}
		populatePathArrayList(townZ, parents); 
	}

	//Populate town with the order of towns to go from source to destination

	private void populatePathArrayList(int currentVertex, int[] parents) {

		if (currentVertex == -1) { 
			return; 
		} 

		populatePathArrayList(parents[currentVertex], parents); 
		int townIndex = 0;

		for (Town t : towns) {
			if (townIndex == currentVertex) {
				shortestPath.add(t.getName()); 
			}
			townIndex++;
		}
	} 

}
