package DataStructures;

/**
 * This DonationPackage class holds the relevant information of a package to be donated: description, weight
 * @author Oumar Diallo
 */
public class DonationPackage {

	private static final int MAX_WEIGHT = 20;
	private String packageDescription;   // Declares variable to hold the packages description
	private double packageWeight;   	// Declares variable to hold the packages weight


	/**
	 * The DonationPackage constructor, which will set the package description and weight
	 * @param description the package description
	 * @param weight the package name
	 */
	public DonationPackage (String description, double weight)
	{
		packageDescription = description;

		packageWeight = weight;	
	}


	/**
	 * Will take the String parameter passed in, and assign that as the package description
	 * @param description the package description
	 */
	public void setDescription(String description) {
		this.packageDescription = description;
	}

	/**
	 * Will take the double parameter passed in, and assign that as the package weight
	 * @param weight the package name
	 */
	public void setWeight(double weight) {
		this.packageWeight = weight;
	}


	/**
	 * Will return the description of the package
	 * @return the packages description
	 */
	public String getDescription() {
		return packageDescription;
	}


	/**
	 * Will return the weight of the package
	 * @return the packages weight
	 */
	public double getWeight() {
		return packageWeight;
	}


	/**
	 * Will return a string representation of the package
	 * @return the package name
	 */
	public String toString() {

		String name = packageDescription;

		return name;
	}


	@SuppressWarnings("unused")
	public boolean isHeavy() {
		// TODO Auto-generated method stub

		if (MAX_WEIGHT < 20) 
			return false;
		else
		return true;
	}

}




