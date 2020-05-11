package Data;

/**
 *
 * @author Oumar Diallo
 */
public class Town implements Comparable<Town>{

	private String name;        //To hold town name

	//town's name
	public Town(String name) {
		this.name = name;
	}

	//An instance of Town
	public Town(Town templateTown) {
		this(templateTown.name);
	}

	//Returns the town's name	 
	public String getName() {
		return name;
	}

	//return the hash code for the name of the town
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	//Compare towns
	//return 0 if names are equal, a positive or negative number 
	//if the names are not equal
	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}

	//return true if the town names are equal, false if no
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
		return this.name.compareTo(town.name) == 0;
	}

	//String representation of town
	@Override
	public String toString(){
		return name;
	}
}