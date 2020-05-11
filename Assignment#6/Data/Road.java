package Data;

/**
 * 
 * @author Oumar Diallo
 */
public class Road implements Comparable<Road>{

	private int weight;          //To hold Edge Weight

	private String name;         //To hold name

	private Town source;         //To hold source

	private Town dest;           //To hold destination

	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.dest = destination;
		this.weight = weight;
		this.name = name;
	}

	//Constructor with weight preset at 1
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.dest = destination;
		this.weight = 1;
		this.name = name;
	}

	public Road(Road templateRoad) {
		this(templateRoad.source, templateRoad.dest, 
				templateRoad.weight, templateRoad.name);
	}

	//Returns true only if the edge contains the given town

	public boolean contains(Town town) {

		return source.getName().equals(town.getName()) ||
				dest.getName().equals(town.getName());
	}

	//Returns true if each of the ends of the road r is the same as
	//the ends of this road 
	public boolean equals(Object r) {

		Road road = (Road) r;

		return (road.dest.equals(this.dest) 
				&& road.source.equals(this.source)) || 
				(road.dest.equals(this.source) 
						&& road.source.equals(this.dest));
	}

	//Returns the second town on the road
	public Town getDestination() {
		return dest;
	}

	//Returns the road name

	public String getName() {
		return name;
	}

	//Returns the first town on the road
	public Town getSource() {
		return source;
	}

	//Returns the distance of the road
	public int getWeight() {
		return weight;
	}

	//Compares the name of two roads
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.name);
	}

	//To string method
	@Override
	public String toString() {
		return name + "," + weight + ";" + source + ";" + dest;
	}
}