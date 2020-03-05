package DataStructures;

import java.util.EmptyStackException;

import Exceptions.ContainerException;

/**
 * The Container class holds the relevant information to simulate stacking and removing DonationPackages
 * @author Oumar Diallo
 */
public class Container<T> implements ContainerInterface {

	private int size = 5;           // size of the stack
	private MyStack<T> stack;
	
	private MyStack<DonationPackage> node = new MyStack<DonationPackage>();

	public Container(int index) {
		// TODO Auto-generated constructor stub
		size = index;
	}


	/**
	 * Stacks a new donation package in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 */
	public boolean loadContainer(DonationPackage dPackage) {

		if(node.size() < 5)
		{
			node.push(dPackage);

			return true;	
		}
		else{
			return false;	
		}
	}

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws EmptyStackException an EmptyStackException if there is no package in
	 * the container.
	 */
	public DonationPackage removePackageFromContainer() throws EmptyStackException {

		if(node.isEmpty() == true)
		{
			throw new EmptyStackException();
		}
		else
		{
			return node.pop();
		}
	}

	/**
	 * check if Container is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean containerLineEmpty() {
		if(node.isEmpty() == true)
		{
			return true;
		}
		else{
			return false;	
		}
	}

	/**
	 * @return an array of objects from the container stack
	 */
	public DonationPackage[] toArrayPackage() throws ContainerException{
		
		return node.toArray();
		
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}

